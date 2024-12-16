package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogLabel;
import com.example.myblog.pojo2.BlogSetArticleLabel;
import com.example.myblog.service.ArticleLabelService;
import com.example.myblog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ArticleLabelController {
    @Autowired
    private ArticleLabelService articleLabelService;
    @Autowired
    private LabelService LabelService;
    //给文章设置标签///目前是根据标签id设置
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
    //////////////根据标签名设置标签/////
    @PostMapping("/api/Articles/{articleId}/setLabelsByName")
    public Result setLabelsByName(@PathVariable int articleId, @RequestBody Map<String, String> params) {
        String labelName=params.get("labelName");
        ////根据标签名查找标签id
        BlogLabel blogLabel=LabelService.getLabelByName(labelName);
        if (blogLabel==null){
            return Result.error("标签不存在");
        }else{
            String labelId=String.valueOf(blogLabel.getLabelId());
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
