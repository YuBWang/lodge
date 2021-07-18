package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.ProMessageMapper;
import com.jmu.lodgesystem.entity.ProMessage;
import com.jmu.lodgesystem.service.ProMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProMessageImpl implements ProMessageService {
    @Autowired
    private  ProMessageMapper product;
    @Override
    public int inserts(ProMessage pro) {
       return product.inserts(pro);
    }

    @Override
    public List<ProMessage> selectById(String storeid) {
        return product.selectById(storeid);
    }

    @Override
    public int deletById(String id) {
        return product.deletById(id);
    }

    @Override
    public ProMessage findByProId(String id) {
        return product.findByProId(id);
    }


}
