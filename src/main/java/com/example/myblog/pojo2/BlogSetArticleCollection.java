package com.example.myblog.pojo2;

public class BlogSetArticleCollection {

    private Long setCollectionId; // 设置收藏夹ID
    private Long collectionId; // 收藏夹ID
    private Long articleId; // 文章ID

    // Getters and Setters
    public Long getSetCollectionId() {
        return setCollectionId;
    }

    public void setSetCollectionId(Long setCollectionId) {
        this.setCollectionId = setCollectionId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}

