package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogCollection;
import com.example.myblog.pojo2.BlogSetArticleCollection;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblog.service.ArticleCollecionService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ArticleCollectionController {
    @Autowired
    private ArticleCollecionService articleCollecionService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ArticleService articleService;

    //将文章收藏到收藏夹里去
    //需要置顶收藏夹id和文章id
    @PostMapping("/api/collection/addArticleToCollection")
    public Result addArticleToCollection(Long collectionId,Long articleId){

        //先判断是否存在收藏夹
        BlogSetArticleCollection blogSetArticleCollection=articleCollecionService.getArticleCollection(collectionId,articleId);
        if(blogSetArticleCollection!=null){
            return Result.error("文章已经存在于该收藏夹中");
        }
        try{
            articleCollecionService.addArticleToCollection(collectionId,articleId);
            return Result.success();
        }catch (Exception e){
            return Result.error("添加失败");
        }
    }
    //取消某篇文章的收藏
    //需要置顶收藏夹id和文章id
    @PostMapping("/api/collection/deleteArticleFromCollection")
    public Result deleteArticleFromCollection(Long collectionId,Long articleId){
        BlogSetArticleCollection blogSetArticleCollection=articleCollecionService.getArticleCollection(collectionId,articleId);
        if(blogSetArticleCollection==null){
            return Result.error("文章不存在于该收藏夹中");
        }
        try{
            articleCollecionService.deleteArticleFromCollection(collectionId,articleId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }

    //获取收藏夹的文章(传的文章没有标签，不过前端应该只需要显示文章名就行)
    //需要传入收藏夹id
    @PostMapping("/api/collection/getArticlesByCollection")
    public Result getArticlesByCollection(Long collectionId){
        try {
            //先判断对应的收藏夹是否存在
            BlogCollection blogCollection=collectionService.getCollectionById(collectionId);
            if (blogCollection==null){
                return Result.error("收藏夹不存在");
            }
            //再判断是否有文章
            List<BlogArticle> blogArticle=articleCollecionService.getArticleByCollectionId(collectionId);
            if (blogArticle==null){
                return Result.error("该收藏夹没有文章");
            }else {
                return Result.success(blogArticle);
            }
        }catch (Exception e){
            return Result.error("获取失败");
        }

    }
}
