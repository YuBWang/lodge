package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.ProMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProMessageMapper {
    public int inserts(ProMessage pro);
    public List<ProMessage> selectById(String storeid);
    public int deletById(String id);
    public ProMessage findByProId(String id);
}
