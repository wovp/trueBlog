package com.ourblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 11
 */
@Data
public class Blog {

  private int id;
  private int author_id;
  private int readed;
  private String author;
  @TableField(value = "articleTitle")
  private String articleTitle;
  @TableField(value = "articleContent")
  private String articleContent;
  @TableField(value = "articleCategories")
  private String articleCategories;
  @TableField(value = "publishDate")
  private String publishDate;
  @TableField(value = "articleSummary")
  private String articleSummary;

  private long likes;
  private long collects;

  public Blog(String author_id, String author, String articleTitle, String articleContent, String articleCategories, String publishDate, String articleSummary) {
    this.author_id = Integer.parseInt(author_id);
    this.readed = 0;
    this.collects = 0;
    this.likes = 0;
    this.author = author;
    this.articleTitle = articleTitle;
    this.articleContent = articleContent;
    this.articleCategories = articleCategories;
    this.publishDate = publishDate;
    this.articleSummary = articleSummary;
  }
}
