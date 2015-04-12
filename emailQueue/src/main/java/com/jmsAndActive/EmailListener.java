package com.jmsAndActive;
import com.email.Email;
import com.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Created by ldz on 11/04/15.
 * 使用MessageListenerAdapter之后就能简单的写普通的pojo类作为相关的处理类
 * 不用实现相关等饿接口
 * @see org.springframework.jms.listener.adapter.MessageListenerAdapter
 * onReceiveMessage 是必须有的
 */
public class EmailListener {
    @Autowired
    private EmailSender emailSender;
    /**
     * 写收到消息的逻辑
     * @param email 邮件对象，经过MessageConverter转换了
     * @return 给消息发送者的反馈
     * 处理发生异常的时候会回滚，重复3次 具体见重投递策略
     */
    public String onReceiveMessage(Email email){
        /**业务逻辑**/

        return "Receive success";
    }
}