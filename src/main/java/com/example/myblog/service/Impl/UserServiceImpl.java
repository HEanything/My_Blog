package com.example.myblog.service.Impl;


import com.example.myblog.mapper.UserMapper;

import com.example.myblog.pojo2.BlogUser;
import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BlogUser findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public void register(String userId, String password, String email) {
        userMapper.register(userId, password, email);
    }

    @Override
    public void updatePWD(String newPWD, String userId) {
        userMapper.updatePWD(newPWD, userId);
    }

    @Override
    public void updateMyselfInfo(String gender, String email, String phoneNumber, String userId) {
        userMapper.updateMyselfInfo(gender, email, phoneNumber, userId);
    }

    @Override
    public void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId) {
        userMapper.updateUserInfo(password, gender, email, phoneNumber, userId);
    }

    @Override
    public List<BlogUser> getUsersInfo() {
        return userMapper.getUsersInfo();
    }

    @Override
    public void deleteUser(String userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void banUser(String userId) {
        userMapper.banUser(userId);
    }

    @Override
    public void unbanUser(String userId) {
        userMapper.unbanUser(userId);
    }
//
//    @Override
//    public User findUserById(String userId) {
//        User u = userMapper.findUserById(userId);
//        return u;
//    }
//
//    @Override
//    public void register(String userId, String password,String email) {
//        userMapper.register(userId, password, email);
//
//    }
//
//    @Override
//    public List<User> getUsersInfo() {
//        return userMapper.getUsersInfo();
//    }
//
//
//    @Override
//    public void updatePWD(String newPWD) {
//        Map<String, Object> map = ThreadLocalUtil.get();
//        String userId = (String) map.get("userId");
//        userMapper.updatePWD(newPWD, userId);
//    }
//
//    @Override
//    public void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId) {
//        userMapper.updateUserInfo(password, gender, email, phoneNumber, userId);
//    }
}
