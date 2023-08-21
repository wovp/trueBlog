package com.ourblog.blog.service;

import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * ClassName: UserInterface
 * Package: com.ourblog.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/19 15:27
 */

// 个人中心 和 登录（注册，忘记密码）页面 和 管理页面 的接口
public interface UserInterface {
    // 返回一个用户的对象，里面包含用户的个人信息展示，注意实现的时候要注意返回的数据列，不要把密码也返回了
    User getUserInfo(String userID);

    // login 暂定，等token看明白后再定

    // logout 让 前端 删除本地储存

    // 注册用户，返回 1 注册成功， 0 为失败
    public int registerUser(User user);

    // 编辑个人资料，传入的参数是用户ID，和修改完的用户类的所有东西，返回的是 是否成功的标志
    public int updateUserInfo(User user);
    //忘记密码，提供密保问题答案？成功重置密码，否则显示错误.
    public String forgetpassword();
    //显示赞过用户的人
    public List<User> getlike(String userID);
    //用户的粉丝
    public List<User> getfans(String userID);
    //用户发表的博文
    public List<Essay> publishblog(String userID);
    //用户点赞过的文章,点赞是否需要单独建表？
    public List<Essay> likelog(String userID);
    //用户点赞过的评论
    // public List<Comment> likecomment(String userID);










}
