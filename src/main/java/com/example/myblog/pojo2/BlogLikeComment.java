package com.example.myblog.pojo2;

public class BlogLikeComment {

    private Long likeId; // 点赞关系编号
    private String userId; // 点赞用户ID
    private Long commentId; // 评论ID
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Boolean getLikeType() {
        return likeType;
    }

    public void setLikeType(Boolean likeType) {
        this.likeType = likeType;
    }
}
