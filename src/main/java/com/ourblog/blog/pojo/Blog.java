package com.ourblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

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



}
