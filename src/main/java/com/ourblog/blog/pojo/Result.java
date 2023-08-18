package com.ourblog.blog.pojo;

import lombok.Data;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * ClassName: Result
 * Package: com.ourblog.blog.pojo
 * Description:
 * Author: my
 * Creat: 2023/8/18 16:36
 */
@Data
public class Result {
    String code;
    Object result;
}
