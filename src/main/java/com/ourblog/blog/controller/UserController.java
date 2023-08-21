package com.ourblog.blog.controller;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.impl.UserImpl;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;



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
        result=userImpl.getfans(username);
        return result;
    }
    @PostMapping("/api/blog/updateUserInfo")
    public Result updateUserInfo(@RequestBody User user){
        Result result = new Result();
        result=userImpl.updateUserInfo(user);
        return result;
    }

}