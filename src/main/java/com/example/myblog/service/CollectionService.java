package com.example.myblog.service;

import com.example.myblog.pojo2.BlogCollection;

import java.util.List;

public interface CollectionService {

    void createCollection(String collectionName, String collectionDesc, String userId);

    List<BlogCollection> getCollections(String userId);

    void deleteCollection(Long collectionId);

    void updateCollection(Long collectionId, String collectionName, String collectionDesc);

    BlogCollection getCollectionById(Long collectionId);

    ///////////////////////////以下用户只能有单个的收藏夹////////////////////////////////
    BlogCollection getDefaultCollection(String userId);

    //删除用户的收藏夹
    void deleteDefaultCollection(String userId);
}
