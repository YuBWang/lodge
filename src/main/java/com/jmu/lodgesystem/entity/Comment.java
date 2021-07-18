package com.jmu.lodgesystem.entity;

public class Comment {
    private String storeid;
    private String productid;
    private String userid;
    private String orderid;
    private double grade;
    private String message;
    public Comment(String storeid,String productid,String userid,String orderid,double grade,String message){
        this.setStoreid(storeid);
        this.setProductid(productid);
        this.setUserid(userid);
        this.setGrade(grade);
        this.setMessage(message);
        this.setOrderid(orderid);
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
