package com.example.myblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.myblog.pojo.Post;
import com.example.myblog.pojo2.BlogArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from blog_articles")
    List<BlogArticle> getArticles();

    @Select("select * from blog_articles where article_id = #{articleId}")
    BlogArticle getArticleById(int articleId);

    @Insert("INSERT INTO blog_articles(article_title, article_content, user_id, " +
            "article_views, article_comment_count, article_like_count, article_date, article_isPinned) " +
            "VALUES(#{title}, #{content}, #{userId}, 0, 0, 0, NOW(), 0)")
    void writeArticle(String title, String content, String userId);

    @Delete("delete from blog_articles where article_id = #{articleId}")
    void deleteArticle(int articleId);

    @Update("update blog_articles set article_title = #{title}, article_content = #{content} where article_id = #{articleId}")
    void updateArticle(int articleId, String title, String content);

    @Select("select * from blog_articles where user_id = #{userId}")
    List<BlogArticle> getArticlesByUserId(String userId);


//    @Select("select * from posts where post_id = #{postId}")
//    Post getPostById(int postId);
//
//    @Insert("insert into posts(title, content, user_id) values(#{title}, #{content}, #{userId})")
//    void writePost(String title, String content, String userId);
//
//    @Delete("delete from posts where post_id = #{postId}")
//    void deletePost(int postId);
//
//    @Update("update posts set title = #{title}, content = #{content} where post_id = #{postId}")
//    void updatePost(Post post);
//
//    @Select("select * from posts where user_id = #{userId}")
//    List<Post> getPostByAuthor(String userId);
}
