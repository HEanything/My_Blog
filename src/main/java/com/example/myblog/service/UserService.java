package com.example.myblog.service;

import com.example.myblog.DTO.UserEmailCode;
import com.example.myblog.pojo2.BlogAdmin;
import com.example.myblog.pojo2.BlogUser;

import java.util.List;

public interface UserService {
    BlogUser findUserById(String userId);

    void register(String userId, String password, String email);

    void updatePWD(String newPWD, String userId);

    void updateMyselfInfo(String gender, String email, String phoneNumber, String userId);

    void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId);

    List<BlogUser> getUsersInfo();

    void deleteUser(String userId);

    void banUser(String userId);

    void unbanUser(String userId);

    //查找管理员
    BlogAdmin findAdminById(String userId);



//    public User findUserById(String userId);
//
//
//    public void register(String userId, String password,String email);
//
//    List<User> getUsersInfo();
//
//
//    void updatePWD(String newPWD);
//
//    void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId);
}
