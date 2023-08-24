package com.ourblog.blog.service.impl;

import com.ourblog.blog.service.CommentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public int addComment(String comment, String uid, String aid) {
        System.out.println(comment);
        String sql = "insert into comments (eassy_id, date, context, YNdelete, userid, likes) value (?, NOW(), ?, 0, ?, 0)";
        int update = jdbcTemplate.update(sql, aid, comment, uid);
        return update;
    }

    @Override
    public int deleteComment(int id) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> showCommentsList(String aid) {
        String sql = "select * from comments where eassy_id = ? and YNdelete = 0";
        String sql_re = "select read_num from user_to_eassy_likes_collect_read where eassy_id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, aid);
        return maps;
    }

    @Override
    public int likeComment(String uid, String cid) {
        String sql_exist = "select YNlike from user_to_comment where user_id = ? and comment_id = ?";
        String sql_addLike = "update user_to_comment set YNlike = 1 where user_id = ? and comment_id = ?";
        String sql_canLike = "update user_to_comment set YNlike = 0 where user_id = ? and comment_id = ?";
        String sql_insert = "insert into user_to_comment (user_id, comment_id, YNlike) VALUE (?, ?, 1)";
        int update = 0;
        try {
            String s = jdbcTemplate.queryForObject(sql_exist, String.class, uid, cid);
            if ("0".equals(s)){
                update = jdbcTemplate.update(sql_addLike, uid, cid);
            }
            else{
                jdbcTemplate.update(sql_canLike, uid, cid);
            }
        } catch (DataAccessException e) {
            update = jdbcTemplate.update(sql_insert, uid, cid);
        }
        return update;
    }

    @Override
    public int cancelLikeComment(int aid) {
        return 0;
    }
}
