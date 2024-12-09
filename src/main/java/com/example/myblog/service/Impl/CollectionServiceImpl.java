package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ArticleCollectionMapper;
import com.example.myblog.mapper.CollectionMapper;
import com.example.myblog.pojo2.BlogCollection;
import com.example.myblog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private ArticleCollectionMapper articleCollectionMapper;

    @Override
    public void createCollection(String collectionName, String collectionDesc, String userId) {
        collectionMapper.createCollection(collectionName,collectionDesc,userId);
    }

    @Override
    public List<BlogCollection> getCollections(String userId) {
        return collectionMapper.getCollections(userId);
    }

    @Override
    public void deleteCollection(Long collectionId) {
        //先删对应收藏夹博文关系
        articleCollectionMapper.deleteAllArticleFromCollection(collectionId);
        collectionMapper.deleteCollection(collectionId);
    }

    @Override
    public void updateCollection(Long collectionId, String collectionName, String collectionDesc) {
        collectionMapper.updateCollection(collectionId,collectionName,collectionDesc);
    }

    @Override
    public BlogCollection getCollectionById(Long collectionId) {
        return collectionMapper.getCollectionById(collectionId);
    }
}
