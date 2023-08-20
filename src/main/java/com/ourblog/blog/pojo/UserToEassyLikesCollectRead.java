package com.ourblog.blog.pojo;


public class UserToEassyLikesCollectRead {

  private long userId;
  private long eassyId;
  private long yNlike;
  private long yNcollect;
  private long readNum;


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


  public long getYNlike() {
    return yNlike;
  }

  public void setYNlike(long yNlike) {
    this.yNlike = yNlike;
  }


  public long getYNcollect() {
    return yNcollect;
  }

  public void setYNcollect(long yNcollect) {
    this.yNcollect = yNcollect;
  }


  public long getReadNum() {
    return readNum;
  }

  public void setReadNum(long readNum) {
    this.readNum = readNum;
  }

}
