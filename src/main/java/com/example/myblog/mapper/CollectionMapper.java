package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogCollection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    // 创建收藏夹
    @Insert("insert into blog_collection(collection_name,collection_description,user_id) values(#{collectionName},#{collectionDesc},#{userId})")
    void createCollection(String collectionName, String collectionDesc, String userId);

    // 获取用户所有收藏夹
    @Select("select * from blog_collection where user_id = #{userId}")
    List<BlogCollection> getCollections(String userId);

    // 删除收藏夹
    @Delete("delete from blog_collection where collection_id = #{collectionId}")
    void deleteCollection(Long collectionId);

    // 更新收藏夹
    @Update("update blog_collection set collection_name = #{collectionName},collection_description = #{collectionDesc} where collection_id = #{collectionId}")
    void updateCollection(Long collectionId, String collectionName, String collectionDesc);

    // 根据id获取收藏夹
    @Select("select * from blog_collection where collection_id = #{collectionId}")
    BlogCollection getCollectionById(Long collectionId);
}
