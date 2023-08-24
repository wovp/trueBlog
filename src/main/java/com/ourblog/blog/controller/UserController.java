package com.ourblog.blog.controller;
import com.alibaba.fastjson.JSONObject;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.impl.UserImpl;
import com.sun.javafx.collections.MappingChange;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

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
@Api(tags = "用户模块")
public class UserController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    UserImpl userImpl;
    @ApiOperation(value = "注册用户",
            protocols = "http",
            httpMethod="POST",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示注册成功,返回‘注册成功’" +
                    "code:201 表示注册失败"+
                    "code:202 表示用户名已存在")
    @PostMapping("/api/blog/registerUser")
    public Result registerUser(@RequestBody User user){
        Result result = new Result();
        System.out.println("user 输出");
        System.out.println(user);
        result=userImpl.registerUser(user);
        return result;
    }

    @ApiOperation(value = "查询所有用户数据",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功,返回用户个人资料" +
                    "code:200 表示查询失败"+
                    "code:202 表示用户名错误")
    @GetMapping("/api/blog/getUserInfo")
    public Result getUserInfo( String username){
        Result result = new Result();
        result=userImpl.getUserInfo(username);
        return result;
    }

    @ApiOperation(value = "查询用户粉丝数量",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 取消失败")
    @GetMapping("/api/blog/getfans")
    public Result getfans(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getfans(username);
        return result;
    }

    @ApiOperation(value = "修改个人资料",
            protocols = "http",
            httpMethod="POST",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 表示失败")
    @PostMapping("/api/blog/updateUserInfo")
    public Result updateUserInfo(@RequestBody User user){
        Result result = new Result();
        result=userImpl.updateUserInfo(user);
        return result;
    }

    @ApiOperation(value = "找回密码",
            protocols = "http",
            httpMethod="POST",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 重置密码" +
                    "code:201 修改失败" +
                    "code:202 手机号与账户不匹配")
    @PostMapping("/api/blog/forgetpass")
    public Result forgetpass(@RequestBody User user){
        Result result = new Result();
        result=userImpl.forgetpass(user);
        return result;
    }

    @ApiOperation(value = "查询用户发布过的文章列表",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 查找失败")
    @GetMapping("/api/blog/getpublishblog")
    public Result getpublishblog(String userid) {
        Result result = new Result();
        result=userImpl.getpublishblog(userid);
        return result;
    }

    @ApiOperation(value = "查询用户发布过的博文数量",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功，返回数量" +
                    "code:201 查找失败")
    @GetMapping("/api/blog/getpublishs")
    public Result getpublishs(String userid) {
        Result result = new Result();
        result=userImpl.getpublishs(userid);
        return result;
    }

    @ApiOperation(value = "查询用户收藏文章列表",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:202 表示成功并提醒没有发布过文章" +
                    "code:201 查找失败")
    @GetMapping("/api/blog/getcollectblog")
    public Result getcollectblog(String username) {
        Result result = new Result();
        result=userImpl.getcollectblog(username);
        return result;
    }

    @ApiOperation(value = "查询用户收藏文章数量",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:202 表示成功并提醒没有发布过文章" +
                    "code:201 查找失败")
    @GetMapping("/api/blog/getcollects")
    public Result getcollects(String username) {
        Result result = new Result();
        result=userImpl.getcollects(username);
        return result;
    }

    @ApiOperation(value = "取消收藏",
            protocols = "http",
            httpMethod="POST",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 取消失败")
    @PostMapping("/api/blog/oneunbook")
    public Result oneunbook(@RequestBody JSONObject object){
        Result result = new Result();
        result=userImpl.oneunbook(object.getString("username"));
        return result;
    }

    @ApiOperation(value = "一键取消所有收藏",
            protocols = "http",
            httpMethod="POST",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 取消失败")
    @PostMapping("/api/blog/unbook")
    public Result unbook(@RequestBody JSONObject object){
        Result result = new Result();
        result=userImpl.unbook(object.getString("username"),object.getString("essayid"));
        return result;
    }

    @ApiOperation(value = "查询该用户关注数",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功，返回用户粉丝数" +
                    "code:201 表示查找失败")
    @GetMapping("/api/blog/getcares")
    public Result getcares(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getcares(username);
        return result;
    }

    @ApiOperation(value = "查询粉丝列表",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:202 成功并提醒尚无粉丝" +
                    "code:201 表示失败")
    @GetMapping("/api/blog/getfanInfo")
    public Result getfanInfo(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getfanInfo(username);
        return result;
    }

    @ApiOperation(value = "查询关注列表",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功" +
                    "code:201 成功并提醒尚未关注" +
                    "code:201 表示查找失败")
    @GetMapping("/api/blog/getcareInfo")
    public Result getcareInfo(String username) {
        Result result = new Result();
        System.out.println(username);
        result=userImpl.getcareInfo(username);
        return result;
    }


    @GetMapping("/api/blog/login")
    public User login(String username,String password) {
        User result = new User();
        result=userImpl.login(username, password);
        return result;
    }
    @GetMapping("/api/blog/faninfopage")
    public Result faninfopage(String userid) {
        Result result = new Result();
        System.out.println(userid);
        result=userImpl.faninfopage(userid);
        return result;
    }

}
