package com.example.myblog.service;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo.User;

public interface UserService {


    public User findUserById(String userId);


    public void register(String userId, String password,String email);
}
