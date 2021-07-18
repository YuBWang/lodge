package com.jmu.lodgesystem.entity;

import java.time.LocalDateTime;

public class Message {
    private int messageid;
    private String senderid;
    private String receiveid;
    private String messages;
    private LocalDateTime times;
    private String indent;
    private int status;
    public Message(int messageid,String senderid,String receiveid,String messages,LocalDateTime times,String indent,int status){
        this.setMessageid(messageid);
        this.setSenderid(senderid);
        this.setReceiveid(receiveid);
        this.setMessages(messages);
        this.setTimes(times);
        this.setIndent(indent);
        this.setStatus(status);
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(String receiveid) {
        this.receiveid = receiveid;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageid=" + messageid +
                ", senderid='" + senderid + '\'' +
                ", receiveid='" + receiveid + '\'' +
                ", messages='" + messages + '\'' +
                ", times=" + times +
                ", indent='" + indent + '\'' +
                ", status=" + status +
                '}';
    }
}
