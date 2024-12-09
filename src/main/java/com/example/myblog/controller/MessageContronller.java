package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogMessage;
import com.example.myblog.service.MessageService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MessageContronller {
    @Autowired
    private MessageService messageService;


    //获取留言
    @GetMapping("/api/messages")
    public Result getMessages() {
        List<BlogMessage> messages = messageService.getMessages();
        return Result.success(messages);
    }

    //发布留言
    @PostMapping("/api/messages/addMessage")
    public Result addMessage(String content) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        if (content == null || content.equals("")) {
            return Result.error("留言内容不能为空");
        }
        try {
            messageService.addMessage(content, userId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("发布留言失败");
        }
    }
    //根据留言id获取留言
    @PostMapping("/api/messages/getMessageById")
    public Result getMessageById(int messageId) {
        try {
            BlogMessage message = messageService.getMessageById(messageId);
            return Result.success(message);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取留言失败");
        }
    }

    //获取我发布的留言
    @GetMapping("/api/messages/getMyMessages")
    public Result getMyMessages() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        try {
            List<BlogMessage> messages = messageService.getMessagesByUserId(userId);
            return Result.success(messages);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取我的留言失败");
        }
    }

    //获取某个人发布的留言
    @GetMapping("/api/messages/getMessagesByUserId")
    public Result getMessagesByUserId(String userId) {
        try {
            List<BlogMessage> messages = messageService.getMessagesByUserId(userId);
            return Result.success(messages);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取留言失败");
        }
    }
    //管理员置顶留言
    @PostMapping("/api/messages/pinMessage")
    public Result pinMessage(int messageId) {
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        try {
            messageService.pinMessage(messageId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("置顶留言失败");
        }
    }
    //管理员取消置顶留言
    @PostMapping("/api/messages/unpinMessage")
    public Result unpinMessage(int messageId) {
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        try {
            messageService.unpinMessage(messageId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("取消置顶留言失败");
        }
    }
    //回复留言
    @PostMapping("/api/messages/replyMessage")
    public Result replyMessage(int ParentMessageId,String content) {
        BlogMessage message = messageService.getMessageById(ParentMessageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        if (content==null||content.equals("")) {
            return Result.error("回复内容不能为空");
        }
        try {
            messageService.replyMessage(ParentMessageId,content,userId);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error("回复留言失败");
        }

    }
    //删除留言
    @PostMapping("/api/messages/deleteMessage")
    public Result deleteMessage(int messageId) {
        if (messageService.getMessageById(messageId)==null) {
            return Result.error("留言不存在");
        }
        try {
            messageService.deleteMessage(messageId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除留言失败");
        }
    }


}
