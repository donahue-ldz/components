package com.jmsAndActive;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */
public interface EmailProducerService {
    /**
     *
     * @param destination
     * @param message
     * @param isAsync  是否异步发送
     */
    void sendMsg(Destination destination, final Serializable message,boolean isAsync);
}
