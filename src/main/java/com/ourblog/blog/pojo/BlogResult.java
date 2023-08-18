package com.ourblog.blog.pojo;

import lombok.Data;

/**
 * ClassName: BlogResult
 * Package: com.ourblog.blog.pojo
 * Description:
 * Author: my
 * Creat: 2023/8/18 15:51
 * @author 11
 */
@Data
public class BlogResult {
    String author_name;
    int id;
    String published_at;
    String title;
    public BlogResult(Blog blog){
        this.title = blog.getArticleTitle();
        this.author_name = blog.getAuthor();

    }
}
