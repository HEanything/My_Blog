package com.example.myblog.service;

import com.example.myblog.pojo2.BlogCommentReport;
import com.example.myblog.pojo2.BlogMessageReport;

import java.util.List;

public interface ReportService {

    //举报评论
    void reportComment(int commentId,String commentDesciption);

    //举报留言
    void reportMessage(int messageId, String messageDesciption);

    //获取所有评论的举报
    List<BlogCommentReport> getAllCommentReport();

    //获取所有留言举报
    List<BlogMessageReport> getAllMessageReport();

    //根据id获取举报信息
    BlogCommentReport getCommentReportById(int commentReportId);

    BlogMessageReport getMessageReportById(int messageReportId);

    //根据举报id删除对应的举报
    void deleteCommentReport(int commentReportId);

    void deleteMessageReport(int messageReportId);

    //根据留言id获取所有该留言的举报
    List<BlogMessageReport> getAllMessageReportByMessageId(int messageId);

    //根据评论id获取所有该评论的举报
    List<BlogCommentReport> getAllCommentReportByCommentId(int commentId);

    //根据留言id删除所有该留言的举报
    void deleteMessageReportByMessageId(int messageId);

    //根据评论id删除所有该评论的举报
    void deleteCommentReportByCommentId(int commentId);
}
