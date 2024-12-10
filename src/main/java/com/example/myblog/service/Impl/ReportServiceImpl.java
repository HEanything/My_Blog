package com.example.myblog.service.Impl;

import com.example.myblog.mapper.ReportMapper;
import com.example.myblog.pojo2.BlogCommentReport;
import com.example.myblog.pojo2.BlogMessageReport;
import com.example.myblog.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportMapper;


    // 举报评论
    @Override
    public void reportComment(int commentId,String commentDesciption) {
        reportMapper.reportComment(commentId,commentDesciption);
    }

    // 举报留言
    @Override
    public void reportMessage(int messageId, String messageDesciption) {
        reportMapper.reportMessage(messageId,messageDesciption);
    }

    // 获取所有评论举报
    @Override
    public List<BlogCommentReport> getAllCommentReport() {
        return reportMapper.getAllCommentReport();
    }

    //获取所有留言举报
    @Override
    public List<BlogMessageReport> getAllMessageReport() {
        return reportMapper.getAllMessageReport();
    }

    // 根据举报id获取评论举报
    @Override
    public BlogCommentReport getCommentReportById(int commentReportId) {
        return reportMapper.getCommentReportById(commentReportId);
    }

    // 根据举报id获取留言举报
    @Override
    public BlogMessageReport getMessageReportById(int messageReportId) {
        return reportMapper.getMessageReportById(messageReportId);
    }

    // 删除评论举报
    @Override
    public void deleteCommentReport(int commentReportId) {
        reportMapper.deleteCommentReport(commentReportId);

    }

    // 删除留言举报
    @Override
    public void deleteMessageReport(int messageReportId) {
        reportMapper.deleteMessageReport(messageReportId);

    }

    // 根据留言id获取留言举报
    @Override
    public List<BlogMessageReport> getAllMessageReportByMessageId(int messageId) {
        return reportMapper.getAllMessageReportByMessageId(messageId);
    }

    // 根据评论id获取评论举报
    @Override
    public List<BlogCommentReport> getAllCommentReportByCommentId(int commentId) {
        return reportMapper.getAllCommentReportByCommentId(commentId);
    }

    // 根据留言id删除留言举报
    @Override
    public void deleteMessageReportByMessageId(int messageId) {
        reportMapper.deleteMessageReportByMessageId(messageId);

    }

    // 根据评论id删除评论举报
    @Override
    public void deleteCommentReportByCommentId(int commentId) {
        reportMapper.deleteCommentReportByCommentId(commentId);

    }
}
