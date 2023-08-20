package com.ourblog.blog.service;

import com.ourblog.blog.pojo.Essay;

import java.util.List;

/**
 * ClassName: friendsInterface
 * Package: com.ourblog.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/19 15:38
 */

// 朋友圈的接口
public interface friendsInterface {
    // 展示部分文章列表,返回一个博客类
    public List<Essay>getbloglist(String author_id,
                                 String keyword,
                                 String readed,
                                 String likes,
                                 String collects);

    // 根据博主id获取博主个人界面
    public Essay getauthordetail(String author_id);

    // 根据博客标题获取博客详情内容,应该是博客的所有内容，也就是一个博客对象
    public Essay getBlogDetail(String keyword);
}