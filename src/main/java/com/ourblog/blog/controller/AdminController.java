package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.impl.Adminlmpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "管理员功能的实现")
public class AdminController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    Adminlmpl adminlmpl;
    @PostMapping("/api/blog/deleteUser")
    public Result deleteUser(@RequestBody User user){
        Result result = new Result();
        result=adminlmpl.deleteUser(user);
        return result;
    }
    @PostMapping("/api/blog/deleteessay")
    public Result deleteessay(@RequestBody Essay essay){
        Result result = new Result();
        result=adminlmpl.deleteUser(essay);
        return result;
    }

    @ApiOperation(value = "查询所有⽤户数据",
            protocols = "http",
            httpMethod="GET",
            consumes="application/json",
            response= List.class,
            notes = "code:200 表示成功")
    @GetMapping("/api/blog/ynadmin")
    public Result ynadmin(String username,String password){
        Result result = new Result();
        result=adminlmpl.ynadmin(username,password);
        return result;
    }
    /*

    @GetMapping("/api/blog/classcount")
    public Result classcount(){
        Result result = new Result();
        result=adminlmpl.classcount();
        return result;
    }
    @GetMapping("/api/blog/countread")
    public Result ecocount(){
        Result result = new Result();
        result=adminlmpl.countread();
        return result;
    }
    @GetMapping("/api/blog/countuser")
    public Result countuser(){
        Result result = new Result();
        result=adminlmpl.countuser();
        return result;
    }*/


}
