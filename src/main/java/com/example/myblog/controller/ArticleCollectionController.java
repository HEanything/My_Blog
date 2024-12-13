package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogArticle;
import com.example.myblog.pojo2.BlogCollection;
import com.example.myblog.pojo2.BlogSetArticleCollection;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.CollectionService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myblog.service.ArticleCollecionService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ArticleCollectionController {
    @Autowired
    private ArticleCollecionService articleCollecionService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ArticleService articleService;

    ///////////////////////////////////////以下是用户只有单个收藏夹/////////////////////////////
    //收藏按钮
    @PostMapping("/api/collection/collectionArticle")
    public Result collectionArticle(@RequestBody Map<String, Long> params){
        Long articleId = params.get("articleId");
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogArticle blogArticle = articleService.getArticleById(Math.toIntExact(articleId));
        if (blogArticle==null){
            return Result.error("没有该文章");
        }
        try {
            //先判断对应的收藏夹是否存在
            BlogCollection blogCollection = collectionService.getDefaultCollection(userId);
            if (blogCollection == null) {
                return Result.error("收藏夹不存在");
            }
            //查询收藏夹是否存在该文章存在就删除实现取消收藏，不存在就添加收藏
            BlogSetArticleCollection blogSetArticleCollection = articleCollecionService.getArticleCollection(blogCollection.getCollectionId(), articleId);
            if (blogSetArticleCollection != null) {
                articleCollecionService.deleteArticleFromCollection(blogCollection.getCollectionId(), articleId);
                return Result.success("取消收藏成功");
            } else {
                articleCollecionService.addArticleToCollection(blogCollection.getCollectionId(), articleId);
                return Result.success("收藏成功");
            }
        }catch (Exception e){
            return Result.error("收藏失败");
        }
    }

    //收藏文章
    @PostMapping("/api/collection/addArticleToDefaultCollection")
    public Result addArticleToDefaultCollection(@RequestBody Map<String, Long> params){
        Long articleId = params.get("articleId");
        //根据用户名获取收藏夹id
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        Long blogCollectionId = collectionService.getDefaultCollection(userId).getCollectionId();

        try{
            articleCollecionService.addArticleToCollection(blogCollectionId,articleId);
            return Result.success();
        }catch (Exception e){
            return Result.error("添加失败");
        }
    }

    //获取默认收藏夹里面的文章
    @GetMapping("/api/collection/getArticlesByDefaultCollection")
    public Result getArticlesByDefaultCollection(){
        try {
            //先判断对应的收藏夹是否存在
            Map<String, Object> claims = ThreadLocalUtil.get();
            String userId = (String) claims.get("userId");
            BlogCollection blogCollection = collectionService.getDefaultCollection(userId);
            if (blogCollection == null) {
                return Result.error("收藏夹不存在");
            }
            //再判断是否有文章(这个应该由前端判断)
            List<BlogArticle> blogArticle = articleCollecionService.getArticleByCollectionId(blogCollection.getCollectionId());
            return Result.success(blogArticle);
//            if (blogArticle==null){
//                return Result.error("该收藏夹没有文章");
//            }else {
//                return Result.success(blogArticle);
//            }
        }catch (Exception e){
            return Result.error("获取失败");
        }
    }

    //取消收藏
    @PostMapping("/api/collection/deleteArticleFromDefaultCollection")
    public Result deleteArticleFromDefaultCollection(@RequestBody Map<String, Long> params){
        Long articleId = params.get("articleId");
        //先判断对应的收藏夹是否存在
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");
        BlogCollection blogCollection = collectionService.getDefaultCollection(userId);
        if (blogCollection == null) {
            return Result.error("收藏夹不存在");
        }
        try{
            articleCollecionService.deleteArticleFromCollection(blogCollection.getCollectionId(),articleId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }

    ///////////////////////////////////////以下是多个收藏夹/////////////////////////////
    //将文章收藏到收藏夹里去
    //需要收藏夹id和文章id
    @PostMapping("/api/collection/addArticleToCollection")
    public Result addArticleToCollection(@RequestBody Map<String, Long> params){
        Long collectionId=params.get("collectionId");
        Long articleId=params.get("articleId");

        //先判断是否存在收藏夹
        BlogCollection blogCollection=collectionService.getCollectionById(collectionId);
        if(blogCollection==null){
            return Result.error("收藏夹不存在");
        }
        //判断是否存在于收藏夹
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
    //需要收藏夹id和文章id
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
            //再判断是否有文章(这个应该由前端判断)
            List<BlogArticle> blogArticle=articleCollecionService.getArticleByCollectionId(collectionId);
            return Result.success(blogArticle);
//            if (blogArticle==null){
//                return Result.error("该收藏夹没有文章");
//            }else {
//                return Result.success(blogArticle);
//            }
        }catch (Exception e){
            return Result.error("获取失败");
        }

    }
}
