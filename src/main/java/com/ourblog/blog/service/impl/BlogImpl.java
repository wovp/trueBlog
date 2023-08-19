package com.ourblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ourblog.blog.mapper.BlogMapper;
import com.ourblog.blog.pojo.Blog;
import com.ourblog.blog.service.BlogInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: BlogImpl
 * Package: com.ourblog.blog.service.impl
 * Description:
 * Author: my
 * Creat: 2023/8/19 10:44
 */
@Repository
public class BlogImpl implements BlogInterface {
    @Autowired(required = false)
    BlogMapper blogMapper;
    @Override
    public List<Blog> getBlogListByCategory(String category) {
        QueryWrapper<Blog> query = new QueryWrapper<>();
        query.eq("articleCategories", category);
        List<Blog> blogs = blogMapper.selectList(query);

        return blogs;
    }

    @Override
    public List<Blog> getBlogListByKeyInTitle(String keyWord) {
        QueryWrapper<Blog> query = new QueryWrapper<>();
        query.like("articleTitle", keyWord);
        List<Blog> blogs = blogMapper.selectList(query);

        return blogs;
    }

    @Override
    public List<Blog> getBlogList() {
        QueryWrapper<Blog> query = new QueryWrapper<>();
        query.select("id", "author", "articleTitle", "articleCategories", "publishDate", "articleSummary", "likes", "collects");
        List<Blog> blogs = blogMapper.selectList(query);
        return blogs;
    }

    @Override
    public Blog getBlogDetail(String blogID) {
        Blog blog = blogMapper.selectById(blogID);
        return blog;
    }

    @Override
    public List<Blog> getBlogListByLikes() {
        QueryWrapper<Blog> query = new QueryWrapper<>();
        query.orderByDesc("likes").last("limit 5");
        List<Blog> blogs = blogMapper.selectList(query);
        return blogs;
    }

    @Override
    public int publishBlog(String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary) {
        return 0;
    }

    @Override
    public int deleteBlog(String blogID) {
        return 0;
    }

    @Override
    public int addBlogLikes(String blogID) {
        return 0;
    }

    @Override
    public int cancelBlogLikes(String blogID) {
        return 0;
    }

    @Override
    public int addBlogCollects(String blogID) {
        return 0;
    }

    @Override
    public int cancelBlogCollects(String blogID) {
        return 0;
    }

    @Override
    public int addBlogReaded(String blogID) {
        return 0;
    }

}
