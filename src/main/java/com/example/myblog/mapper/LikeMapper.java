package com.example.myblog.mapper;

import com.example.myblog.pojo2.BlogLikeArticle;
import com.example.myblog.pojo2.BlogLikeComment;
import com.example.myblog.pojo2.BlogLikeMessage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {
    //////////////////////////////留言//////////////////////////////

    //找到留言点赞记录
    @Select("select * from blog_like_message where user_id = #{userId} and message_id = #{messageId}")
    BlogLikeMessage findLikeMessage(String userId, int messageId);
    //增加点赞记录
    @Insert("insert into  blog_like_message (user_id,message_id,like_type) values(#{userId},#{messageId},1)")
    void addMessageLike(String userId, int messageId);
    //增加踩记录
    @Insert("insert into  blog_like_message (user_id,message_id,like_type) values(#{userId},#{messageId},0)")
    void addMessageDislike(String userId, int messageId);
    //删除点赞记录
    @Delete("delete from blog_like_message where like_id = #{likeId}")
    void deleteLikeMessage(Long likeId);
    //删除踩记录
    @Delete("delete from blog_like_message where like_id =#{likeId}")
    void deleteDisLikeMessage(Long likeId);
    //修改为点赞
    @Update("update blog_like_message set like_type = 1 where like_id = #{likeId}")
    void ChangeToLikeMessage(Long likeId);
    //修改为踩
    @Update("update blog_like_message set like_type = 0 where like_id = #{likeId}")
    void ChangeToDislikeMessage(Long likeId);
    //增加对应的点赞数
    @Update("update blog_messages set message_like_count = message_like_count + 1 where message_id = #{messageId}")
    void AddMessageLikeCount(int messageId);
    //减少对应的点赞数
    @Update("update blog_messages set message_like_count = message_like_count - 1 where message_id = #{messageId}")
    void SubMessageLikeCount(int messageId);

    //增加对应两个的点赞数
    @Update("update blog_messages set message_like_count = message_like_count + 2 where message_id = #{messageId}")
    void AddTwoMessageLikeCount(int messageId);
    //减少对应两个的点赞数
    @Update("update blog_messages set message_like_count = message_like_count - 2 where message_id = #{messageId}")
    void SubTwoMessageLikeCount(int messageId);

    //根据留言id删除所有的点赞记录
    @Delete("delete from blog_like_message where message_id = #{messageId}")
    void deleteAllMessageLike(int messageId);

    /////////////////////////////评论//////////////////////////////
    //找到评论点赞记录
    @Select("select * from blog_like_comment where user_id = #{userId} and comment_id = #{commentId}")
    BlogLikeComment findLikeComment(String userId, int commentId);
    //增加点赞记录
    @Insert("insert into  blog_like_comment (user_id,comment_id,like_type) values(#{userId},#{commentId},1)")
    void addCommentLike(String userId, int commentId);
    //增加踩记录
    @Insert("insert into  blog_like_comment (user_id,comment_id,like_type) values(#{userId},#{commentId},0)")
    void addCommentDislike(String userId, int commentId);
    //删除点赞记录
    @Delete("delete from blog_like_comment where like_id = #{likeId}")
    void deleteLikeComment(Long likeId);
    //删除踩记录
    @Delete("delete from blog_like_comment where like_id =#{likeId}")
    void deleteDisLikeComment(Long likeId);
    //修改为点赞
    @Update("update blog_like_comment set like_type = 1 where like_id = #{likeId}")
    void ChangeToLikeComment(Long likeId);
    //修改为踩
    @Update("update blog_like_comment set like_type = 0 where like_id = #{likeId}")
    void ChangeToDislikeComment(Long likeId);
    //增加对应的点赞数
    @Update("update blog_comments set comment_like_count = comment_like_count + 1 where comment_id = #{commentId}")
    void AddCommentLikeCount(int commentId);
    //减少对应的点赞数
    @Update("update blog_comments set comment_like_count = comment_like_count - 1 where comment_id = #{commentId}")
    void SubCommentLikeCount(int commentId);
    //增加对应两个的点赞
    @Update("update blog_comments set comment_like_count = comment_like_count + 2 where comment_id = #{commentId}")
    void AddTwoCommentLikeCount(int commentId);
    //减少对应两个的点赞
    @Update("update blog_comments set comment_like_count = comment_like_count - 2 where comment_id = #{commentId}")
    void SubTwoCommentLikeCount(int commentId);
    //根据评论id删除所有的点赞记录
    @Delete("delete from blog_like_comment where comment_id = #{commentId}")
    void deleteAllCommentLike(int commentId);





    ///////////////////////////////文章//////////////////////////////
    //找到文章点赞记录
    @Select("select * from blog_like_article where user_id = #{userId} and article_id = #{articleId}")
    BlogLikeArticle findLikeArticle(String userId, int articleId);
    //增加点赞记录
    @Insert("insert into  blog_like_article (user_id,article_id,like_type) values(#{userId},#{articleId},1)")
    void addArticleLike(String userId, int articleId);
    //增加踩记录
    @Insert("insert into  blog_like_article (user_id,article_id,like_type) values(#{userId},#{articleId},0)")
    void addArticleDislike(String userId, int articleId);
    //删除点赞记录
    @Delete("delete from blog_like_article where like_id = #{likeId}")
    void deleteLikeArticle(Long likeId);
    //删除踩记录
    @Delete("delete from blog_like_article where like_id =#{likeId}")
    void deleteDisLikeArticle(Long likeId);
    //修改为点赞
    @Update("update blog_like_article set like_type = 1 where like_id = #{likeId}")
    void ChangeToLikeArticle(Long likeId);
    //修改为踩
    @Update("update blog_like_article set like_type = 0 where like_id = #{likeId}")
    void ChangeToDislikeArticle(Long likeId);
    //增加对应的点赞数
    @Update("update blog_articles set article_like_count = article_like_count + 1 where article_id = #{articleId}")
    void AddArticleLikeCount(int articleId);
    //减少对应的点赞数
    @Update("update blog_articles set article_like_count = article_like_count - 1 where article_id = #{articleId}")
    void SubArticleLikeCount(int articleId);
    //增加对应两个的点赞数
    @Update("update blog_articles set article_like_count = article_like_count + 2 where article_id = #{articleId}")
    void AddTwoArticleLikeCount(int articleId);
    //减少对应两个的点赞数
    @Update("update blog_articles set article_like_count = article_like_count - 2 where article_id = #{articleId}")
    void SubTwoArticleLikeCount(int articleId);
    //根据文章id删除所有的点赞记录
    @Delete("delete from blog_like_article where article_id = #{articleId}")
    void deleteAllArticleLike(int articleId);


    ////////////////////////////////其他//////////////////////////////
    //清空用户留言所有点赞记录
    @Delete("delete from blog_like_message where user_id = #{userId}")
    void deleteAllMessageLikeByUserId(String userId);
    //清空用户评论所有点赞记录
    @Delete("delete from blog_like_comment where user_id = #{userId}")
    void deleteAllCommentLikeByUserId(String userId);
    //清空用户文章所有点赞记录
    @Delete("delete from blog_like_article where user_id = #{userId}")
    void deleteAllArticleLikeByUserId(String userId);
}
