package com.jmu.lodgesystem.entity;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meals {
    private String meaid;
    private String storeid;
    private LocalDate times;
    private String photolist;
    public Meals(String meaid,String storeid,LocalDate times,String photolist){
        this.setMeaid(meaid);
        this.setStoreid(storeid);
        this.setTimes(times);
        this.setPhotolist(photolist);

    }

    public String getMeaid() {
        return meaid;
    }

    public void setMeaid(String meaid) {
        this.meaid = meaid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public LocalDate getTimes() {
        return times;
    }

    public void setTimes(LocalDate times) {
        this.times = times;
    }

    public String getPhotolist() {
        return photolist;
    }

    public void setPhotolist(String photolist) {
        this.photolist = photolist;
    }
}
