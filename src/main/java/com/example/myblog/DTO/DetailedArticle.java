package com.example.myblog.DTO;


///文章详情页，包含文章的所有信息，并加上以boolean类型返回是否点赞、点踩、是否收藏、是否关注作者
public class DetailedArticle {
    private Long articleId; // 博文ID
    private String userId; // 发表用户ID
    private String articleTitle; // 博文标题
    private String articleContent; // 博文内容
    private Long articleViews; // 浏览量
    private Long articleCommentCount; // 评论总数
    private Long articleLikeCount; // 点赞/踩数量
    private String articleDate; // 发表时间
    private Boolean articleIsPinned; // 是否置顶
    private String labelName; // 标签名称


    private Boolean isLiked;
    private Boolean isDisliked;
    private Boolean isCollected;
    private Boolean isSubscribed;


    // Getter and Setter for articleId
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for articleTitle
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    // Getter and Setter for articleContent
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    // Getter and Setter for articleViews
    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    // Getter and Setter for articleCommentCount
    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    // Getter and Setter for articleLikeCount
    public Long getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Long articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    // Getter and Setter for articleDate
    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    // Getter and Setter for articleIsPinned
    public Boolean getArticleIsPinned() {
        return articleIsPinned;
    }

    public void setArticleIsPinned(Boolean articleIsPinned) {
        this.articleIsPinned = articleIsPinned;
    }

    // Getter and Setter for labelName
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public Boolean getLiked() {
        return isLiked;
    }
    public void setLiked(Boolean liked) {
        isLiked = liked;
    }
    public Boolean getDisliked() {
        return isDisliked;
    }
    public void setDisliked(Boolean disliked) {
        isDisliked = disliked;
    }
    public Boolean getCollected() {
        return isCollected;
    }
    public void setCollected(Boolean collected) {
        isCollected = collected;
    }
    public Boolean getSubscribed() {
        return isSubscribed;
    }
    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }
}
