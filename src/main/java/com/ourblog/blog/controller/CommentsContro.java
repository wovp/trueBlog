package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.impl.CommentsImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
//        int sum_read = 0;
//        String sql_re = "select read_num from user_to_eassy_likes_collect_read where eassy_id = ?";
//        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList(sql_re, aid);
//        for (Map<String, Object> map1 : maps1) {
//            int read_num = Integer.parseInt(map1.get("read_num").toString());
//            sum_read += read_num;
//        }
        List<Map<String, Object>> maps = comments.showCommentsList(aid);
        result.setResult(maps);
        result.setCode("200");
        return result;
    }
}
