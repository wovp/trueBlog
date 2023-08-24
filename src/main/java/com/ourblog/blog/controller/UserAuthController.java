package com.ourblog.blog.controller;

/**
 * ClassName: UserAuthController
 * Package: com.ourblog.blog.controller
 * Description:
 * Author: my
 * Creat: 2023/8/23 15:22
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xkcoding.justauth.AuthRequestFactory;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 11
 */
@RestController
@RequestMapping("/Auth")
@CrossOrigin("*")
@Slf4j
public class UserAuthController {
    @Autowired
    private AuthRequestFactory factory;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/login/{type}")
    public String toLogin(@PathVariable String type, HttpServletResponse response) throws IOException {

        AuthRequest authRequest = factory.get(type);
//        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
        return authRequest.authorize(AuthStateUtils.createState());
    }
    @GetMapping("/{type}/callback")
    public void loginBack(@PathVariable String type, AuthCallback callback , HttpServletRequest request, HttpServletResponse httpServletResponse) {
        System.out.println(type);
        AuthRequest authRequest = factory.get(type);
        // log.info(JSON.toJSONString(callback));

        AuthResponse response = authRequest.login(callback);
        String data = JSON.toJSONString(response.getData());
        String token = JSON.toJSONString(response.getMsg());
        JSONObject jsonObject = JSON.parseObject(data);
        // 以uuid 做账号， 密码就是123456默认密码， 若此账号存在，就刷新token， 若不存在，就注册， 昵称就是昵称， 头像就是头像，并刷新token
        String username = jsonObject.getString("username");
        String avater = jsonObject.getString("avatar");
        String nickname = jsonObject.getString("nickname");
        System.out.println("username");
        System.out.println(username);
        String myToken = jsonObject.getString("token");
        JSONObject myTokenjsonObject = JSON.parseObject(myToken);
        System.out.println("myToken");
        System.out.println(myTokenjsonObject.getString("accessToken"));
        String accessToken = myTokenjsonObject.getString("accessToken");
        String sql_quertExist = "select userid from user where username = ?";
        String sql_up = "update user set token = ? where userid = ?";
        String sql_in = "insert into user (avatar, birthday, phonenumber, age, password, nickname, YNlogout, mailbox, username, gender, token) VALUE (?, NOW(), 123, 0, 123456, ?, 0, 0,?, 0, ?)";

        try {
            String s = jdbcTemplate.queryForObject(sql_quertExist, String.class, username);
            // 账号存在, 就刷新token
            jdbcTemplate.update(sql_up, accessToken,s);


        } catch (DataAccessException e) {
            // 账号不存在，就插入
            jdbcTemplate.update(sql_in, avater, nickname, username, accessToken);
            e.printStackTrace();
        }


        try {
            httpServletResponse.sendRedirect("http://localhost:8080/pages/token/token?token=" + accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
