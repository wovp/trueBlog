package com.ourblog.blog.service;

import com.ourblog.blog.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * ClassName: Article
 * Package: com.ourbolg.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/18 10:33
 */

// 首页 和 分类页面 和 博客详情页（不包含评论） 和 博客发布页 的接口
public interface EssayInterface {
    // 根据传入的分类搜索博客列表
    public List<Map<String, Object>> getEssayListByCategory();

    // 根据关键词搜索博客标题
    public List<Map<String, Object>> getEssayListByKeyInTitle(String keyWord);

    // 获取所有博客列表
    public List<Map<String, Object>> getEssayList();


    // 根据博客ID获取博客详情内容,应该是博客的所有内容，也就是一个博客对象
    public List<Map<String, Object>> getEssayDetail(String EssayID);


    // 根据点赞量排序获取前五个点赞量最高的博客
    public List<Map<String, Object>> getEssayListByLikes();

    // 发布博客, 成功返回1， 失败返回0
    int publishEssay(String author_id, String author, String articleTitle, String articleContent, String classfy, String publishDate, String articleSummary, String pic_url);
    // 发布博客的封面
    int publishEssayPicture();
    // 删除博客, 成功返回1， 失败返回0
    public int deleteEssay(String EssayID, String UserID);

    // 博客被点赞了，成功返回1， 失败返回0
    public int addEssayLikes(String EssayID);

    // 博客被取消点赞了，成功返回1， 失败返回0
    public int cancelEssayLikes(String EssayID);

    // 博客被收藏了，成功返回1， 失败返回0
    public int addEssayCollects(String EssayID);

    // 博客被取消收藏了，成功返回1， 失败返回0
    public int cancelEssayCollects(String EssayID);

    // 博客被阅读了, 增加阅读量
    public int addEssayReaded(String EssayID);

    // 返回发布博客的个人信息，用于博客详情页面使用
    User getEssayAuthor(String authorID);




}
