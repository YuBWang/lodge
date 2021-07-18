package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.Orderlist;
import com.jmu.lodgesystem.entity.Orders;

import java.util.List;

public interface OrderlistService {
    public int insertOrder(Orderlist ord);
    public List<Orders> findByid(String id);
    public List<Orders> findByStatus(String id,int s);
    public List<Orders> findByid2(String id);
    public List<Orders> findByStatus2(String id,int s);
    public Orders findBylistId(String id);
    public int updateStatus(String id,int s);
}
