package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.impl.EssayImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ClassName: BlogController
 * Package: com.ourbolg.blog.controller
 * Description:
 * Author: my
 * Creat: 2023/8/18 14:42
 * @author 11
 */
@RestController
@CrossOrigin(origins = "*")
@Api(tags = "首页 博客详情页 博客发布的模块")
public class EssayController {

    @Autowired
    EssayImpl essayImpl;
    @ApiOperation(value = "查询所有博客列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=List.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogList")
    public Result getEssayList(){
        Result result = new Result();
        result.setResult(essayImpl.getEssayList());
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/getEssayListByCategory")
    public Result getEssayListByCategory(String classify){
        Result result = new Result();
        result.setResult(essayImpl.getEssayListByCategory(classify));
        result.setCode("200");
        return result;
    }



    @GetMapping("/api/blog/getBlogByKeyword")
    public Result getBlogByKeyword(String keyword){
        Result result = new Result();
        keyword = "'%" + keyword + "%'";
        result.setResult(essayImpl.getEssayListByKeyInTitle(keyword));
        result.setCode("200");
        return result;
    }


    @GetMapping("/api/blog/getBlogDetail")
    public Result getEssayDetail(String id){
        Result result = new Result();
        result.setResult(essayImpl.getEssayDetail(id));
        result.setCode("200");
        return result;
    }



    @PostMapping("/api/blog/addBlog")
    public Result addEssay(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary){
        Result result = new Result();
        int i = essayImpl.publishEssay(author_id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary);
        if(i == 1) {
            result.setCode("200");
        }
        else{
            result.setCode("400");
        }
        return result;
    }

    @GetMapping("/api/blog/deleteBlog")
    public Result deleteEssay(String id){
        Result result = new Result();
        result.setResult(essayImpl.deleteEssay(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/addBlogLikes")
    public Result addEssayLikes(String id){
        Result result = new Result();
        result.setResult(essayImpl.addEssayLikes(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/cancelBlogLikes")
    public Result cancelEssayLikes(String id){
        Result result = new Result();
        result.setResult(essayImpl.cancelEssayLikes(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/addBlogReaded")
    public Result addEssayReaded(String id){
        Result result = new Result();
        result.setResult(essayImpl.addEssayReaded(id));
        result.setCode("200");
        return result;
    }


    // --------------------------------
    // 下面是引入的 解析word文档的函数
    @ApiOperation(value = "上传word文档发布博客",
            protocols = "http",
            httpMethod = "GET",
            consumes="file",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @PostMapping("/api/blog/addBlogByWord")
    public Result addEssayByWord(@RequestParam(value = "file", required = true) MultipartFile file){
        Result result = new Result();
        result.setResult(essayImpl.getEssayList());
        result.setCode("200");
        return result;
    }
}
