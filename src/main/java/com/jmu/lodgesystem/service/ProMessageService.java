package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.dao.ProMessageMapper;
import com.jmu.lodgesystem.entity.ProMessage;

import java.util.List;

public interface ProMessageService {
    public int inserts(ProMessage pro);
    public List<ProMessage> selectById(String storeid);
    public int deletById(String id);
    public ProMessage findByProId(String id);
}
