package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.UseMessage;

public interface UseMessageService {
    public int insertInfo(UseMessage us);
    public int updateInfo(UseMessage us);
    public UseMessage findByuseid(String id);
    public UseMessage findByuseid1(String id);
    public int findAgeCount(String id,int low,int hight);
    public int findSexCount(String id,String sex,int low,int hight);
}
