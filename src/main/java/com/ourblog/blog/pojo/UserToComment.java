package com.ourblog.blog.pojo;


public class UserToComment {

  private long userId;
  private long commentId;
  private long yNlike;


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


  public long getYNlike() {
    return yNlike;
  }

  public void setYNlike(long yNlike) {
    this.yNlike = yNlike;
  }

}
