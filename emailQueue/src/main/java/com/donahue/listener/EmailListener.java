package com.donahue.listener;

import com.donahue.entity.Email;
import org.springframework.jms.JmsException;

/**
 * Created by ldz on 11/04/15.
 * 使用MessageListenerAdapter之后就能简单的写普通的pojo类作为相关的处理类
 * 不用实现相关等饿接口
 * @see org.springframework.jms.listener.adapter.MessageListenerAdapter
 * onReceiveMessage 是必须有的
 */
public class EmailListener {
    private int num = 0;
    /**
     * 写收到消息的逻辑
     * @param email 邮件对象，经过MessageConverter转换了
     * @return 给消息发送者的反馈
     */
    public String onReceiveMessage(Email email){
        try {
            if (num <4) {
                //模拟异常


                System.err.println("Exception Email is: " + email);
                num++;
                throw new RuntimeException();
            }
        }catch (JmsException e){

           // e.printStackTrace();
            //return "Receive failure";

        }

        System.out.println(email);
        return "Receive success";
    }
}
