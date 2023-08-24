package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.impl.CommentsImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CommentsContro
 * Package: com.ourblog.blog.controller
 * Description:
 * Author: my
 * Creat: 2023/8/22 20:52
 */
@RestController
@CrossOrigin(origins = "*")
@Api(tags = "首页 博客详情页 博客发布的模块 还有个人中心对博客的操作模块")
public class CommentsContro {
    @Autowired
    CommentsImpl comments;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/api/blog/getCommentsList")
    public Result getEssayList(String aid){
        Result result = new Result();
        List<Map<String, Object>> maps = comments.showCommentsList(aid);
        result.setResult(maps);
        result.setCode("200");
        return result;
    }

    @PostMapping("/api/blog/addComment")
    public Result addComment(@RequestBody Map<String, String> map){
        String aid = map.get("aid");
        String uid = map.get("uid");
        String context = map.get("context");
        Result result = new Result();
        int i = comments.addComment(context, uid, aid);
        result.setResult(i);
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/likeComment")
    public Result likeComment(String cid, String uid){
        Result result = new Result();
        int i = comments.likeComment(uid, cid);
        result.setResult(i);
        result.setCode("200");
        return result;
    }
}
