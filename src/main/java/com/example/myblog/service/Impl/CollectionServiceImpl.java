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

    ////////////////////////以下是用户只能有默认收藏夹的操作/////////////////////////////
    //获得用户的收藏夹
    @Override
    public BlogCollection getDefaultCollection(String userId) {
        return collectionMapper.getDefaultCollection(userId);
    }

    //删除用户的收藏夹
    @Override
    public void deleteDefaultCollection(String userId) {
        //先获得收藏夹的id
        Long collectionId = collectionMapper.getDefaultCollection(userId).getCollectionId();
        //先删对应收藏夹博文关系
        articleCollectionMapper.deleteAllArticleFromCollection(collectionId);
        //再删收藏夹
        collectionMapper.deleteDefaultCollection(userId);

    }
}
