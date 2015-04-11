package com.donahue.serviceImpl;

import com.donahue.entity.Email;
import com.donahue.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */
@Service("producerService")
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination responseQueue;
    @Override
    public void sendMsg(Destination destination, final Email message) {
        jmsTemplate.send(destination,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //调用createObjectMessage的时候。自动调用相关的MessageConverter的toMessage
                ObjectMessage objectMessage = session.createObjectMessage(message);

                objectMessage.setJMSReplyTo(responseQueue);  //设置接收回复的队列
                return objectMessage;
            }
        });
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
