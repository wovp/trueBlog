package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.UserInterface;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public  class UserImpl implements UserInterface {
    private JdbcTemplate jdbc;

    @Override
    // 返回一个用户的对象，里面包含用户的个人信息展示,！！！密码处理问题待定
    public Result getUserInfo(String userID) {
        Result result = new Result();
        User user1 = null;
        user1 = jdbc.queryForObject("select userid from user where userid=?",
                new BeanPropertyRowMapper<>(User.class), userID);
        try {
            if (user1 == null) {
                result.setCode("200");
                result.setResult("用户id错误");
            } else {
                result.setCode("200");
                result.setResult(jdbc.query("select * from user where userid=?",
                        new BeanPropertyRowMapper<>(User.class), userID));
            }
            return result;
        } catch (DataAccessException e) {
            e.printStackTrace();
            result.setCode("201");
            result.setResult("查询失败");
            return result;
        }
    }

    @Override
    // 注册用户，返回 200 注册成功， 201 为失败,初始Ynlogout都置0
    public Result registerUser(User user) {
        Result result = new Result();
        User user1 = null;
        user1 = jdbc.queryForObject("select username from user where username=?",
                new BeanPropertyRowMapper<>(User.class), user.getUsername());
        try {
            if (user1 == null) {
                jdbc.update("insert into user(avatar, birthday, phonenumber, age, " +
                                "password, nickname, mailbox, username,gender,YNlogout)VALUES (?,?,?,?,?,?,?,?,?)",
                        user.getAvatar(), user.getBirthday(), user.getPhonenumber(),
                        user.getAge(), user.getPassword(), user.getNickname(), user.getMailbox(),
                        user.getUsername(), user.getGender(), user.getYNlogout());
                result.setCode("200");
                result.setResult("注册成功！");
                return result;
            } else {
                result.setCode("200");
                result.setResult("用户名已存在！");
                return result;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            result.setCode("201");
            result.setResult("注册失败");
            return result;
        }



    /*@Override
    public int updateUserInfo(User user) {
        return 0;
    }

    @Override
    public String forgetpassword() {
        return null;
    }

    @Override
    public List<User> getlike(String userID) {
        return null;
    }

    @Override
    public List<User> getfans(String userID) {
        return null;
    }

    @Override
    public List<Blog> publishblog(String userID) {
        return null;
    }

    @Override
    public List<Blog> likelog(String userID) {
        return null;
    }*/
    }

    @Override
    public int updateUserInfo(User user) {
        return 0;
    }

    @Override
    public String forgetpassword() {
        return null;
    }

    @Override
    public List<User> getlike(String userID) {
        return null;
    }

    @Override
    public List<User> getfans(String userID) {
        return null;
    }
}