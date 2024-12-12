package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogSetArticleLabel;
import com.example.myblog.service.ArticleLabelService;
import com.example.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ArticleLabelController {
    @Autowired
    private ArticleLabelService articleLabelService;
    //给文章设置标签
    //为文章设置标签（更新）
    //若没有标签就设置标签，有就更新
    @PostMapping("/api/Articles/{articleId}/setLabels")
    public Result setLabels(@PathVariable int articleId, @RequestBody Map<String, String> params) {
        String labelId=params.get("labelId");
        BlogSetArticleLabel blogSetArticleLabel=articleLabelService.getLabelByArticleId(articleId);
        if (blogSetArticleLabel!=null){
            try {
                articleLabelService.updateLabels(articleId, labelId);
                return Result.success();
            }catch (Exception e){
                e.printStackTrace();
                return Result.error("设置标签失败");
            }
        }
        try {
            articleLabelService.setLabels(articleId, labelId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("设置标签失败");
        }
    }

    //删除文章标签
    //需要文章id
    @PostMapping("/api/Articles/{articleId}/deleteLabels")
    public Result deleteLabels(@PathVariable int articleId) {
        try {
            articleLabelService.deleteLabels(articleId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除标签失败");
        }
    }
}
