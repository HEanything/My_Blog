package com.example.myblog.pojo2;


public class BlogLikeMessage {

    private Long likeId; // 点赞关系编号
    private String userId; // 点赞用户ID
    private Long messageId; // 留言ID
    private Boolean likeType; // true为赞，false为踩

    // Getters and Setters
    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Boolean getLikeType() {
        return likeType;
    }

    public void setLikeType(Boolean likeType) {
        this.likeType = likeType;
    }
}

