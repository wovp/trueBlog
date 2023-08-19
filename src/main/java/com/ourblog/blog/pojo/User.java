package com.ourblog.blog.pojo;

import lombok.Data;

@Data
public class User {

  private long id;
  private String username;
  private String nickname;
  private String phone;
  private String email;
  private String password;
  private java.sql.Timestamp registrationDate;
  private java.sql.Timestamp birthday;
  private java.sql.Timestamp lastLogin;
  private long isDelete;
  private String avatar;


}
