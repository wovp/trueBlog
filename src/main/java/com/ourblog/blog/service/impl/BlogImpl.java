package com.ourblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ourblog.blog.mapper.BlogMapper;
import com.ourblog.blog.pojo.Blog;
import com.ourblog.blog.service.BlogInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
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
    public int publishBlog(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary) {
        Blog blog = new Blog(author_id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary);
        int insert = blogMapper.insert(blog);
        return insert;
    }

    @Override
    public int deleteBlog(String blogID) {
        QueryWrapper<Blog> query = new QueryWrapper<>();
        query.eq("id", blogID);
        int delete = blogMapper.delete(query);
        return delete;
    }

    @Override
    public int addBlogLikes(String blogID) {
        UpdateWrapper<Blog> update = new UpdateWrapper<>();
        update.setSql("likes = likes + 1");
        Blog blog = blogMapper.selectById(blogID);
        int update1 = blogMapper.update(blog, update);
        return update1;
    }

    @Override
    public int cancelBlogLikes(String blogID) {
        UpdateWrapper<Blog> update = new UpdateWrapper<>();
        update.setSql("likes = likes - 1");
        Blog blog = blogMapper.selectById(blogID);

        // 当点赞数为0 不能取消点赞
        if(blog.getLikes() == 0){
            return 0;
        }
        int update1 = blogMapper.update(blog, update);
        return update1;
    }

    @Override
    public int addBlogCollects(String blogID) {
        UpdateWrapper<Blog> update = new UpdateWrapper<>();
        update.setSql("collects = collects + 1");
        Blog blog = blogMapper.selectById(blogID);
        int update1 = blogMapper.update(blog, update);
        return update1;
    }

    @Override
    public int cancelBlogCollects(String blogID) {
        UpdateWrapper<Blog> update = new UpdateWrapper<>();
        update.setSql("collects = collects - 1");
        Blog blog = blogMapper.selectById(blogID);

        // 当收藏数为0
        if(blog.getLikes() == 0){
            return 0;
        }
        int update1 = blogMapper.update(blog, update);
        return update1;
    }

    @Override
    public int addBlogReaded(String blogID) {
        UpdateWrapper<Blog> update = new UpdateWrapper<>();
        update.setSql("readed = readed + 1");
        Blog blog = blogMapper.selectById(blogID);
        int update1 = blogMapper.update(blog, update);
        return update1;

    }

}
