package com.example.myblog.pojo;

public class UserAttribute {
    private String userId;
    private boolean isAdmin;
    private boolean isBanned;
    private boolean canPublishPosts;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public boolean canPublishPosts() {
        return canPublishPosts;
    }

    public void setCanPublishPosts(boolean canPublishPosts) {
        this.canPublishPosts = canPublishPosts;
    }
}
