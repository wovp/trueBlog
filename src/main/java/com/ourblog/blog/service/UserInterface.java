package com.ourblog.blog.service;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;

import java.util.List;
import java.util.Map;

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
    Result getUserInfo(String userID);

    // login 暂定，等token看明白后再定

    // logout 让 前端 删除本地储存

    // 注册用户，返回 1 注册成功， 0 为失败
    public Result registerUser(User user);

    //根据用户名，获取该用户的关注的人总数
    Result getcares(String username);

    Result updateUserInfo(User user);
    //忘记密码，提供密保问题答案？成功重置密码，否则显示错误.
    public String forgetpassword();

    //查找用户发布过的文章
    Result getpublishblog(String userid);

    Result getpublishs(String userid);

    //显示赞过用户的人
    public List<User> getlike(String userID);
    //用户的粉丝
    public Result getfans(String userID);

    //查找用户发布过的文章
    Result getcollectblog(String userid);

    //获取收藏数量
    Result getcollects(String username);

    Result unbook(String username);

    Result unbook(String username, String essayid);

    //取消收藏
    Result oneunbook(String username);

    Result getfanInfo(String username);

    // 返回用户排行榜，是通过发布博客数量排序
    List<Map<String, Object>> getUserListByPublishBlog();

    User getUserInfoByToken(String token);
    //用户发表的博文
    //public List<Blog> publishblog(String userID);
    //用户点赞过的文章,点赞是否需要单独建表？
    //public List<Blog> likelog(String userID);
    //用户点赞过的评论
    // public List<Comment> likecomment(String userID);










}
