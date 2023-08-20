package com.ourblog.blog.service;

import com.ourblog.blog.pojo.Blog;
import com.ourblog.blog.pojo.User;

import java.util.List;

/**
 * ClassName: Article
 * Package: com.ourbolg.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/18 10:33
 */

// 首页 和 分类页面 和 博客详情页（不包含评论） 和 博客发布页 的接口
public interface BlogInterface {
    // 根据传入的分类搜索博客列表
    public List<Blog> getBlogListByCategory(String category);

    // 根据关键词搜索博客标题
    public List<Blog> getBlogListByKeyInTitle(String keyWord);

    // 获取所有博客列表
    public List<Blog> getBlogList();


    // 根据博客ID获取博客详情内容,应该是博客的所有内容，也就是一个博客对象
    public Blog getBlogDetail(String blogID);


    // 根据点赞量排序获取前五个点赞量最高的博客
    public List<Blog> getBlogListByLikes();

    // 发布博客, 成功返回1， 失败返回0
    public int publishBlog(String author_id,
            String author,
                           String articleTitle,
                           String articleContent,
                           String articleCategories,
                           String publishDate,
                           String articleSummary
                            );


    // 删除博客, 成功返回1， 失败返回0
    public int deleteBlog(String blogID);

    // 博客被点赞了，成功返回1， 失败返回0
    public int addBlogLikes(String blogID);

    // 博客被取消点赞了，成功返回1， 失败返回0
    public int cancelBlogLikes(String blogID);

    // 博客被收藏了，成功返回1， 失败返回0
    public int addBlogCollects(String blogID);

    // 博客被取消收藏了，成功返回1， 失败返回0
    public int cancelBlogCollects(String blogID);

    // 博客被阅读了, 增加阅读量
    public int addBlogReaded(String blogID);

    // 返回发布博客的个人信息，用于博客详情页面使用
    User getBlogAuthor(String authorID);




}
