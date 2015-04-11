package com.donahue.service;

import com.donahue.entity.Email;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */
public interface ProducerService {
    void sendMsg(Destination destination, final Email message);
}
