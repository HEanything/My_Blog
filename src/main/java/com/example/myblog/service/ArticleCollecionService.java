package com.example.myblog.service;

import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogSetArticleCollection;

import java.util.List;

public interface ArticleCollecionService {
    BlogSetArticleCollection getArticleCollection(Long collectionId, Long articleId);

    void addArticleToCollection(Long collectionId, Long articleId);

    void deleteArticleFromCollection(Long collectionId, Long articleId);

    List<BlogArticle> getArticleByCollectionId(Long collectionId);
}
