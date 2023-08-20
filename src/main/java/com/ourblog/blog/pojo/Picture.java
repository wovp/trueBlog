package com.ourblog.blog.pojo;


public class Picture {

  private long pictureid;
  private long essayid;
  private String pictureurl;


  public long getPictureid() {
    return pictureid;
  }

  public void setPictureid(long pictureid) {
    this.pictureid = pictureid;
  }


  public long getEssayid() {
    return essayid;
  }

  public void setEssayid(long essayid) {
    this.essayid = essayid;
  }


  public String getPictureurl() {
    return pictureurl;
  }

  public void setPictureurl(String pictureurl) {
    this.pictureurl = pictureurl;
  }

}
