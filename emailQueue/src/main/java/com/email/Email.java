package com.email;

import java.util.Map;

/**邮件实体类
 * Created by ldz on 21/11/14.
 */
public class Email {
    private String to;  //主送地址；
    private String cc;  //抄送地址；
    private String bcc;  //暗送地址;
    private String subject; //邮件标题
    private String content;  //普通的文本
    private Map<String, Object> Context; //被填充的数据，用与模板操作

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getContext() {
        return Context;
    }

    public void setContext(Map<String, Object> context) {
        Context = context;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", subject='" + subject + '\'' +
                ", Context=" + Context +
                '}';
    }
}
