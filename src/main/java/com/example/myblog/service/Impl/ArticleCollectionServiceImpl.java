package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ArticleCollectionMapper;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogSetArticleCollection;
import com.example.myblog.service.ArticleCollecionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCollectionServiceImpl implements ArticleCollecionService {
    @Autowired
    private ArticleCollectionMapper articleCollectionMapper;

    @Override
    public BlogSetArticleCollection getArticleCollection(Long collectionId, Long articleId) {
        return articleCollectionMapper.getArticleCollection(collectionId,articleId);
    }

    @Override
    public void addArticleToCollection(Long collectionId, Long articleId) {
        articleCollectionMapper.addArticleToCollection(collectionId,articleId);
    }

    @Override
    public void deleteArticleFromCollection(Long collectionId, Long articleId) {
        articleCollectionMapper.deleteArticleFromCollection(collectionId,articleId);
    }

    @Override
    public List<BlogArticle> getArticleByCollectionId(Long collectionId) {
        return articleCollectionMapper.getArticleByCollectionId(collectionId);
    }
}
