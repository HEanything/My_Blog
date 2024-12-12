package com.example.myblog.controller;

import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogCollection;
import com.example.myblog.service.CollectionService;
import com.example.myblog.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    //删除用户的收藏夹
    //需要先删除收藏夹的收藏关系
    @PostMapping("/api/collection/deleteDefaultCollection")
    public Result deleteDefaultCollection(){
        Map<String, Object> claims = ThreadLocalUtil.get();
        String userId = (String) claims.get("userId");

        try{
            collectionService.deleteCollection(collectionService.getDefaultCollection(userId).getCollectionId());
            return Result.success();
        }catch (Exception e){
            return Result.error("删除失败");
        }
    }



    ////////////////////////////////////以下是如果一个人可以有多个收藏夹//////////////////////////////
    //创建收藏夹
    @PostMapping("/api/collection/createCollection")
    public Result createCollection(@RequestBody Map<String, String> params){
        String collectionName=params.get("collectionName");
        String collectionDesc=params.get("collectionDesc");
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
    public Result deleteCollection(@RequestBody Map<String, Long> params){
        Long collectionId=params.get("collectionId");
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
    //修改收藏夹///////等下测试一下
    @PostMapping("/api/collection/updateCollection")
    public Result updateCollection(@RequestBody Map<String, Object> params){
        Long collectionId=(Long) params.get("collectionId");
        String collectionName=(String) params.get("collectionName");
        String collectionDesc=(String) params.get("collectionDesc");
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
