package com.jmu.lodgesystem.entity;

public class Orderlist {
    private String orderid;
    private String storeid;
    private String productid;
    private String userid;
    private int status;
    public Orderlist(String orderid,String storeid,String productid,String userid,int status){
        this.setOrderid(orderid);
        this.setStoreid(storeid);
        this.setProductid(productid);
        this.setUserid(userid);
        this.setStatus(status);
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
