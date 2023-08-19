package com.ourblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ourblog.blog.mapper.BlogMapper;
import com.ourblog.blog.pojo.Blog;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.impl.BlogImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@Api(tags = "首页和博客详情页的模块")
public class BlogController {

    @Autowired
    BlogImpl blogImpl;
    @ApiOperation(value = "查询所有博客列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=List.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogList")
    public Result getBlogList(){
        Result result = new Result();
        result.setResult(blogImpl.getBlogList());
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/getBlogDetail")
    public Result getBlogDetail(String id){
        Result result = new Result();
        result.setResult(blogImpl.getBlogDetail(id));
        result.setCode("200");
        return result;
    }

    @PostMapping("/api/blog/addBlog")
    public Result addBlog(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary){
        Result result = new Result();
        int i = blogImpl.publishBlog(author_id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary);
        if(i == 1) {
            result.setCode("200");
        }
        else{
            result.setCode("400");
        }
        return result;
    }

    @GetMapping("/api/blog/deleteBlog")
    public Result deleteBlog(String id){
        Result result = new Result();
        result.setResult(blogImpl.deleteBlog(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/addBlogLikes")
    public Result addBlogLikes(String id){
        Result result = new Result();
        result.setResult(blogImpl.addBlogLikes(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/cancelBlogLikes")
    public Result cancelBlogLikes(String id){
        Result result = new Result();
        result.setResult(blogImpl.cancelBlogLikes(id));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/addBlogReaded")
    public Result addBlogReaded(String id){
        Result result = new Result();
        result.setResult(blogImpl.addBlogReaded(id));
        result.setCode("200");
        return result;
    }
}
