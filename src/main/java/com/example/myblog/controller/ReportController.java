package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogCommentReport;
import com.example.myblog.pojo2.BlogMessage;
import com.example.myblog.pojo2.BlogMessageReport;
import com.example.myblog.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    //举报评论
    @PostMapping("/api/report/reportcomment")
    public Result reportComment(int commentId,String commentDesciption){
        try {
            reportService.reportComment(commentId,commentDesciption);
            return Result.success();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //举报留言
    @PostMapping("/api/report/reportmessage")
    public Result reportMessage(int messageId,String messageDesciption){
        try {
            reportService.reportMessage(messageId,messageDesciption);
            return Result.success();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //获取所有评论举报信息
    @GetMapping("/api/report/getallcommentreport")
    public Result getAllCommentReport(){
        try {
            List<BlogCommentReport> blogCommentReports = reportService.getAllCommentReport();
            return Result.success(blogCommentReports);
        }catch (Exception e){
            return Result.error("获取评论举报信息失败");
        }

    }
    //获取所有留言举报信息
    @GetMapping("/api/report/getallmessagereport")
    public Result getAllMessageReport(){
        try {
            List<BlogMessageReport> blogMessageReports = reportService.getAllMessageReport();
            return Result.success();
        }catch (Exception e){
            return Result.error("获取留言举报信息失败");
        }
    }
    //根据举报id获得评论举报信息
    @GetMapping("/api/report/getcommentreportbyid")
    public Result getCommentReportById(int commentReportId){
        try {
            BlogCommentReport blogCommentReport = reportService.getCommentReportById(commentReportId);
            return Result.success(blogCommentReport);
        }catch (Exception e){
            return Result.error("获取评论举报信息失败");
        }
    }
    //根据举报id获得留言举报信息
    @GetMapping("/api/report/getmessagereportbyid")
    public Result getMessageReportById(int messageReportId){
        try {
            BlogMessageReport blogMessageReport = reportService.getMessageReportById(messageReportId);
            return Result.success(blogMessageReport);
        }catch (Exception e){
            return Result.error("获取留言举报信息失败");
        }
    }
    //根据举报id删除评论举报
    @PostMapping("/api/report/deletecommentreport")
    public Result deleteCommentReport(int commentReportId){
        try {
            reportService.deleteCommentReport(commentReportId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除评论举报失败");
        }
    }
    //根据举报id删除留言举报
    @PostMapping("/api/report/deletemessagereport")
    public Result deleteMessageReport(int messageReportId){
        try {
            reportService.deleteMessageReport(messageReportId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除留言举报失败");
        }
    }
    //根据留言id获得所有关于其的举报
    @GetMapping("/api/report/getallmessagereportbymessageid")
    public Result getAllMessageReportByMessageId(int messageId){
        try {
            List<BlogMessageReport> blogMessageReports = reportService.getAllMessageReportByMessageId(messageId);
            return Result.success(blogMessageReports);
        }catch (Exception e){
            return Result.error("获取留言举报信息失败");
        }
    }
    //根据评论id获得所有关于其的举报
    @GetMapping("/api/report/getallcommentreportbycommentid")
    public Result getAllCommentReportByCommentId(int commentId){
        try {
            List<BlogCommentReport> blogCommentReports = reportService.getAllCommentReportByCommentId(commentId);
            return Result.success(blogCommentReports);
        }catch (Exception e){
            return Result.error("获取评论举报信息失败");
        }
    }
    //删除评论或留言可能会用，前端未必会用，先写着
    //根据留言id删除所有关于其的举报
    @PostMapping("/api/report/deletemessagereportbymessageid")
    public Result deleteMessageReportByMessageId(int messageId){
        try {
            reportService.deleteMessageReportByMessageId(messageId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除留言举报失败");
        }
    }
    //根据评论id删除所有关于其的举报
    @PostMapping("/api/report/deletecommentreportbycommentid")
    public Result deleteCommentReportByCommentId(int commentId){
        try {
            reportService.deleteCommentReportByCommentId(commentId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除评论举报失败");
        }
    }
}
