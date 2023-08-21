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
    @Autowired(required= false)
    private JdbcTemplate jdbc;

    UserImpl userImpl;
    @PostMapping("/api/blog/registerUser")
    public Result registerUser(@RequestBody User user){
        Result result = new Result();
        result=userImpl.registerUser(user);
        return result;
    }

}
