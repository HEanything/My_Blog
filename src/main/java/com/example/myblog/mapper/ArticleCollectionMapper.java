package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogSetArticleCollection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleCollectionMapper {
    @Select("select * from blog_set_article_collection where collection_id = #{collectionId} and article_id = #{articleId}")
    BlogSetArticleCollection getArticleCollection(Long collectionId, Long articleId);

    @Insert("insert into blog_set_article_collection(collection_id,article_id) values(#{collectionId},#{articleId})")
    void addArticleToCollection(Long collectionId, Long articleId);

    @Delete("delete from blog_set_article_collection where collection_id = #{collectionId} and article_id = #{articleId}")
    void deleteArticleFromCollection(Long collectionId, Long articleId);

    @Select("select blog_articles.* from blog_set_article_collection " +
            "left join blog_articles on blog_set_article_collection.article_id = blog_articles.article_id " +
            "where blog_set_article_collection.collection_id = #{collectionId}")
    List<BlogArticle> getArticleByCollectionId(Long collectionId);

    //清空收藏夹文章
    @Delete("delete from blog_set_article_collection where collection_id = #{collectionId}")
    void deleteAllArticleFromCollection(Long collectionId);

    //清空含有某篇文章的收藏夹
    @Delete("delete from blog_set_article_collection where article_id = #{articleId}")
    void deleteArticleFromAllCollection(long articleId);
}
