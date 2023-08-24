package com.ourblog.blog.config;

/**
 * ClassName: UrlConfig
 * Package: com.ourblog.blog.config
 * Description:
 * Author: my
 * Creat: 2023/8/21 10:23
 */

import com.ourblog.blog.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:yst
 */
@Configuration
public class UrlConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:F:/Code/CodeSource/JavaCode/pictureRoot/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();
        // patterns.add("/api/blog/**");
        patterns.add("/api/user/login");
        patterns.add("/static/**");
        registry.addInterceptor(authenticationInterceptor())
//                表示拦截所有请求
                .addPathPatterns("/api")
                .excludePathPatterns(patterns);
//                表示取消对特定路径的拦截
//                .excludePathPatterns("/api/user/login")
//                .excludePathPatterns("/api/blog/")
//                这里一定不要写成/**/*.js的形式，spring boot无法识别
//                取消对static目录下静态资源的拦截
//                .excludePathPatterns("/static/**");
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}

