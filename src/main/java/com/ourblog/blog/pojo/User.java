package com.ourblog.blog.pojo;


import lombok.Data;
import lombok.ToString;
@Data
public class User {

  public int getGender;
  private String avatar;
  private java.sql.Date birthday;
  private long phonenumber;
  private String age;
  private String password;
  private String nickname;
  private long yNlogout;
  private String mailbox;
  private long userid;
  private String username;


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public long getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(long phonenumber) {
    this.phonenumber = phonenumber;
  }


  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public long getYNlogout() {
    return yNlogout;
  }

  public void setYNlogout(long yNlogout) {
    this.yNlogout = yNlogout;
  }


  public String getMailbox() {
    return mailbox;
  }

  public void setMailbox(String mailbox) {
    this.mailbox = mailbox;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Object getGender() {
      return null;
  }

}
