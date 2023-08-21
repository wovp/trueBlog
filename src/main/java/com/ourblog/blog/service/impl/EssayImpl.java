package com.ourblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.EssayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public abstract class EssayImpl implements EssayInterface {
    @Autowired(required = false)
    com.ourblog.blog.mapper.EssayMapper EssayMapper;

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Essay> getEssayListByCategory(String category) {

        QueryWrapper<Essay> query = new QueryWrapper<>();
        query.eq("articleCategories", category);
        List<Essay> Essays = EssayMapper.selectList(query);

        return Essays;
    }

    @Override
    public List<Essay> getEssayListByKeyInTitle(String keyWord) {
        QueryWrapper<Essay> query = new QueryWrapper<>();
        query.like("articleTitle", keyWord);
        List<Essay> Essays = EssayMapper.selectList(query);

        return Essays;
    }

    @Override
    public List<Essay> getEssayList() {
        QueryWrapper<Essay> query = new QueryWrapper<>();
        query.select("id", "author", "articleTitle", "articleCategories", "publishDate", "articleSummary", "likes", "collects");
        List<Essay> Essays = EssayMapper.selectList(query);
        return Essays;
    }

    @Override
    public Essay getEssayDetail(String EssayID) {
        Essay Essay = EssayMapper.selectById(EssayID);
        return Essay;
    }

    @Override
    public List<Essay> getEssayListByLikes() {
        QueryWrapper<Essay> query = new QueryWrapper<>();
        query.orderByDesc("likes").last("limit 5");
        List<Essay> Essays = EssayMapper.selectList(query);
        return Essays;
    }

    /*@Override
    public int publishEssay(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary) {
        Essay Essay = new Essay(author_id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary);
        int insert = EssayMapper.insert(Essay);
        return insert;
    }*/

    @Override
    public int deleteEssay(String EssayID) {
        QueryWrapper<Essay> query = new QueryWrapper<>();
        query.eq("id", EssayID);
        int delete = EssayMapper.delete(query);
        return delete;
    }

    @Override
    public int addEssayLikes(String EssayID) {
        UpdateWrapper<Essay> update = new UpdateWrapper<>();
        update.setSql("likes = likes + 1");
        Essay Essay = EssayMapper.selectById(EssayID);
        int update1 = EssayMapper.update(Essay, update);
        return update1;
    }

    @Override
    public int cancelEssayLikes(String EssayID) {
        UpdateWrapper<Essay> update = new UpdateWrapper<>();
        update.setSql("likes = likes - 1");
        Essay Essay = EssayMapper.selectById(EssayID);

        // 当点赞数为0 不能取消点赞
        if(Essay.getLikes() == 0){
            return 0;
        }
        int update1 = EssayMapper.update(Essay, update);
        return update1;
    }

    @Override
    public int addEssayCollects(String EssayID) {
        UpdateWrapper<Essay> update = new UpdateWrapper<>();
        update.setSql("collects = collects + 1");
        Essay Essay = EssayMapper.selectById(EssayID);
        int update1 = EssayMapper.update(Essay, update);
        return update1;
    }

    @Override
    public int cancelEssayCollects(String EssayID) {
        UpdateWrapper<Essay> update = new UpdateWrapper<>();
        update.setSql("collects = collects - 1");
        Essay Essay = EssayMapper.selectById(EssayID);

        // 当收藏数为0
        if(Essay.getLikes() == 0){
            return 0;
        }
        int update1 = EssayMapper.update(Essay, update);
        return update1;
    }

    @Override
    public int addEssayReaded(String EssayID) {
        UpdateWrapper<Essay> update = new UpdateWrapper<>();
        update.setSql("readed = readed + 1");
        Essay Essay = EssayMapper.selectById(EssayID);
        int update1 = EssayMapper.update(Essay, update);
        return update1;

    }

    @Override
    public User getEssayAuthor(String authorID) {
        return null;
    }

}
