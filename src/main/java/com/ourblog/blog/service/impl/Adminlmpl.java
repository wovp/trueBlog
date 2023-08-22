package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Adminlmpl implements AdminInterface {
    @Autowired(required = false)
    private JdbcTemplate jdbc;

    //管理员删除用户
    public Result deleteUser(String username){
    Result result = new Result();
    try {
        System.out.println(username);
        jdbc.update("update user set YNlogout=1 where user.username=?",username);
        result.setCode("200");
        result.setResult("删除成功！");
        return result;
    }catch (DataAccessException e){
        result.setCode("201");
        result.setResult("删除失败");
        return result;
    }
    }
}
