package com.jmsAndActive;

/**
 * Created by ldz on 11/04/15.
 */
public class EmailResponseListener {
    /**
     * 写收到消息给发送者的反馈的逻辑
     */
    public void onReceiveMessage(String response){
        System.out.println("Receive response from EmailListener:  "+response);

    }
}
