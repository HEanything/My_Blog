package com.example.myblog.pojo2;

public class BlogCollection {

    private Long collectionId; // 收藏夹ID
    private String userId; // 所属用户ID
    private String collectionName; // 收藏夹名称
    private String collectionDescription; // 收藏夹描述

    // Getters and Setters
    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionDescription() {
        return collectionDescription;
    }

    public void setCollectionDescription(String collectionDescription) {
        this.collectionDescription = collectionDescription;
    }
}

