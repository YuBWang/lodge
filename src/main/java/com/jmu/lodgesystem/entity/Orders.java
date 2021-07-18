package com.jmu.lodgesystem.entity;

public class Orders {
    private String orderid;
    private String storeid;
    private String productid;
    private String userid;
    private String types;
    private  String startday;
    private String endday;
    private double allmoney;
    private double earmoney;
    private int status;
    public Orders(String orderid,String storeid,String productid,String userid,String types,String startday,String endday,double allmoney,double earmoney,int status){
        this.setOrderid(orderid);
        this.setStoreid(storeid);
        this.setProductid(productid);
        this.setUserid(userid);
        this.setTypes(types);
        this.setStartday(startday);
        this.setEndday(endday);
        this.setAllmoney(allmoney);
        this.setEarmoney(earmoney);
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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public double getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(double allmoney) {
        this.allmoney = allmoney;
    }

    public double getEarmoney() {
        return earmoney;
    }

    public void setEarmoney(double earmoney) {
        this.earmoney = earmoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
