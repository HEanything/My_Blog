package com.example.myblog.service.Impl;

import com.example.myblog.mapper.UserSubscribeMapper;
import com.example.myblog.pojo2.BlogUserSubscribe;
import com.example.myblog.service.UserSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSubscribeServiceImpl implements UserSubscribeService {

    @Autowired
    private UserSubscribeMapper userSubscribeMapper;

    @Override
    public BlogUserSubscribe findSubscribe(String myId, String userId) {
        return userSubscribeMapper.findSubscribe(myId,userId);
    }

    @Override
    public void unsubscribe(String myId, String userId) {
        userSubscribeMapper.unsubscribe(myId,userId);
    }

    @Override
    public void subscribe(String myId, String userId) {
        userSubscribeMapper.subscribe(myId,userId);
    }

    // 获取我关注的人
    @Override
    public List<BlogUserSubscribe> getMySubscribes(String myId) {
        return userSubscribeMapper.getMySubscribes(myId);
    }

    @Override
    public List<BlogUserSubscribe> getMyFans(String myId) {
        return userSubscribeMapper.getMyFans(myId);
    }
}
