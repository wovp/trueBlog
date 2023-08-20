package com.ourblog.blog.pojo;


public class Comments {

  private long id;
  private long eassyId;
  private java.sql.Timestamp date;
  private String context;
  private long likes;
  private String yNdelete;
  private long userid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getEassyId() {
    return eassyId;
  }

  public void setEassyId(long eassyId) {
    this.eassyId = eassyId;
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


  public long getLikes() {
    return likes;
  }

  public void setLikes(long likes) {
    this.likes = likes;
  }


  public String getYNdelete() {
    return yNdelete;
  }

  public void setYNdelete(String yNdelete) {
    this.yNdelete = yNdelete;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

}
