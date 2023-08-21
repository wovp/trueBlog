package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.EssayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName: BlogImpl
 * Package: com.ourblog.blog.service.impl
 * Description:
 * Author: my
 * Creat: 2023/8/19 10:44
 */
@Repository
public class EssayImpl implements EssayInterface {
    @Autowired(required = false)
    com.ourblog.blog.mapper.EssayMapper EssayMapper;

    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> getEssayListByCategory(String category) {
        String sql = "select essay.essayid, classify, title, viewnumber, author, likenumber,colletnumber, briefintro from classify, classfy_to_essay, essay where classify.id = classfy_to_essay.classfy_id and classfy_to_essay.essayid = essay.essayid and classify.classify = ?";
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql, category);

        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayListByKeyInTitle(String keyWord) {
        String sql = "select essay.essayid ,classify, title, viewnumber, author, likenumber,colletnumber, briefintro from classify, classfy_to_essay, essay where classify.id = classfy_to_essay.classfy_id and classfy_to_essay.essayid = essay.essayid and essay.title like " + keyWord;
        System.out.println(sql);
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql);


        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayList() {
        String sql = "select essay.essayid ,classify, title, viewnumber, author, likenumber,colletnumber, briefintro from classify, classfy_to_essay, essay where classify.id = classfy_to_essay.classfy_id and classfy_to_essay.essayid = essay.essayid";
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql);
        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayDetail(String EssayID) {
        String sql = "select essay.essayid, author, content, likenumber, colletnumber from essay where essayid = ?";
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql, EssayID);
        return EssayList;
    }

    @Override
    public List<Essay> getEssayListByLikes() {



        return null;
    }

    @Override
    public int publishEssay(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary) {
        return 0;
    }

    @Override
    public int deleteEssay(String EssayID) {
        return 0;
    }

    @Override
    public int addEssayLikes(String EssayID) {
        return 0;
    }

    @Override
    public int cancelEssayLikes(String EssayID) {
        return 0;
    }

    @Override
    public int addEssayCollects(String EssayID) {
        return 0;
    }

    @Override
    public int cancelEssayCollects(String EssayID) {
        return 0;
    }

    @Override
    public int addEssayReaded(String EssayID) {
        return 0;
    }

    @Override
    public User getEssayAuthor(String authorID) {
        return null;
    }


}
