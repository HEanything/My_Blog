package com.example.myblog.service;

import com.example.myblog.pojo2.BlogMessage;

import java.util.List;

public interface MessageService {

    List<BlogMessage> getMessages();

    void addMessage(String content,String userId);

    BlogMessage getMessageById(int messageId);

    void pinMessage(int messageId);

    // 取消置顶
    void unpinMessage(int messageId);

    //获取我发布的留言
    List<BlogMessage> getMessagesByUserId(String userId);

    //回复留言
    void replyMessage(int parentMessageId, String content, String userId);

    //删除留言
    void deleteMessage(int messageId);

    //更新留言
    void updateMessage(int messageId, String content);

    //删除用户的所有留言
    void deleteUserMessages(String userId);
}
