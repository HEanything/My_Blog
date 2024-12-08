package com.example.myblog.pojo2;

public class BlogUserSubscribe {

    private Long subscribeId; // 标识ID
    private String userId; // 用户ID
    private String userSubscribeId; // 被关注者ID

    // Getters and Setters
    public Long getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Long subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSubscribeId() {
        return userSubscribeId;
    }

    public void setUserSubscribeId(String userSubscribeId) {
        this.userSubscribeId = userSubscribeId;
    }
}
