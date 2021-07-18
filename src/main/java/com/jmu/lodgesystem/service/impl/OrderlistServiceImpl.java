package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.OrderlistMapper;
import com.jmu.lodgesystem.entity.Orderlist;
import com.jmu.lodgesystem.entity.Orders;
import com.jmu.lodgesystem.service.OrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlistServiceImpl implements OrderlistService {
    @Autowired
    private OrderlistMapper ordmap;
    @Override
    public int insertOrder(Orderlist ord) {
        return ordmap.insertOrder(ord);
    }

    @Override
    public List<Orders> findByid(String id) {
        return ordmap.findByid(id);
    }

    @Override
    public List<Orders> findByStatus(String id, int s) {
        return ordmap.findByStatus(id,s);
    }

    @Override
    public List<Orders> findByid2(String id) {
        return ordmap.findByid2(id);
    }

    @Override
    public List<Orders> findByStatus2(String id, int s) {
        return ordmap.findByStatus2(id,s);
    }

    @Override
    public Orders findBylistId(String id) {
        return ordmap.findBylistId(id);
    }

    @Override
    public int updateStatus(String id, int s) {
        return ordmap.updateStatus(id,s);
    }
}
