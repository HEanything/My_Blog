package com.example.myblog.pojo2;
public class BlogSetArticleLabel {

    private Long setLabelId; // 设置分类ID
    private Long labelId; // 分类ID
    private Long articleId; // 文章ID

    // Getters and Setters
    public Long getSetLabelId() {
        return setLabelId;
    }

    public void setSetLabelId(Long setLabelId) {
        this.setLabelId = setLabelId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
