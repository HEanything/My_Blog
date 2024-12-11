package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogCollection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectionMapper {
    //默认创建一个收藏夹
    @Insert("insert into blog_collection(collection_name,collection_description,user_id) values('我的收藏夹','这是我的收藏夹',#{userId})")
    void createDefaultCollection(String userId);
    //获取用户默认收藏夹
    @Select("select * from blog_collection where user_id = #{userId} and collection_name = '我的收藏夹'")
    BlogCollection getDefaultCollection(String userId);


    //删除默认收藏夹
    @Delete("delete from blog_collection where user_id = #{userId} and collection_name = '我的收藏夹'")
    void deleteDefaultCollection(String userId);

    ////////////////////////以下是用户可以有多个收藏夹///////////////////////////
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
