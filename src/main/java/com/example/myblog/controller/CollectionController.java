package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogCollection;
import com.example.myblog.service.CollectionService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CollectionController {
    @Autowired
    private CollectionService collectionService;


    //创建收藏夹
    @PostMapping("/api/collection/createCollection")
    public Result createCollection(String collectionName,String collectionDesc){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");

        try{
            collectionService.createCollection(collectionName,collectionDesc,userId);
            return Result.success();
        }catch (Exception e){
            return Result.error("创建失败");
        }
    }

    //获得登录用户自己的收藏夹
    @GetMapping("/api/collection/getCollections")
    public Result getCollections(){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");

        try{
            List<BlogCollection> collections=collectionService.getCollections(userId);
            if (collections.size()==0){
                return Result.error("没有收藏夹");
            }else {
                return Result.success(collections);
            }

        }catch (Exception e){
            return Result.error("获取失败");
        }
    }
    //删除收藏夹
    @PostMapping("/api/collection/deleteCollection")
    public Result deleteCollection(Long collectionId){
        BlogCollection collection=collectionService.getCollectionById(collectionId);
        if (collection==null)
        {
            return Result.error("收藏夹不存在");
        }
        try{
            collectionService.deleteCollection(collectionId);
            return Result.success();
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }
    //修改收藏夹
    @PostMapping("/api/collection/updateCollection")
    public Result updateCollection(Long collectionId,String collectionName,String collectionDesc){
        BlogCollection collection=collectionService.getCollectionById(collectionId);
        if (collection==null)
        {
            return Result.error("收藏夹不存在");
        }
        try{
            collectionService.updateCollection(collectionId,collectionName,collectionDesc);
            return Result.success();
        }catch (Exception e){
            return Result.error("修改失败");
        }
    }
}
