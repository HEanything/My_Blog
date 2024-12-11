package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.mapper.CommentMapper;
import com.example.myblog.mapper.LikeMapper;
import com.example.myblog.mapper.ReportMapper;
import com.example.myblog.pojo.Comment;
import com.example.myblog.pojo2.BlogComment;
import com.example.myblog.service.CommentService;
import com.example.myblog.service.ReportService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private LikeMapper likeMapper;

    @Override
    public List<BlogComment> getCommentsByArticleId(int articleId) {
        return commentMapper.getCommentsByArticleId(articleId);
    }

    // 添加评论,再添加的同时向数据库对应的文章中评论数加1
    @Override
    public void addComment(String commentcontent, int articleId, String userId) {
        commentMapper.addComment(commentcontent, articleId, userId);
        articleMapper.addCommentCount(articleId);

    }

    // 根据评论id获取评论
    @Override
    public BlogComment getCommentById(int commentId) {
        return commentMapper.getCommentById(commentId);
    }

    // 删除评论
    //要嵌套循环删除所有子评论
    // 删除评论及其所有子评论
    //之后实现删除所有点赞关系
    @Override
    @Transactional
    public void deleteComment(int commentId) {
        // 递归删除所有子评论
        deleteAllReplies(commentId);

        //先删举报信息
        reportMapper.deleteCommentReportByCommentId(commentId);
        //删除点赞信息
        likeMapper.deleteAllCommentLike(commentId);

        BlogComment comment = commentMapper.getCommentById(commentId);
        //文章评论数减一
        articleMapper.subCommentCount(comment.getArticleId());
        // 删除目标评论
        commentMapper.deleteCommentById(commentId);

    }

    // 递归删除所有子评论
    //之后实现删除所有点赞关系
    private void deleteAllReplies(int commentId) {
        // 获取所有子评论
        List<BlogComment> replies = commentMapper.getRepliesByCommentId(commentId);

        // 对每个子评论进行递归删除
        for (BlogComment reply : replies) {
            // 递归删除当前子评论的所有子评论
            deleteAllReplies(reply.getCommentId());  // 递归删除
            //先删举报信息
            reportMapper.deleteCommentReportByCommentId(reply.getCommentId());
            //删除点赞信息
            likeMapper.deleteAllCommentLike(reply.getCommentId());
            //文章评论数减一
            articleMapper.subCommentCount(reply.getArticleId());
            // 删除当前子评论
            commentMapper.deleteCommentById(reply.getCommentId());

        }
    }

    // 回复评论
    @Override
    public void replyComment(int parentCommentId, String content, int articleId, String userId) {
        commentMapper.replyComment(parentCommentId, content, articleId, userId);
        articleMapper.addCommentCount(articleId);
    }

    // 修改评论
    @Override
    public void updateComment(int commentId, String content) {
        commentMapper.updateComment(commentId, content);
    }

    // 删除文章下的所有评论
    @Override
    @Transactional
    public void deleteCommentsByArticleId(int articleId) {
        // 获取文章下所有评论
        List<BlogComment> comments = commentMapper.getCommentsByArticleId(articleId);

        // 递归删除所有子评论
        for (BlogComment comment : comments) {
            deleteAllReplies(comment.getCommentId());
        }

        // 删除根评论
        for (BlogComment comment : comments) {
            //先删举报信息
            reportMapper.deleteCommentReportByCommentId(comment.getCommentId());
            //删除点赞信息
            likeMapper.deleteAllCommentLike(comment.getCommentId());
            //文章评论数减一
            articleMapper.subCommentCount(comment.getArticleId());
            commentMapper.deleteCommentById(comment.getCommentId());

        }
    }

    // 置顶评论
    @Override
    public void pinComment(int commentId) {
        commentMapper.pinComment(commentId);
    }

    // 取消置顶评论
    @Override
    public void unpinComment(int commentId) {
        commentMapper.unpinComment(commentId);
    }

    // 删除用户所有评论
    @Override
    public void clearUserComment(String userId) {
        //获取用户的所有评论
        List<BlogComment> comments = commentMapper.getCommentsByUserId(userId);

        // 递归删除所有子评论
        for (BlogComment comment : comments) {
            deleteAllReplies(comment.getCommentId());
        }
        // 删除根评论
        for (BlogComment comment : comments) {
            //先删举报信息
            reportMapper.deleteCommentReportByCommentId(comment.getCommentId());
            //删除点赞信息
            likeMapper.deleteAllCommentLike(comment.getCommentId());
            //文章评论数减一
            articleMapper.subCommentCount(comment.getArticleId());
            commentMapper.deleteCommentById(comment.getCommentId());

        }

    }


//    @Override
//    public List<Comment> getCommentsByPostId(int postId) {
//        return commentMapper.getCommentsByPostId(postId);
//    }
}
