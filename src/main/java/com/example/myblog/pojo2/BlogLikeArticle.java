package com.example.myblog.pojo2;


public class BlogLikeArticle {

    private Long likeId; // 点赞关系编号
    private String userId; // 点赞用户ID
    private Long articleId; // 点赞文章ID
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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Boolean getLikeType() {
        return likeType;
    }

    public void setLikeType(Boolean likeType) {
        this.likeType = likeType;
    }
}
