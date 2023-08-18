package com.ourblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ourblog.blog.mapper.BlogMapper;
import com.ourblog.blog.pojo.Blog;
import com.ourblog.blog.pojo.BlogResult;
import com.ourblog.blog.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class BlogController {
    @Autowired
    private BlogMapper blogMapper;


    // 下面是测试的数据
    @GetMapping("/blog")
    public Result Hello() {
        // 查询特定字段
        QueryWrapper<Blog> BlogQueryWrapper = new QueryWrapper<>();
        BlogQueryWrapper.select("author", "articleTitle");

        List<Blog> blogs = blogMapper.selectList(BlogQueryWrapper);
        List<BlogResult> blogResults = new ArrayList<BlogResult>();
        for (Blog blog : blogs) {
            BlogResult blogResult = new BlogResult(blog);
            blogResults.add(blogResult);
        }
        Result result = new Result();
        result.setResult(blogResults);
        result.setCode("201");
        return result;
    }
}
