package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Store;

import java.util.List;

public interface StoreService {
    public int insertStore(Store s);
    public int findAllCounts();
    public List<Store> findAll();
    public List<Store> findApply();
    public int findApplyCount();
    public Store findById(String storeid);
    public int upStoreData(String storeid);
    public int deleByid(String storeid);
    public List<Store> searchByName(String storeName);
    public Store findByid(String account);
    //通过经纬度范围来进行范围搜索
    public List<Store> searchBetween(double minLng, double minLat,double maxLng,double maxLat);
    public int upgrade(String id,double grades);
}
