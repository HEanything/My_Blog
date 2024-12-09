package com.example.myblog.service;

import com.example.myblog.pojo2.BlogCollection;

import java.util.List;

public interface CollectionService {

    void createCollection(String collectionName, String collectionDesc, String userId);

    List<BlogCollection> getCollections(String userId);

    void deleteCollection(Long collectionId);

    void updateCollection(Long collectionId, String collectionName, String collectionDesc);

    BlogCollection getCollectionById(Long collectionId);
}
