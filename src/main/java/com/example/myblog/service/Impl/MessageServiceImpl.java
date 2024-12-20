package com.example.myblog.service.Impl;

import com.example.myblog.DTO.DetailedMessage;
import com.example.myblog.mapper.LikeMapper;
import com.example.myblog.mapper.MessageMapper;
import com.example.myblog.mapper.ReportMapper;
import com.example.myblog.pojo2.BlogMessage;
import com.example.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private LikeMapper likeMapper;

    // 获取留言
    @Override
    public List<BlogMessage> getMessages() {
        return messageMapper.getMessages();
    }

    // 添加留言
    @Override
    public void addMessage(String content,String userId) {
        messageMapper.addMessage(content,userId);
    }

    // 通过id获取留言
    @Override
    public BlogMessage getMessageById(int messageId) {
        return messageMapper.getMessageById(messageId);
    }

    //置顶文章
    @Override
    public void pinMessage(int messageId) {
        messageMapper.pinMessage(messageId);
    }

    @Override
    public void unpinMessage(int messageId) {
        messageMapper.unpinMessage(messageId);
    }

    @Override
    public List<BlogMessage> getMessagesByUserId(String userId) {
        return messageMapper.getMessagesByUserId(userId);
    }

    @Override
    public void replyMessage(int parentMessageId, String content, String userId) {
        messageMapper.replyMessage(parentMessageId,content,userId);
    }

    // 删除留言由于要删除子留言要用嵌套
    // 实现删除留言及其子留言的功能

    @Transactional
    @Override
    public void deleteMessage(int messageId) {
        // 递归删除所有子留言
        deleteAllReplies(messageId);
        // 删除对应的举报信息
        reportMapper.deleteMessageReportByMessageId(messageId);
        //删除对应的点赞信息
        likeMapper.deleteAllMessageLike(messageId);
        // 删除目标留言
        messageMapper.deleteMessageById(messageId);
    }

    // 更新留言
    @Override
    public void updateMessage(int messageId, String content) {
        messageMapper.updateMessage(messageId,content);
    }

    // 删除用户所有留言
    @Override
    public void deleteUserMessages(String userId) {
        //找到用户的所有留言
        List<BlogMessage> messages = messageMapper.getMessagesByUserId(userId);
        for (BlogMessage message : messages) {
            // 递归删除所有子留言
            deleteAllReplies(message.getMessageId());
            // 删除对应的举报信息
            reportMapper.deleteMessageReportByMessageId(message.getMessageId());
            //删除对应的点赞信息
            likeMapper.deleteAllMessageLike(message.getMessageId());
            // 删除目标留言
            messageMapper.deleteMessageById(message.getMessageId());
        }

    }

    /////////////获取详细的留言
    @Override
    public List<DetailedMessage> getDetailedMessages(String userId) {
        return messageMapper.getDetailedMessages(userId);
    }


    // 递归删除所有子留言
    //之后删除所有点赞关系
    private void deleteAllReplies(int messageId) {
        // 获取所有子留言
        List<BlogMessage> replies = messageMapper.getRepliesByMessageId(messageId);

        // 对每一个子留言进行递归删除
        for (BlogMessage reply : replies) {
            // 递归删除当前子留言的所有子留言
            deleteAllReplies(reply.getMessageId());
            //删除对应的举报信息
            reportMapper.deleteMessageReportByMessageId(reply.getMessageId());
            //删除对应的点赞信息
            likeMapper.deleteAllMessageLike(reply.getMessageId());

            // 删除当前子留言
            messageMapper.deleteMessageById(reply.getMessageId());
        }
    }

}
