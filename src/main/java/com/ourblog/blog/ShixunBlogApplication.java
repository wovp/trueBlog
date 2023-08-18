package com.ourblog.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ourblog.blog.mapper")
public class ShixunBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShixunBlogApplication.class, args);
    }

}
