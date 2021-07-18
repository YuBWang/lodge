package com.jmu.lodgesystem.entity;

public class Store {
    private String account;
    private String storeid;
    private String storename;
    private String licenseid;
    private String address;
    private String mobilephone;
    private String fixedphone;
    private String email;
    private String storephoto;
    private String fidcard;
    private String ridcard;
    private String licensephoto;
    private String inphoto1;
    private String inphoto2;
    private String inphoto3;
    private String inphoto4;
    private String describes;
    private String applytime;
    private double grade;
    private  double serviceattitude;
    private int datastate;
    private int storedata;
    private double longitue;
    private double latitude;
    public Store(String account,String storeid,String storename,String licenseid,String address,String mobilephone,String fixedphone,String email,String storephoto,String fidcard,String ridcard,String licensephoto,String inphoto1,String inphoto2,String inphoto3,String inphoto4,String describes,String applytime,double grade,double serviceattitude,int datastate,int storedata,double longitue,double latitude){
      this.setAccount(account);
      this.setStoreid(storeid);
      this.setStorename(storename);
      this.setLicenseid(licenseid);
      this.setAddress(address);
      this.setMobilephone(mobilephone);
      this.setFixedphone(fixedphone);
      this.setEmail(email);
      this.setStorephoto(storephoto);
      this.setFidcard(fidcard);
      this.setRidcard(ridcard);
      this.setLicensephoto(licensephoto);
      this.setInphoto1(inphoto1);
      this.setInphoto2(inphoto2);
      this.setInphoto3(inphoto3);
      this.setInphoto4(inphoto4);
      this.setDescribes(describes);
      this.setApplytime(applytime);
      this.setGrade(grade);
      this.setServiceattitude(serviceattitude);
      this.setDatastate(datastate);
      this.setStoredata(storedata);
      this.setLongitue(longitue);
      this.setLatitude(latitude);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getFixedphone() {
        return fixedphone;
    }

    public void setFixedphone(String fixedphone) {
        this.fixedphone = fixedphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStorephoto() {
        return storephoto;
    }

    public void setStorephoto(String storephoto) {
        this.storephoto = storephoto;
    }

    public String getFidcard() {
        return fidcard;
    }

    public void setFidcard(String fidcard) {
        this.fidcard = fidcard;
    }

    public String getRidcard() {
        return ridcard;
    }

    public void setRidcard(String ridcard) {
        this.ridcard = ridcard;
    }

    public String getLicensephoto() {
        return licensephoto;
    }

    public void setLicensephoto(String licensephoto) {
        this.licensephoto = licensephoto;
    }

    public String getInphoto1() {
        return inphoto1;
    }

    public void setInphoto1(String inphoto1) {
        this.inphoto1 = inphoto1;
    }

    public String getInphoto2() {
        return inphoto2;
    }

    public void setInphoto2(String inphoto2) {
        this.inphoto2 = inphoto2;
    }

    public String getInphoto3() {
        return inphoto3;
    }

    public void setInphoto3(String inphoto3) {
        this.inphoto3 = inphoto3;
    }

    public String getInphoto4() {
        return inphoto4;
    }

    public void setInphoto4(String inphoto4) {
        this.inphoto4 = inphoto4;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getServiceattitude() {
        return serviceattitude;
    }

    public void setServiceattitude(double serviceattitude) {
        this.serviceattitude = serviceattitude;
    }

    public int getDatastate() {
        return datastate;
    }

    public void setDatastate(int datastate) {
        this.datastate = datastate;
    }

    public int getStoredata() {
        return storedata;
    }

    public void setStoredata(int storedata) {
        this.storedata = storedata;
    }

    public double getLongitue() {
        return longitue;
    }

    public void setLongitue(double longitue) {
        this.longitue = longitue;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
