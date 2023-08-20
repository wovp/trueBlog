package com.ourblog.blog.pojo;

import lombok.Data;

@Data
public class Essay {

  private long essayid;
  private String title;
  private long viewnumber;
  private String author;
  private String content;
  private long likenumber;
  private long colletnumber;
  private String briefintro;
  private long userid;



}
