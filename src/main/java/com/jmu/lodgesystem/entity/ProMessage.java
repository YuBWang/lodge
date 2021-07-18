package com.jmu.lodgesystem.entity;

public class ProMessage {
    private String storeid;
    private String productid;
    private String types;
    private String startday;
    private String endday;
    private Double allmoney;
    private Double earmoney;
    public ProMessage(String productid,String storeid,String types,String startday,String endday,Double allmoney,double earmoney){
        this.setStoreid(storeid);
        this.setProductid(productid);
        this.setTypes(types);
        this.setStartday(startday);
        this.setEndday(endday);
        this.setAllmoney(allmoney);
        this.setEarmoney(earmoney);

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

    public Double getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(Double allmoney) {
        this.allmoney = allmoney;
    }

    public Double getEarmoney() {
        return earmoney;
    }

    public void setEarmoney(Double earmoney) {
        this.earmoney = earmoney;
    }
}
