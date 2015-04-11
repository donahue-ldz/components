package com.donahue.listener;

import com.donahue.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.*;

/**
 * Created by ldz on 11/04/15.
 */
public class ConsumerListener1 implements MessageListener {
    @Autowired
    MessageConverter converter ;
    @Override
    public void onMessage(Message message) {
        if(message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            /*try {
                    Object msg = objectMessage.getObject();
                    Email email = (Email)msg;
                    System.out.println("接收到一个ObjectMessage，包含Email对象。");
                    System.out.println(email);
            } catch (JMSException e) {
                e.printStackTrace();
            }*/

            //或者利用MessageConvert转换
            try {
                Email email = (Email)converter.fromMessage(objectMessage);
                System.out.println("接收到一个ObjectMessage，包含Email对象。");
                System.out.println(email);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public MessageConverter getConverter() {
        return converter;
    }

    public void setConverter(MessageConverter converter) {
        this.converter = converter;
    }
}
