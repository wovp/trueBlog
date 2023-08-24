package com.ourblog.blog.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CommentsInterface
 * Package: com.ourblog.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/19 15:38
 * @author 11
 */

// 博客详情页的评论 （重点是评论） 接口
public interface CommentsInterface {

    // 发布评论, uid 是 发布评论的人的 id ， aid 是被评论博客的id
    int addComment(String comment, String uid, String aid);

    // 评论id
    int deleteComment(int id);

    // 展示评论列表, 把所有符合aid 的评论都查出来
    List<Map<String, Object>> showCommentsList(String aid);

    // 点赞评论
    int likeComment(String uid, String cid);

    // 取消点赞评论
    int cancelLikeComment(int aid);
}
