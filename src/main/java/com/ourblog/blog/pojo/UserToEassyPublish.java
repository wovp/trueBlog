package com.ourblog.blog.pojo;


public class UserToEassyPublish {

  private long userId;
  private long eassyId;
  private long classifyId;
  private java.sql.Timestamp date;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getEassyId() {
    return eassyId;
  }

  public void setEassyId(long eassyId) {
    this.eassyId = eassyId;
  }


  public long getClassifyId() {
    return classifyId;
  }

  public void setClassifyId(long classifyId) {
    this.classifyId = classifyId;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }

}
