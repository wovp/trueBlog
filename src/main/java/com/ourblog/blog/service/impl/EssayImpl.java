package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Essay;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.EssayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.awt.image.TileObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public int publishEssay(String author_id, String author, String articleTitle, String articleContent,  String publishDate, String articleSummary, String classfy) {
        // 先插入文章数据库
        String sql_essay = "insert into essay (userid, author, title, content, briefintro, viewnumber, likenumber, colletnumber) value (?, ? ,? ,? ,? ,0, 0 ,0 )";
        KeyHolder keyHolder_essay = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 指定主键
                PreparedStatement preparedStatement = connection.prepareStatement(sql_essay, new String[]{"essayid"});
                preparedStatement.setInt(1, Integer.parseInt(author_id));
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, articleTitle);
                preparedStatement.setString(4, articleContent);
                preparedStatement.setString(5, articleSummary);
                return preparedStatement;
            }
        }, keyHolder_essay);
        // 得到插入文章的主键ID
        int essay_id = Objects.requireNonNull(keyHolder_essay.getKey()).intValue();

        // 得到插入文章的分类id
        String sql_classify = "select id from classify where classfy = ?";
        List<Map<String, Object>> classify_map = jdbcTemplate.queryForList(sql_classify, classfy);
        String classify_id = String.valueOf(classify_map.get(0));

        // 通过文章id 和 分类id 插入文章和分类表内
        String sql_es_cla = "insert into classfy_to_essay (classfy_id, essayid) value(?, ?)";
        int update = jdbcTemplate.update(sql_es_cla, classify_id, essay_id);

        return update;


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
