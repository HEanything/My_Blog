package com.example.myblog.service;

import com.example.myblog.pojo2.BlogUserSubscribe;

import java.util.List;

public interface UserSubscribeService {

    BlogUserSubscribe findSubscribe(String myId, String userId);

    void unsubscribe(String myId, String userId);

    void subscribe(String myId, String userId);

    List<BlogUserSubscribe> getMySubscribes(String myId);

    List<BlogUserSubscribe> getMyFans(String myId);
}
