package com.jmu.lodgesystem.service;

import com.jmu.lodgesystem.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查询所有
    public List<User> findAll();

    //通过账号查询
    public User findById(String account);

    //插入
    public int insertInfo(User user);

    //删除
    public int deleByid(String account);
    //查询用户数
    public int findAllCount();

}
