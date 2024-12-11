package com.example.myblog.controller;


import com.example.myblog.mapper.CollectionMapper;
import com.example.myblog.pojo.Result;
import com.example.myblog.pojo.User;
import com.example.myblog.pojo2.BlogAdmin;
import com.example.myblog.pojo2.BlogUser;
import com.example.myblog.service.UserService;
import com.example.myblog.utils.JwtUtil;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {
    //用户相关接口
    @Autowired
    private UserService userService;

    @Autowired
    private CollectionMapper collectionMapper;

    //注册用户
    @PostMapping("/api/user/register")//填写用户名，密码，邮箱
    public Result register(String userId, String password,String email)
    {
        try {
            BlogUser blogUser=userService.findUserById(userId);
            if (blogUser==null){
                userService.register(userId,password,email);
                //默认创建一个收藏夹
                collectionMapper.createDefaultCollection(userId);
                return Result.success();
            }else{
                return Result.error("用户已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("注册失败");
        }
    }

    //登录
    @PostMapping("/api/user/login")
    public Result login(String userId, String password)
    {
        try {
            BlogUser blogUser=userService.findUserById(userId);
            if (blogUser==null){
                return Result.error("用户不存在");
            }else if(blogUser.getUserIsBanned())
            {
                return Result.error("用户已被封禁");
            } else{
                if(blogUser.getUserPassword().equals(password)){
                    Map<String, Object>claims=new HashMap<>();
                    claims.put("userId",userId);
                    String token= JwtUtil.genToken(claims);
                    return Result.success(token);
                }else{
                    return Result.error("密码错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("登录失败");
        }
    }

    //管理员登录
    @PostMapping("/api/user/adminlogin")
    public Result adminLogin(String userId, String password)
    {
        try {
            BlogUser blogUser=userService.findUserById(userId);
            BlogAdmin blogAdmin=userService.findAdminById(userId);
            if (blogUser==null||blogAdmin==null){
                return Result.error("用户不存在");
            }else{
                if(blogUser.getUserPassword().equals(password)){
                    Map<String, Object>claims=new HashMap<>();
                    claims.put("userId",userId);
                    claims.put("isAdmin",true);
                    String token= JwtUtil.genToken(claims);
                    return Result.success(token);
                }else{
                    return Result.error("密码错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("登录失败");
        }
    }

    //修改密码
    @PatchMapping("/api/user/updatepassword")
    public Result updatePassword(@RequestBody Map<String,String> params)
    {
        String oldPWD=params.get("oldPWD");
        String newPWD=params.get("newPWD");
        String rePWD=params.get("rePWD");
        if (!StringUtils.hasLength(oldPWD)||!StringUtils.hasLength(newPWD)||!StringUtils.hasLength(rePWD)){
            return Result.error("请输入完整的数据");
        }
        Map<String, Object> claims= ThreadLocalUtil.get();
        String userId=(String) claims.get("userId");
        BlogUser user=userService.findUserById(userId);
        if(!user.getUserPassword().equals(oldPWD)){
            return Result.error("密码错误");
        }
        if(!newPWD.equals(rePWD)){
            return Result.error("两次密码不一致");
        }
        try {
            userService.updatePWD(newPWD,userId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    //用户更新个人信息(目前修改性别，邮箱，电话号)
    @PatchMapping("/api/user/updateMyselfInfo")
    public Result updateMyselfInfo(@RequestBody Map<String,String> params)
    {
        String gender=params.get("gender");
        String email=params.get("email");
        String phoneNumber=params.get("phoneNumber");
        Map<String, Object> claims= ThreadLocalUtil.get();
        String userId=(String) claims.get("userId");
        try {
            userService.updateMyselfInfo(gender,email,phoneNumber,userId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新失败");
        }
    }

    //管理员更新用户信息(根据id)密码，性别，邮箱，电话号码
    @PatchMapping("/api/user/updateuserinfo/{userId}")
    public Result updateUserInfo(@RequestBody Map<String,String> params,@PathVariable String userId)
    {
        String password=params.get("password");
        String gender=params.get("gender");
        String email=params.get("email");
        String phoneNumber=params.get("phoneNumber");
        try {
            userService.updateUserInfo(password,gender,email,phoneNumber,userId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新失败");
        }
    }

    //管理员获得所有用户信息
    @GetMapping("/api/user/getusersinfo")
    public Result getUsersInfo()
    {
        try {
            List<BlogUser> users=userService.getUsersInfo();
            if (users==null){
                return Result.error("不存在用户或查询出错");
            }
            return Result.success(users);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询出错");
        }
    }
    //管理员删除用户
    @DeleteMapping("/api/user/deleteuser/{userId}")
    public Result deleteUser(@PathVariable String userId)
    {
        try {
            userService.deleteUser(userId);
            return Result.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
    //管理员封禁用户
    @PatchMapping("/api/user/banuser/{userId}")
    public Result banUser(@PathVariable String userId)
    {

        try {
            userService.banUser(userId);
            return Result.success("封禁成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("封禁失败");
        }
    }
    //管理员恢复用户
    @PatchMapping("/api/user/recoveruser/{userId}")
    public Result recoverUser(@PathVariable String userId)
    {
        try {
            userService.unbanUser(userId);
            return Result.success("恢复成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("恢复失败");
        }
    }

    //找回密码(目前邮箱相当于密保)想用邮箱发邮件的
    @PostMapping("/api/user/findpassword")
    public Result findPassword(String userId,String email)
    {
        BlogUser blogUser=userService.findUserById(userId);
        if (blogUser==null){
            return Result.error("用户不存在");
        }else{
            if(blogUser.getUserEmail().equals(email)){
                return Result.success(blogUser.getUserPassword());
            }else{
                return Result.error("邮箱错误");
            }
        }
    }

//    @PostMapping("/api/user/register")//需要填写用户名，密码，邮箱
//    public Result register(String userId, String password,String email)
//    {
//        User u=userService.findUserById(userId);
//        if(u==null){
//            userService.register(userId,password,email);
//            return Result.success();
//        }else{
//            return Result.error("用户已存在");
//        }
//    }
//
//    @PostMapping("/api/user/login")//需要填写用户名，密码
//    public Result login(String userId, String password)
//    {
//        User u=userService.findUserById(userId);
//        if(u==null){
//            return Result.error("用户不存在");
//        }else{
//            if(u.getPassword().equals(password)){
//                Map<String, Object>claims=new HashMap<>();
//                claims.put("userId",userId);
//                String token= JwtUtil.genToken(claims);
//                return Result.success(token);
//            }else{
//                return Result.error("密码错误");
//            }
//        }
//    }
//
//    //获取所有用户信息
//    @GetMapping("/api/user/getusersinfo")
//    public Result getUsersInfo()
//    {
//        List<User> users=userService.getUsersInfo();
//        if (users==null){
//            return Result.error("不存在用户或查询出错");
//        }
//        return Result.success(users);
//    }
//
//
//    //获取用户信息user_id
//    @GetMapping("/api/user/getuserinfo/{userId}")
//    public Result getUserInfo(@PathVariable String userId)
//    {
//        User user=userService.findUserById(userId);
//        if (user==null){
//            return Result.error("用户不存在");
//        }
//        return Result.success(user);
//    }
//
//    //管理员更新用户信息
//    //目前要求重新输入密码，性别，email，phone_number
//    @PatchMapping("/api/user/updateuserinfo/{userId}")
//    public Result updateUserInfo(@RequestBody Map<String,String> params,@PathVariable String userId)
//    {
//
//        String password=params.get("password");
//        String gender=params.get("gender");
//        String email=params.get("email");
//        String phoneNumber=params.get("phoneNumber");
//        userService.updateUserInfo(password,gender,email,phoneNumber,userId);
//        return Result.success();
//    }
//
//
//    //修改密码
//    //前台传参旧密码，新密码，确认新密码
//    @PatchMapping("/api/user/updatepassword")
//    public Result updatePassword(@RequestBody Map<String,String> params)
//    {
//        String oldPWD=params.get("oldPWD");
//        String newPWD=params.get("newPWD");
//        String rePWD=params.get("rePWD");
//        if (!StringUtils.hasLength(oldPWD)||!StringUtils.hasLength(newPWD)||!StringUtils.hasLength(rePWD)){
//            return Result.error("请输入完整的数据");
//        }
//
//        Map<String, Object> claims= ThreadLocalUtil.get();
//        String userId=(String) claims.get("userId");
//        User user=userService.findUserById(userId);
//        if(!user.getPassword().equals(oldPWD)){
//            return Result.error("密码错误");
//        }
//        if(!newPWD.equals(rePWD)){
//            return Result.error("两次密码不一致");
//        }
//        userService.updatePWD(newPWD);
//        return Result.success();
//
//    }
//
//



}
