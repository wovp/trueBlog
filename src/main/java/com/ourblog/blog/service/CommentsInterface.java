package com.ourblog.blog.service;

import com.ourblog.blog.pojo.Comments;

import java.util.List;

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
    int addComment(String comment, int uid, int aid);

    // 评论id
    int deleteComment(int id);

    // 展示评论列表, 把所有符合aid 的评论都查出来
    List<Comments> showCommentsList(int aid);

    // 点赞评论
    int likeComment(int aid);

    // 取消点赞评论
    int cancelLikeComment(int aid);
}
