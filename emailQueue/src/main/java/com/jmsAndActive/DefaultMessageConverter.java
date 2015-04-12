package com.jmsAndActive;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by ldz on 11/04/15.
 * 重写自己感兴的方法就好
 * 一般都没有必要重写
 */
public class DefaultMessageConverter extends SimpleMessageConverter {
    @Override
    protected Serializable extractSerializableFromMessage(ObjectMessage message) throws JMSException {
        return super.extractSerializableFromMessage(message);
    }

    public DefaultMessageConverter() {
        super();
    }

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        return super.toMessage(object, session);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return super.fromMessage(message);
    }

    @Override
    protected TextMessage createMessageForString(String text, Session session) throws JMSException {
        return super.createMessageForString(text, session);
    }

    @Override
    protected BytesMessage createMessageForByteArray(byte[] bytes, Session session) throws JMSException {
        return super.createMessageForByteArray(bytes, session);
    }

    @Override
    protected MapMessage createMessageForMap(Map<?, ?> map, Session session) throws JMSException {
        return super.createMessageForMap(map, session);
    }

    @Override
    protected ObjectMessage createMessageForSerializable(Serializable object, Session session) throws JMSException {
        return super.createMessageForSerializable(object, session);
    }

    @Override
    protected String extractStringFromMessage(TextMessage message) throws JMSException {
        return super.extractStringFromMessage(message);
    }

    @Override
    protected byte[] extractByteArrayFromMessage(BytesMessage message) throws JMSException {
        return super.extractByteArrayFromMessage(message);
    }

    @Override
    protected Map<String, Object> extractMapFromMessage(MapMessage message) throws JMSException {
        return super.extractMapFromMessage(message);
    }
}
