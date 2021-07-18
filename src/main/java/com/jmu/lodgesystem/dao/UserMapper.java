package com.jmu.lodgesystem.dao;

import com.jmu.lodgesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有
    public List<User> findAll();

    //通过账号查询
    public User findById(@Param("account") String account);

    //插入
    public int insertInfo(User user);

    //删除
    public int deleByid(@Param("account") String account);
   //查询用户数
    public int findAllCount();

}
