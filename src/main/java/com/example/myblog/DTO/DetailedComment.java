package com.example.myblog.DTO;

//除了评论的数据库储存还包括了以bool类型的是否点赞
public class DetailedComment {
    private int commentId; // 评论ID
    private String userId; // 发表用户ID
    private Long articleId; // 评论博文ID
    private Long commentLikeCount; // 点赞数
    private String commentDate; // 评论日期
    private String commentContent; // 评论内容
    private Long parentCommentId; // 父评论ID
    private Boolean commentIsPinned; // 评论是否置顶

    private Boolean liked;
    private Boolean disliked;

    // Getters and Setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
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
    public Boolean getLiked() {
        return liked;
    }
    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
    public Boolean getDisliked() {
        return disliked;
    }
    public void setDisliked(Boolean disliked) {
        this.disliked = disliked;
    }
}
