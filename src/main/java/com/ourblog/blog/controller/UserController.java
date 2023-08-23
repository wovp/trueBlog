package com.ourblog.blog.controller;
import com.alibaba.fastjson.JSONObject;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.impl.UserImpl;
import com.sun.javafx.collections.MappingChange;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import java.util.List;
import java.util.Map;

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
@Api(tags = "用户个人信息展示、注册的模块")
public class UserController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    UserImpl userImpl;
    @PostMapping("/api/blog/registerUser")
    public Result registerUser(@RequestBody User user){
        Result result = new Result();
        System.out.println("user 输出");
        System.out.println(user);
        result=userImpl.registerUser(user);
        return result;
    }
    @GetMapping("/api/blog/getUserInfo")
    public Result getUserInfo( String username){
        Result result = new Result();
        result=userImpl.getUserInfo(username);
        return result;
    }
    @GetMapping("/api/blog/getfans")
    public Result getfans(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getfans(username);
        return result;
    }
    @PostMapping("/api/blog/updateUserInfo")
    public Result updateUserInfo(@RequestBody User user){
        Result result = new Result();
        result=userImpl.updateUserInfo(user);
        return result;
    }
    @PostMapping("/api/blog/forgetpass")
    public Result forgetpass(@RequestBody User user){
        Result result = new Result();
        result=userImpl.forgetpass(user);
        return result;
    }
    @GetMapping("/api/blog/getpublishblog")
    public Result getpublishblog(String userid) {
        Result result = new Result();
        result=userImpl.getpublishblog(userid);
        return result;
    }
    @GetMapping("/api/blog/getpublishs")
    public Result getpublishs(String userid) {
        Result result = new Result();
        result=userImpl.getpublishs(userid);
        return result;
    }
    @GetMapping("/api/blog/getcollectblog")
    public Result getcollectblog(String username) {
        Result result = new Result();
        result=userImpl.getcollectblog(username);
        return result;
    }
    @GetMapping("/api/blog/getcollects")
    public Result getcollects(String username) {
        Result result = new Result();
        result=userImpl.getcollects(username);
        return result;
    }

    @PostMapping("/api/blog/oneunbook")
    public Result oneunbook(@RequestBody JSONObject object){
        Result result = new Result();
        result=userImpl.oneunbook(object.getString("username"));
        return result;
    }


    @PostMapping("/api/blog/unbook")
    public Result unbook(@RequestBody JSONObject object){
        Result result = new Result();
        result=userImpl.unbook(object.getString("username"),object.getString("essayid"));
        return result;
    }

    @GetMapping("/api/user/getUserListByPublishBlog")
    public Result getUserListByPublishBlog() {
        Result result = new Result();
        result.setCode("200");
        result.setResult(userImpl.getUserListByPublishBlog());
        return result;
    }


    /*@PostMapping("/api/blog/unbook")
    public Result (@RequestParam ){
    @GetMapping("/api/blog/getcares")
    public Result getcares(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getcares(username);
        return result;
    }
    @GetMapping("/api/blog/getfanInfo")
    public Result getfanInfo(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getfanInfo(username);
        return result;
    }
    @GetMapping("/api/blog/getcareInfo")
    public Result getcareInfo(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getcareInfo(username);
        return result;
    }
}
