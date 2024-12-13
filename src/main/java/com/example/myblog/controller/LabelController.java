package com.example.myblog.controller;


import com.example.myblog.pojo.Result;
import com.example.myblog.pojo2.BlogLabel;
import com.example.myblog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class LabelController {
    @Autowired
    private LabelService Labelservice;

    @GetMapping("/api/Labels/getLabels")// 获取所有标签
    public Result getAllLabels(){
        List<BlogLabel> labels= Labelservice.getAllLabels();
        if (labels==null){
            return Result.error("标签不存在或查询出错");
        }else{
            return Result.success(labels);
        }
    }

    //增加标签
    @PostMapping("/api/Labels/addLabel")
    public Result addLabel(@RequestBody Map<String, String> params){
        String labelName=params.get("labelName");
        String labelDesc=params.get("labelDesc");
        if (labelName==null||labelName.equals("")||labelDesc==null||labelDesc.equals("")){
            return Result.error("标签名和标签描述不能为空");
        }
        if (Labelservice.addLabel(labelName, labelDesc)){
            return Result.success("添加成功");
        }else{
            return Result.error("添加失败");
        }
    }

    //删除标签
    @PostMapping("/api/Labels/deleteLabel")
    public Result deleteLabel(@RequestBody Map<String, Integer> params){
        int labelId=params.get("labelId");
        //根据标签id找标签
        BlogLabel blogLabel=Labelservice.getLabelById(labelId);
        if (blogLabel==null){
            return Result.error("标签不存在");
        }
        try {
            Labelservice.deleteLabel(labelId);
            return Result.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
}
