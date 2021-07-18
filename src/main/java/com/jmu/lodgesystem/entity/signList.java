package com.jmu.lodgesystem.entity;

public class signList {
    private String storeid;
    private String userid;
    private String listid;
    private String username;
    private String childname;
    private String phone;
    private String school;
    private String grades;
    private String classes;
    public signList(String storeid,String userid,String listid,String username,String childname,String phone,String school,String grades,String classes){
        this.setStoreid(storeid);
        this.setUserid(userid);
        this.setUsername(username);
        this.setChildname(childname);
        this.setPhone(phone);
        this.setSchool(school);
        this.setGrades(grades);
        this.setClasses(classes);
        this.setListid(listid);
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
