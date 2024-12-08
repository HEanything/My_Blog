package com.example.myblog.service;

import com.example.myblog.pojo2.BlogSetArticleLabel;

public interface ArticleLabelService {
    void setLabels(int articleId, String labelId);

    void deleteLabels(int articleId);

    BlogSetArticleLabel getLabelByArticleId(int articleId);

    void updateLabels(int articleId, String labelId);
}
