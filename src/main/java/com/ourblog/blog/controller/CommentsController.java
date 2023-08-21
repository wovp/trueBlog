package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
//import com.ourblog.blog.service.impl.CommentsImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: CommentsController
 * Package: com.ourblog.blog.controller
 * Description:
 * Author: my
 * Creat: 2023/8/20 12:09
 * @author 11
 */

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "博客详情页的评论 （重点是评论） 接口")
public class CommentsController {

    /*@Autowired(required = false)
    CommentsImpl commentsImpl;
    @ApiOperation(value = "根据博客id查询所有评论列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response= List.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/comment/getCommentList")
    public Result getCommentList(String id){
        Result result = new Result();
        result.setResult(commentsImpl.showCommentsList(Integer.parseInt(id)));
        result.setCode("200");
        return result;
    }*/
}
