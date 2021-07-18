package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.Orderlist;
import com.jmu.lodgesystem.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderlistMapper {
    public int insertOrder(Orderlist ord);
    public List<Orders> findByid(String id);
    public List<Orders> findByStatus(String id,int s);
    public List<Orders> findByid2(String id);
    public List<Orders> findByStatus2(String id,int s);
    public Orders findBylistId(String id);
    public int updateStatus(String id,int s);

}
