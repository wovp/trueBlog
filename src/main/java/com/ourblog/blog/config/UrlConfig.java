package com.ourblog.blog.config;

/**
 * ClassName: UrlConfig
 * Package: com.ourblog.blog.config
 * Description:
 * Author: my
 * Creat: 2023/8/21 10:23
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.CodeSource;

/**
 * @author:yst
 */
@Configuration
public class UrlConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:F:\\Code\\CodeSource\\JavaCode\\shixunBlog\\src\\main\\resources\\static");
    }
}

