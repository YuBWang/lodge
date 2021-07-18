package com.jmu.lodgesystem.service.impl;

import com.jmu.lodgesystem.dao.UserMapper;
import com.jmu.lodgesystem.entity.User;
import com.jmu.lodgesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermap;

    @Override
    public List<User> findAll() {
        return usermap.findAll();
    }

    @Override
    public User findById(String account) {
        return usermap.findById(account);
    }

    @Override
    public int insertInfo(User user) {
        return usermap.insertInfo(user);

    }

    @Override
    public int deleByid(String account) {
        return usermap.deleByid(account);

    }

    @Override
    public int findAllCount() {
        return usermap.findAllCount();
    }
}
