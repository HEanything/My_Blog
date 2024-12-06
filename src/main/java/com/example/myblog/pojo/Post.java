package com.example.myblog.pojo;


public class Post {
    private int post_id;
    private String title;
    private String content;
    private String user_Id;
    private int views;
    private int comments_count;
    private int likes;
    private String created_at;
    private boolean is_pinned;

    // Getters and Setters
    public int getPostId() {
        return post_id;
    }

    public void setPostId(int postId) {
        this.post_id = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return user_Id;
    }

    public void setUserId(String userId) {
        this.user_Id = userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCommentsCount() {
        return comments_count;
    }

    public void setCommentsCount(int commentsCount) {
        this.comments_count = commentsCount;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    public boolean isPinned() {
        return is_pinned;
    }

    public void setPinned(boolean isPinned) {
        this.is_pinned = isPinned;
    }
}

