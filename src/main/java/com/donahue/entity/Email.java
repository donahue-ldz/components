package com.donahue.entity;

import java.io.Serializable;

/**
 * Created by ldz on 11/04/15.
 */

public class Email implements Serializable {
    private String reciever;
    private String subject;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    @Override
    public String toString() {
        return "Email{" +
                "reciever='" + reciever + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
