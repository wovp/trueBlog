package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.stereotype.Repository;

@Repository
public class Adminlmpl implements AdminInterface {
    @Autowired(required = false)
    private JdbcTemplate jdbc;

    //管理员删除用户
    public Result deleteUser(User user){
    Result result = new Result();
    try {
        System.out.println(user);
        jdbc.update("update user set YNlogout=1 where userid=?",user.getUserid());
        result.setCode("200");
        result.setResult("删除成功！");
        return result;
    }catch (DataAccessException e){
        result.setCode("201");
        result.setResult("删除失败");
        return result;
    }
    }
    public Result deleteUser(Essay essay){
        Result result = new Result();
        try {
            System.out.println(essay);
            jdbc.update("update essay set isDelete=1 where essayid=?",essay.getEssayid());
            result.setCode("200");
            result.setResult("删除成功！");
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("删除失败");
            return result;
        }
    }
    public Result ynadmin(String username,String password){
        Result result = new Result();
        Integer admin = 0;
        try {
            admin = jdbc.queryForObject("select id from admin where username = ? and password =?"
            ,Integer.class,username,password);
            result.setCode("200");
            result.setResult("管理员登录成功");
            return result;
        }catch (DataAccessException e){
            result.setCode("202");
            result.setResult("管理员账号或密码错误！");
            return result;
        }
    }
}
