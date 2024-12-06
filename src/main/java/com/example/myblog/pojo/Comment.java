package com.example.myblog.pojo;

public class Comment {
    private int comment_id;
    private int post_id;
    private String user_id;
    private Integer reply_to;
    private String content;
    private int likes;
    private String created_at;
    private boolean is_pinned;

    // Getters and Setters
    public int getCommentId() {
        return comment_id;
    }

    public void setCommentId(int commentId) {
        this.comment_id = commentId;
    }

    public int getPostId() {
        return post_id;
    }

    public void setPostId(int postId) {
        this.post_id = postId;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public Integer getReplyTo() {
        return reply_to;
    }

    public void setReplyTo(Integer replyTo) {
        this.reply_to = replyTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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


