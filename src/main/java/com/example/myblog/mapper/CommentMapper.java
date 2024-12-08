package com.example.myblog.mapper;

import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from blog_comments where comment_id = #{commentId}")
    List<BlogComment> getCommentsByArticleId(int articleId);

//    @Select("select * from comments where post_id = #{postId}")
//    List<Comment> getCommentsByPostId(int postId);
}
