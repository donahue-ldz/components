package com.donahue.listener;

import com.donahue.entity.Email;

/**
 * Created by ldz on 11/04/15.
 */
public class EmailResponseListener {
    /**
     * 写收到消息的逻辑
     */
    public void onReceiveMessage(String response){
        System.out.println("Receive response from EmailListener"+response);

    }
}
