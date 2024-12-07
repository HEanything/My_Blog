package com.example.myblog.service.Impl;


import com.example.myblog.mapper.UserMapper;

import com.example.myblog.pojo.User;
import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String userId) {
        User u = userMapper.findUserById(userId);
        return u;
    }

    @Override
    public void register(String userId, String password,String email) {
        userMapper.register(userId, password, email);

    }
}
