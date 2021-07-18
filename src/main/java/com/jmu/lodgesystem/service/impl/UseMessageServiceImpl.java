package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.UseMessageMapper;
import com.jmu.lodgesystem.entity.UseMessage;
import com.jmu.lodgesystem.service.UseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseMessageServiceImpl implements UseMessageService {
    @Autowired
    private UseMessageMapper usemap;

    @Override
    public int insertInfo(UseMessage us) {
        return usemap.insertInfo(us);
    }

    @Override
    public int updateInfo(UseMessage us) {
        return usemap.updateInfo(us);
    }

    @Override
    public UseMessage findByuseid(String id) {
        return usemap.findByuseid(id);
    }

    @Override
    public UseMessage findByuseid1(String id) {
        return usemap.findByuseid1(id);
    }

    @Override
    public int findAgeCount(String id, int low, int hight) {
        return usemap.findAgeCount(id,low,hight);
    }

    @Override
    public int findSexCount(String id, String sex, int low, int hight) {
        return usemap.findSexCount(id,sex,low,hight);
    }


}
