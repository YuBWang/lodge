package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.StoreMapper;
import com.jmu.lodgesystem.entity.Store;
import com.jmu.lodgesystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper stormap;
    @Override
    public int insertStore(Store s) {
        return stormap.insertStore(s);
    }

    @Override
    public int findAllCounts() {
        return stormap.findAllCounts();
    }

    @Override
    public List<Store> findAll() {
         return stormap.findAll();
    }

    @Override
    public List<Store> findApply() {
        return stormap.findApply();
    }

    @Override
    public int findApplyCount() {
        return stormap.findApplyCount();
    }

    @Override
    public Store findById(String storeid) {
        return stormap.findById(storeid);
    }

    @Override
    public int upStoreData(String storeid) {
        return stormap.upStoreData(storeid);
    }

    @Override
    public int deleByid(String storeid) {
        return stormap.deleByid(storeid);
    }

    @Override
    public List<Store> searchByName(String storeName) {
        return stormap.searchByName(storeName);
    }

    @Override
    public Store findByid(String account) {
        return stormap.findByid(account);
    }

    @Override
    public List<Store> searchBetween(double minLng, double minLat, double maxLng, double maxLat) {
        return stormap.searchBetween(minLng,minLat,maxLng,maxLat);
    }

    @Override
    public int upgrade(String id, double grades) {
        return stormap.upgrade(id,grades);
    }
}
