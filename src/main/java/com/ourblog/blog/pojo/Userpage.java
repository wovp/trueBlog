package com.ourblog.blog.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Userpage {
    private Integer essayid;
    private Integer userid;
    private Date birthday;
    private String age;
    private String avatar;
    private String title;
    private String nickname;
    private Integer viewnumber;
    private Integer likenumber;
    private Integer colletnumber;
    private String briefintro;
    private String pictureurl;
    private String classify;
    private Date data;

}
