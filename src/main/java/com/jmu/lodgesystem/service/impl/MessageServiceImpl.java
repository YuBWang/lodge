package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.MessageMapper;
import com.jmu.lodgesystem.entity.Message;
import com.jmu.lodgesystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messages;
    @Override
    public int insertMessage(Message mess) {
       return messages.insertMessage(mess);
    }

    @Override
    public int deleteById(String id) {
        return messages.deleteById(id);
    }

    @Override
    public List<Message> findAll(String fr, String to, String id) {
        return messages.findAll(fr,to,id);
    }


    @Override
    public int findUnreadCount(String id) {
        return messages.findUnreadCount(id);
    }

    @Override
    public List<String> findallname(String id) {
        return messages.findallname(id);
    }

    @Override
    public Message findAllUnreadMessage(String fr, String to) {
        return messages.findAllUnreadMessage(fr,to);
    }

    @Override
    public List<String> findHadREadName(String id) {
        return messages.findHadREadName(id);
    }

    @Override
    public int upReadMessage(String fr, String to) {
        return messages.upReadMessage(fr,to);
    }

    @Override
    public int deleteMessage(String fr, String to, String id) {
        return messages.deleteMessage(fr,to,id);
    }


}
