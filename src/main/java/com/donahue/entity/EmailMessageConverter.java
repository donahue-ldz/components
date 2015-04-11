package com.donahue.entity;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */
public class EmailMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object msg, Session session) throws JMSException, MessageConversionException {
        return session.createObjectMessage((Serializable) msg);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        ObjectMessage objectMessage = (ObjectMessage)message;
        return  objectMessage.getObject();
    }
}
