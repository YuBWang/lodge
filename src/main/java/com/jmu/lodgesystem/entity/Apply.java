package com.jmu.lodgesystem.entity;

public class Apply {
    private String storeid;
    private int applystatus;
    private String reasons;

    public Apply(String storeid,int applystatus,String reasons){
        this.setStoreid(storeid);
        this.setApplystatus(applystatus);
        this.setReasons(reasons);
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public int getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(int applystatus) {
        this.applystatus = applystatus;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "storeid='" + storeid + '\'' +
                ", applystatus=" + applystatus +
                ", reasons='" + reasons + '\'' +
                '}';
    }
}
