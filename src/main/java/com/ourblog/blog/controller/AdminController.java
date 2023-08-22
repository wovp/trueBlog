package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.impl.Adminlmpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "管理员功能的实现")
public class AdminController {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    Adminlmpl adminlmpl;
    @RequestMapping("/api/blog/deleteUser")
    public Result updateUserInfo(@RequestParam("username") String username){
        Result result = new Result();
        System.out.println(username);
        result=adminlmpl.deleteUser(username);
        return result;
    }
}
