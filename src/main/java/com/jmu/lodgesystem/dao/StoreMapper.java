package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    public int insertStore(Store s);
    //查找用户数
    public int findAllCounts();
    //查找所有的
    public List<Store> findAll();
    //查找所有的申请
    public List<Store> findApply();
    //查找申请用户数
    public int findApplyCount();
    //通过id查找
    public Store findById(String storeid);
    //更改显示为已开通
    public int  upStoreData(String storeid);
    //根据店铺号删除
    public int deleByid(String storeid);
    //通过店铺名查找
    public List<Store> searchByName(String storeName);
    //通过账号查找
    public Store findByid(String account);
    //通过经纬度范围来进行范围搜索
    public List<Store> searchBetween(double minLng, double minLat,double maxLng,double maxLat);
   //修改店铺评分
    public int upgrade(String id,double grades);
}
