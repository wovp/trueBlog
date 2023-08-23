package com.ourblog.blog.service.impl;

import com.ourblog.blog.service.CommentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CommentsImpl
 * Package: com.ourblog.blog.service.impl
 * Description:
 * Author: my
 * Creat: 2023/8/22 20:33
 */
@Repository
public class CommentsImpl implements CommentsInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int addComment(String comment, int uid, int aid) {
        return 0;
    }

    @Override
    public int deleteComment(int id) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> showCommentsList(String aid) {
        String sql = "select * from comments where eassy_id = ?";
        String sql_re = "select read_num from user_to_eassy_likes_collect_read where eassy_id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, aid);
        return maps;
    }

    @Override
    public int likeComment(int aid) {
        return 0;
    }

    @Override
    public int cancelLikeComment(int aid) {
        return 0;
    }
}
