package com.ourblog.blog.pojo;


public class Reply {

  private long id;
  private long userId;
  private long commentId;
  private java.sql.Timestamp date;
  private String context;
  private long likenumber;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }


  public long getLikenumber() {
    return likenumber;
  }

  public void setLikenumber(long likenumber) {
    this.likenumber = likenumber;
  }

}
