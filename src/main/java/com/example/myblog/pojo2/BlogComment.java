package com.example.myblog.pojo2;

public class BlogComment {

    private Long commentId; // 评论ID
    private String userId; // 发表用户ID
    private Long articleId; // 评论博文ID
    private Long commentLikeCount; // 点赞数
    private String commentDate; // 评论日期
    private String commentContent; // 评论内容
    private Long parentCommentId; // 父评论ID
    private Boolean commentIsPinned; // 评论是否置顶

    // Getters and Setters
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Long commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Boolean getCommentIsPinned() {
        return commentIsPinned;
    }

    public void setCommentIsPinned(Boolean commentIsPinned) {
        this.commentIsPinned = commentIsPinned;
    }
}
