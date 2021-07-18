package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Message;

import java.util.List;

public interface MessageService {
    public int insertMessage(Message mess);
    public int deleteById(String id);
    public List<Message> findAll(String fr, String to,String id);
    public int findUnreadCount(String id);
    public List<String> findallname(String id);
    public Message findAllUnreadMessage(String fr,String to);
    public List<String> findHadREadName(String id);
    public int upReadMessage(String fr,String to);
    public int deleteMessage(String fr,String to,String id);
}
