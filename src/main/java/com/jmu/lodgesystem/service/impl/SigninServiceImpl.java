package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.SigninMapper;
import com.jmu.lodgesystem.entity.Signin;
import com.jmu.lodgesystem.entity.signList;
import com.jmu.lodgesystem.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SigninServiceImpl implements SigninService {
    @Autowired
    private SigninMapper sigmap;
    @Override
    public List<signList> findSignList(String id) {
        return sigmap.findSignList(id);
    }

    @Override
    public int insertSign(Signin s) {
        return sigmap.insertSign(s);
    }

    @Override
    public String findSignid(String id) {
        return sigmap.findSignid(id);
    }

    @Override
    public List<Signin> findAll(String id) {
        return sigmap.findAll(id);
    }

    @Override
    public int upSignState(String sid, String uid, String listid) {
        return sigmap.upSignState(sid,uid,listid);
    }


    @Override
    public signList findSign(String sid, String uid, String listid) {
        return sigmap.findSign(sid,uid,listid);
    }

    @Override
    public List<Signin> findThree(String id, String listid) {
        return sigmap.findThree(id,listid);
    }


    @Override
    public int upPhotoList(String sid, String uid, String photo, String listid) {
        return sigmap.upPhotoList(sid,uid,photo,listid);
    }

    @Override
    public int upMessage(String sid, String uid, String messages, String listid) {
        return sigmap.upMessage(sid,uid,messages,listid);
    }


    @Override
    public Signin findSignOne(String sid, String uid, String listid) {
        return sigmap.findSignOne(sid,uid,listid);
    }


    @Override
    public Signin findTodaySign(String id) {
        return sigmap.findTodaySign(id);
    }

    @Override
    public Signin findeveryDay(String id, String data) {
        return sigmap.findeveryDay(id,data);
    }
}
