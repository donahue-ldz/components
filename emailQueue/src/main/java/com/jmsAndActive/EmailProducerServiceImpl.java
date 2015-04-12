package com.jmsAndActive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */
@Service("emailProducerService")
public class EmailProducerServiceImpl implements EmailProducerService {
    private boolean isAsync;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination responseQueue;
    @Autowired
    private TaskExecutor messageSendTaskExecutor;
    @Override
    public void sendMsg(final Destination destination, final Serializable message,boolean isAsync) {
        if(isAsync == true) {
            messageSendTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    jmsTemplate.send(destination, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            //调用createObjectMessage的时候。自动调用相关的MessageConverter的toMessage
                            ObjectMessage objectMessage = session.createObjectMessage(message);

                            objectMessage.setJMSReplyTo(responseQueue);  //设置接收回复的队列

                            return objectMessage;
                        }
                    });
                }
            });

        }else{
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    //调用createObjectMessage的时候。自动调用相关的MessageConverter的toMessage
                    ObjectMessage objectMessage = session.createObjectMessage(message);

                    objectMessage.setJMSReplyTo(responseQueue);  //设置接收回复的队列

                    return objectMessage;
                }
            });
        }


    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Boolean getIsAsync() {
        return isAsync;
    }

    public void setIsAsync(Boolean isAsync) {
        this.isAsync = isAsync;
    }

    public TaskExecutor getMessageSendTaskExecutor() {
        return messageSendTaskExecutor;
    }

    public void setMessageSendTaskExecutor(TaskExecutor messageSendTaskExecutor) {
        this.messageSendTaskExecutor = messageSendTaskExecutor;
    }

    public Destination getResponseQueue() {
        return responseQueue;
    }

    public void setResponseQueue(Destination responseQueue) {
        this.responseQueue = responseQueue;
    }
}
