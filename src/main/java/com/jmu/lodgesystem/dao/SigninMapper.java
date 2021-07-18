package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Signin;
import org.apache.ibatis.annotations.Mapper;
import com.jmu.lodgesystem.entity.signList;

import java.util.List;

@Mapper
public interface SigninMapper {
    public List<signList> findSignList(String id);
    public int insertSign(Signin s);
    public String findSignid(String id);
    public List<Signin> findAll(String id);
    public int upSignState(String sid,String uid,String listid);
    public signList findSign(String sid,String uid,String listid);
    public List<Signin> findThree(String id,String listid);
    public int upPhotoList(String sid,String uid,String photo,String listid);
    public int upMessage(String sid,String uid,String messages,String listid);
    public Signin findSignOne(String sid,String uid,String listid);
    public Signin findTodaySign(String id);
    public Signin findeveryDay(String id,String data);
}
