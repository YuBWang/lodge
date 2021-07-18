package com.jmu.lodgesystem.entity;

public class UseMessage {
    private String account;
    private String userid;
    private  String username;
    private String phone;
    private String childname;
    private String sex;
    private int age;
    private String school;
    private String grades;
    private String classes;
    private int status;
    public UseMessage(String account,String userid,String username,String phone,String childname,String sex,int age,String school,String grades,String classes,int status){
        this.setAccount(account);
        this.setUserid(userid);
        this.setUsername(username);
        this.setChildname(childname);
        this.setPhone(phone);
        this.setSex(sex);
        this.setAge(age);
        this.setSchool(school);
        this.setGrades(grades);
        this.setStatus(status);
        this.setClasses(classes);

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
