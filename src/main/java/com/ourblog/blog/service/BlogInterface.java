package com.ourblog.blog.service;

/**
 * ClassName: Article
 * Package: com.ourbolg.blog.service
 * Description:
 * Author: my
 * Creat: 2023/8/18 10:33
 */
public interface BlogInterface {
    /**
     * category 可选：
     *  空
     *  分类列表
     *  用户的点赞过的文章
     *  用户的收藏的文章
     * category 为空 就查询所有类型的文章
     * category 不为空 就查询特定类型的文章
     *
     * */
    // public List<Article> getBlogByCategoryList(String category);


}
