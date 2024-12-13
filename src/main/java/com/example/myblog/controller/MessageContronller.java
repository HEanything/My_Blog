package com.example.myblog.controller;

import com.example.myblog.DTO.DetailedMessage;
import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogMessage;
import com.example.myblog.service.MessageService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class MessageContronller {
    @Autowired
    private MessageService messageService;


    /////////获取详细的留言信息包括点赞
    @GetMapping("/api/messages/getDetailedMessages")
    public Result getDetailedMessages() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        List<DetailedMessage> detailedMessages = null;
        try {
            detailedMessages = messageService.getDetailedMessages(userId);
            if (detailedMessages == null && detailedMessages.isEmpty()) {
                return Result.success("留言为空");
            } else {
                return Result.success(detailedMessages);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取留言失败");
        }
    }
    //获取留言
    @GetMapping("/api/messages")
    public Result getMessages() {
        List<BlogMessage> messages = messageService.getMessages();
        return Result.success(messages);
    }

    //发布留言
    @PostMapping("/api/messages/addMessage")
    public Result addMessage(@RequestBody Map<String, String> params) {
        String content = params.get("content");
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
    public Result getMessageById(@RequestBody Map<String, Integer> params) {
        int messageId = params.get("messageId");
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

    //修改留言
    @PostMapping("/api/messages/updateMessage")
    public Result updateMessage(@RequestBody Map<String, Object> params) {
        int messageId = (int) params.get("messageId");
        String content = (String) params.get("content");
        BlogMessage message = messageService.getMessageById(messageId);
        if (message==null) {
            return Result.error("没有该留言");
        }
        if (content==null||content.equals("")) {
            return Result.error("留言内容不能为空");
        }
        try {
            messageService.updateMessage(messageId,content);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改留言失败");
        }
    }
    //获取某个人发布的留言
    @GetMapping("/api/messages/getMessagesByUserId")
    public Result getMessagesByUserId(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
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
    public Result pinMessage(@RequestBody Map<String, Integer> params) {
        int messageId = params.get("messageId");
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
    public Result unpinMessage(@RequestBody Map<String, Integer> params) {
        int messageId = params.get("messageId");
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
    public Result replyMessage(@RequestBody Map<String, Object> params) {
        int ParentMessageId = (int) params.get("ParentMessageId");
        String content = (String) params.get("content");
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
    public Result deleteMessage(@RequestBody Map<String, Integer> params) {
        int messageId = params.get("messageId");
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
