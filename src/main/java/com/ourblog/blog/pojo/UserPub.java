package com.ourblog.blog.pojo;

import lombok.Data;

@Data
public class UserPub {
    private Integer essayid;
    private String title;
    private Integer viewnumber;
    private Integer likenumber;
    private Integer colletnumber;
    private String briefintro;
    private String pictureurl;
    private String classify;
}
