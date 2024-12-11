package com.example.myblog.mapper;

import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from blog_comments where comment_id = #{commentId}")
    List<BlogComment> getCommentsByArticleId(int articleId);

    // 添加评论
    @Insert("INSERT INTO blog_comments (user_id, article_id, comment_like_count, comment_date, comment_content, parent_comment_id, comment_isPinned) " +
            " VALUES (#{userId}, #{articleId}, 0, NOW(), #{commentcontent}, NULL, 0)")
    void addComment(String commentcontent, int articleId, String userId);

    //根据评论Id获取评论
    @Select("select * from blog_comments where comment_id = #{commentId}")
    BlogComment getCommentById(int commentId);

    //回复评论
    @Insert("INSERT INTO blog_comments (user_id, article_id, comment_like_count, comment_date, comment_content, parent_comment_id, comment_isPinned) " +
            " VALUES (#{userId}, #{articleId}, 0, NOW(), #{content}, #{parentCommentId}, 0)")
    void replyComment(int parentCommentId, String content, int articleId, String userId);

    // 更新评论
    @Update("update blog_comments set comment_content = #{content} where comment_id = #{commentId}")
    void updateComment(int commentId, String content);

    // 查询指定评论的所有子评论
    @Select("SELECT * FROM blog_comments WHERE parent_comment_id = #{commentId}")
    List<BlogComment> getRepliesByCommentId(int commentId);

    // 删除评论
    @Delete("DELETE FROM blog_comments WHERE comment_id = #{commentId}")
    void deleteCommentById(int commentId);

    // 置顶评论
    @Update("UPDATE blog_comments SET comment_isPinned = 1 WHERE comment_id = #{commentId}")
    void pinComment(int commentId);

    // 取消置顶评论
    @Update("UPDATE blog_comments SET comment_isPinned = 0 WHERE comment_id = #{commentId}")
    void unpinComment(int commentId);

    // 根据用户Id获取评论
    @Select("select * from blog_comments where user_id = #{userId}")
    List<BlogComment> getCommentsByUserId(String userId);

//    @Select("select * from comments where post_id = #{postId}")
//    List<Comment> getCommentsByPostId(int postId);
}
