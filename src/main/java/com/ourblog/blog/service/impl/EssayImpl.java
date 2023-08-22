package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.User;
import com.ourblog.blog.service.EssayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public List<Map<String, Object>> getEssayListByCategory() {
        // 查出所有分类的列表
        String sql = "select * from classify;";
        List<Map<String, Object>> ClassifyList = jdbcTemplate.queryForList(sql);

        // 根据每个分类的列表，查找对应的文章列表
        for (Map<String, Object> map: ClassifyList){
            Object id =  map.get("id");
            System.out.println("id = ");
            System.out.println(id);
            String id1 = id.toString();
            String sql01 = "select title, likenumber, colletnumber, briefintro, author, pictureurl from classfy_to_essay ,essay, picture where classfy_to_essay.essayid = essay.essayid and essay.essayid = picture.essayid and classfy_id = ?";
            List<Map<String, Object>> essay_list = jdbcTemplate.queryForList(sql01, id1);
            map.put("title", essay_list);
        }

        return ClassifyList;
    }

    @Override
    public List<Map<String, Object>> getEssayListByKeyInTitle(String keyWord) {
        String sql = "select essay.essayid ,classify, title, viewnumber, author, likenumber,colletnumber, briefintro ,pictureurl from classify, classfy_to_essay, essay, picture where classify.id = classfy_to_essay.classfy_id and classfy_to_essay.essayid = essay.essayid and picture.essayid = essay.essayid and essay.title like " + keyWord;
        System.out.println(sql);
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql);
        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayList() {
        String sql = "select essay.essayid ,classify, title, viewnumber, author, likenumber,colletnumber, briefintro, pictureurl from classify, classfy_to_essay, essay, picture where classify.id = classfy_to_essay.classfy_id and classfy_to_essay.essayid = essay.essayid and picture.essayid = essay.essayid";
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql);
        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayDetail(String EssayID) {
        String sql = "select essay.essayid, author, content, likenumber, colletnumber, pictureurl from essay, picture where essay.essayid = ? and essay.essayid  = picture.essayid";
        List<Map<String, Object>> EssayList = jdbcTemplate.queryForList(sql, EssayID);
        return EssayList;
    }

    @Override
    public List<Map<String, Object>> getEssayListByLikes() {
        String sql = "select pictureurl, e.essayid from picture left join essay e on e.essayid = picture.essayid order by e.likenumber DESC limit 5";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }


    @Override
    public int publishEssay(String author_id, String author, String articleTitle, String articleContent,  String classfy, String publishDate, String articleSummary, String picurl) {
        // 先插入文章数据库
        String sql_essay = "insert into essay (userid, author, title, content, briefintro, viewnumber, likenumber, colletnumber, isDelete) value (?, ? ,? ,? ,? ,0, 0 ,0, 0 )";
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
        String sql_classify = "select id from classify where classify = ?";
        Map<String, Object> classify_map = jdbcTemplate.queryForMap(sql_classify, classfy);
        String classify_id = String.valueOf(classify_map.get("id"));

        System.out.println(picurl);
        System.out.println("pic_url");
        // 通过文章id 和 图片url 插入图片数据库
        String sql_pic = "insert into picture (essayid, pictureurl) value(?, ?)";
        jdbcTemplate.update(sql_pic,essay_id, picurl);

        // 通过文章id 和 分类id 插入文章和分类表内
        String sql_es_cla = "insert into classfy_to_essay (classfy_id, essayid) value(?, ?)";
        int update = jdbcTemplate.update(sql_es_cla, classify_id, essay_id);

        return update;


    }

    @Override
    public int publishEssayPicture() {
        return 0;
    }

    @Override
    public int deleteEssay(String EssayID, String UserID) {
        // 删除 置1
        String sql_de = "update essay set isDelete = 1 where essayid = ?";
        String sql_qu = "select userid from essay where essayid = ?";
        Map<String, Object> useridMap = jdbcTemplate.queryForMap(sql_qu, EssayID);
        Object userid = useridMap.get("userid");
        String userid_st = userid.toString();
        int update = 0;
        if (userid_st.equals(UserID)){
            update = jdbcTemplate.update(sql_de, EssayID);
        }
        return update;
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
