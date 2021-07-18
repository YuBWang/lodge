package com.jmu.lodgesystem.entity;

import java.time.LocalDateTime;

public class Signin {
    private String signinid;
    private String storeid;
    private String userid;
    private  String orderid;
    private LocalDateTime times;
    private int status;
    private String tomessage;
    private String photolist;
    public Signin(String signinid,String storeid,String userid,String orderid,LocalDateTime times,int status,String tomessage,String photolist){
        this.setSigninid(signinid);
        this.setStoreid(storeid);
        this.setUserid(userid);
        this.setOrderid(orderid);
        this.setTimes(times);
        this.setStatus(status);
        this.setTomessage(tomessage);
        this.setPhotolist(photolist);
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSigninid() {
        return signinid;
    }

    public void setSigninid(String signinid) {
        this.signinid = signinid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTomessage() {
        return tomessage;
    }

    public void setTomessage(String tomessage) {
        this.tomessage = tomessage;
    }

    public String getPhotolist() {
        return photolist;
    }

    public void setPhotolist(String photolist) {
        this.photolist = photolist;
    }
}
