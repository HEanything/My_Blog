package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogUserSubscribe;
import com.example.myblog.service.UserSubscribeService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserSubscribeController {
    @Autowired
    private UserSubscribeService userSubscribeService;


    //////////关注按钮/////////////
    @PostMapping("/api/user/UserSubscribe")
    public Result UserSubscribe(String userId) {
        Map<String, Object> claims= ThreadLocalUtil.get();
        String myId=(String) claims.get("userId");
        if (myId.equals(userId))
        {
            return Result.error("不能关注自己");
        }
        try{
            BlogUserSubscribe userSubscribe=userSubscribeService.findSubscribe(myId,userId);
            if(userSubscribe!=null){//已经关注则取消关注
                userSubscribeService.unsubscribe(myId,userId);
                return Result.success("取消关注成功");
            }else{
                userSubscribeService.subscribe(myId,userId);
                return Result.success("关注成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("关注失败");
        }
    }
    // 关注用户
    @PostMapping("/api/user/subscribe/{userId}")
    public Result subscribe(@PathVariable String userId) {
        Map<String, Object> claims= ThreadLocalUtil.get();
        String myId=(String) claims.get("userId");
        if (myId.equals(userId))
        {
            return Result.error("不能关注自己");
        }
        try{
            BlogUserSubscribe userSubscribe=userSubscribeService.findSubscribe(myId,userId);
            if(userSubscribe!=null){
                return Result.error("不能重复关注");
            }
            userSubscribeService.subscribe(myId,userId);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("关注失败");
        }
    }
    // 取消关注
    @PostMapping("/api/user/unsubscribe/{userId}")
    public Result unsubscribe(@PathVariable String userId) {
        Map<String, Object> claims= ThreadLocalUtil.get();
        String myId=(String) claims.get("userId");
        try{
            BlogUserSubscribe userSubscribe=userSubscribeService.findSubscribe(myId,userId);
            if(userSubscribe==null){
                return Result.error("不能取消关注未关注的用户");
            }
            userSubscribeService.unsubscribe(myId,userId);
            return Result.success("取消关注成功");
        }catch (Exception e){
            return Result.error("取消关注失败");
        }
    }
    // 获取关注列表
    //返回关注关系表
    @PostMapping("/api/user/getSubscribes")
    public Result getSubscribes() {
        Map<String, Object> claims= ThreadLocalUtil.get();
        String myId=(String) claims.get("userId");
        try{
            List<BlogUserSubscribe> userSubscribe=userSubscribeService.getMySubscribes(myId);
            return Result.success(userSubscribe);//返回关注关系表若为空应该由前端显示
        }catch (Exception e){
            return Result.error("获取关注列表失败");
        }
    }
    //获取粉丝列表
    @PostMapping("/api/user/getFans")
    public Result getFans() {
        Map<String, Object> claims= ThreadLocalUtil.get();
        String myId=(String) claims.get("userId");
        try{
            List<BlogUserSubscribe> userSubscribe=userSubscribeService.getMyFans(myId);
            return Result.success(userSubscribe);//返回关注关系表若为空应该由前端显示
        }catch (Exception e){
            return Result.error("获取粉丝列表失败");
        }
    }
}
