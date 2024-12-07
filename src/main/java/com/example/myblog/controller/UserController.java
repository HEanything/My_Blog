package com.example.myblog.controller;


import com.example.myblog.pojo.Result;
import com.example.myblog.pojo.User;
import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {
    //用户相关接口
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/register")//需要填写用户名，密码，邮箱
    public Result register(String userId, String password,String email)
    {
        User u=userService.findUserById(userId);
        if(u==null){
            userService.register(userId,password,email);
            return Result.success();
        }else{
            return Result.error("用户已存在");
        }
    }

    @PostMapping("/api/user/login")//需要填写用户名，密码
    public Result login(String userId, String password)
    {
        User u=userService.findUserById(userId);
        if(u==null){
            return Result.error("用户不存在");
        }else{
            if(u.getPassword().equals(password)){
                return Result.success();
            }else{
                return Result.error("密码错误");
            }
        }
    }



}
