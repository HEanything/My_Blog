package com.example.myblog.service.Impl;


import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.mapper.UserMapper;

import com.example.myblog.mapper.UserSubscribeMapper;
import com.example.myblog.pojo2.BlogAdmin;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogUser;
import com.example.myblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSubscribeMapper userSubscribeMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MessageService messageService;


    @Override
    public BlogUser findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public void register(String userId, String password, String email) {
        userMapper.register(userId, password, email);
    }

    @Override
    public void updatePWD(String newPWD, String userId) {
        userMapper.updatePWD(newPWD, userId);
    }

    @Override
    public void updateMyselfInfo(String gender, String email, String phoneNumber, String userId) {
        userMapper.updateMyselfInfo(gender, email, phoneNumber, userId);
    }

    @Override
    public void updateUserInfo(String password, String gender, String email, String phoneNumber, String userId) {
        userMapper.updateUserInfo(password, gender, email, phoneNumber, userId);
    }

    @Override
    public List<BlogUser> getUsersInfo() {
        return userMapper.getUsersInfo();
    }

    // 删除用户(还要删除其他相关联的表)
    // 先删除关注关系表
    // 删除含有相关文章的关系（调用articleService层中的删除文章的功能）
    @Override
    public void deleteUser(String userId) {
        userSubscribeMapper.clearSubscribes(userId);//删除关注关系表
        userSubscribeMapper.clearFans(userId);
        //清空我的点赞
        likeService.clearUserLike(userId);
        //清空我的收藏
        //清空我的留言关系
        messageService.deleteUserMessages(userId);
        //清空我的评论关系
        commentService.clearUserComment(userId);
        //清空我的文章
        List<Integer> articleIds = articleMapper.getArticleIdByUserId(userId);
        for (Integer articleId : articleIds) {
            articleService.deleteArticle(articleId);
        }

        userMapper.deleteUser(userId);
    }

    @Override
    public void banUser(String userId) {
        userMapper.banUser(userId);
    }

    @Override
    public void unbanUser(String userId) {
        userMapper.unbanUser(userId);
    }

    //查找管理员
    @Override
    public BlogAdmin findAdminById(String userId) {
        return userMapper.findAdminById(userId);
    }
}
