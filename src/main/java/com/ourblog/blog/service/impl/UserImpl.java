package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.pojo.User;
import com.ourblog.blog.pojo.UserPub;
import com.ourblog.blog.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public  class UserImpl implements UserInterface {
    @Autowired(required = false)
    private JdbcTemplate jdbc;

    @Override
    // 返回一个用户的对象，里面包含用户的个人信息展示,！！！密码处理问题待定
    //TODO:置1为注销
    public Result getUserInfo(String username) {
        Result result = new Result();
        User user1 = null;
        try {
            System.out.println("2222222222222222222：" + username);
            user1 = jdbc.queryForObject("select userid from user where username=?", new BeanPropertyRowMapper<>(User.class), username);
            System.out.println("11111111111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(user1);
        }
        System.out.println("3333333333333333");
        System.out.println(user1);
        System.out.println("44444444444444444444");
        try {
            if (user1 == null) {
                result.setCode("200");
                result.setResult("用户id错误");
            } else {
                result.setCode("200");
                result.setResult(jdbc.query("select * from user where userid=?",
                        new BeanPropertyRowMapper<>(User.class), user1.getUserid()));
            }
            return result;
        } catch (DataAccessException e) {
            e.printStackTrace();
            result.setCode("201");
            result.setResult("查询失败");
            return result;
        }
    }

    @Override
    // 注册用户，返回 200 注册成功， 201 为失败,初始Ynlogout都置0
    public Result registerUser(User user) {
        Result result = new Result();
        User user1 = null;
        try {
            user1 = jdbc.queryForObject("select username from user where username=?",
                    new BeanPropertyRowMapper<>(User.class), user.getUsername());
        } catch (Exception e) {
        }

//        user1 = jdbc.queryForObject("select username from user where username=?",
//                new BeanPropertyRowMapper<>(User.class), user.getUsername());
        try {

            if (user1 == null) {
                jdbc.update("insert into user(avatar,birthday,phonenumber,age,password,nickname,mailbox, username,gender,YNlogout)VALUES (?,?,?,?,?,?,?,?,?,?);",
                        user.getAvatar(), user.getBirthday(), user.getPhonenumber(), user.getAge(), user.getPassword(), user.getNickname(),
                        user.getMailbox(), user.getUsername(), user.getGender(), user.getYNlogout());
                result.setCode("200");
                result.setResult("注册成功！");
                return result;
            } else {
                result.setCode("202");
                result.setResult("用户名已存在！");
                return result;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            result.setCode("201");
            result.setResult("注册失败");
            return result;
        }
    }

    @Override
    //根据用户名，获取该用户的粉丝数
    public Result getfans(String username) {
        Result result = new Result();
        Integer user = null;
        int user3 = 0;
        try {
            user = jdbc.queryForObject("select userid from user where username=?",
                    Integer.class, username);
        }catch (DataAccessException e){
            result.setCode("200");
            result.setResult("该用户不存在");
            return result;
        }
        try {
            try {
                user3 = jdbc.queryForObject("select count(care_user_id) value from user_to_user where userid = ?",
                        Integer.class, user);
                result.setCode("200");
                result.setResult(user3);
                return result;
            }catch (DataAccessException e){
                result.setCode("200");
                result.setResult(user3);
                System.out.println(user3);
                return result;
            }

        } catch (Exception e) {
            result.setCode("201");
            result.setResult("查找失败");
            return result;
        }


    }


    @Override
    //用户修改个人资料
    public Result updateUserInfo(User user) {
        Result result = new Result();
        try {
            jdbc.update("update ourblog.user set avatar=?,birthday=?,phonenumber=?,age=?,\n" +
                            "nickname=?,mailbox=?,gender=? where username = ? ",user.getAvatar(),user.getBirthday(),
                            user.getPhonenumber(),user.getAge(),user.getNickname(),user.getMailbox(),user.getGender(),
                            user.getUsername());
            //3.判断返回
            jdbc.update("update essay set author=? where userid in (select userid from\n" +
                    "    user where username=?)",user.getNickname(),user.getUsername());
            result.setCode("200");
            result.setResult("修改成功！");
            return result;
        } catch (DataAccessException e) {
            e.printStackTrace();
            result.setCode("201");
            result.setResult("修改失败");
            return result;
        }
    }

    @Override
    public String forgetpassword() {
        return null;
    }


    //忘记密码后通过电话号码和账号重置密码
    public Result forgetpass(User user) {
        Result result = new Result();
        String userid = null;
        try {
            userid = jdbc.queryForObject("select userid from user where username = ? and phonenumber = ?",
                    String.class,user.getUsername(),user.getPhonenumber());
        }catch (DataAccessException e){
        }
        try {
            if (userid == null){
                result.setCode("202");
                result.setResult("手机号与账号不匹配");
                return result;
            }else {
                jdbc.update("update user set password=? where user.userid=?",user.getPassword(),userid);
                result.setCode("200");
                result.setResult("修改成功！");
                return result;
            }

        }catch (DataAccessException e){

        }
        result.setCode("201");
        result.setResult("修改失败");
        return result;
    }
@Override
    //查找用户发布过的文章
    public Result getpublishblog(String userid) {
        Result result = new Result();

        try {
            List<UserPub> essay= jdbc.query("select essay.essayid, title, viewnumber, likenumber, colletnumber, briefintro,pictureurl,classify from essay\n" +
                            "left join picture on essay.essayid=picture.essayid left join classfy_to_essay cte on essay.essayid = cte.essayid left join classify c on cte.classfy_id = c.id\n" +
                            "where essay.userid = ? and essay.isDelete = 0 ",
                    new BeanPropertyRowMapper<>(UserPub.class),userid);
            result.setCode("200");
            result.setResult(essay);
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("查找失败");
            return result;
        }
    }
    @Override
    //获取收藏数量
    public Result getpublishs(String userid) {
        Result result = new Result();
        Integer essay = null;
        try {
            essay = jdbc.queryForObject("select count(essayid) value from essay where userid = ?",
                    Integer.class, userid);
            result.setCode("200");
            result.setResult(essay);
            return result;
        } catch (Exception e) {
            result.setCode("201");
            result.setResult("查找失败");
            return result;
        }

    }

    @Override
    public List<User> getlike(String userID) {
        return null;
    }

    @Override
    //查找用户发布过的文章
    public Result getcollectblog(String username) {
        Result result = new Result();

        try {
            try {
                List<UserPub> essay= jdbc.query("select essay.essayid, title, viewnumber, likenumber, colletnumber, briefintro,pictureurl,classify from user left join\n" +
                                "user_to_eassy_likes_collect_read co on user.userid = co.user_id left join essay on eassy_id= essayid\n" +
                                "left join picture on essay.essayid=picture.essayid left join classfy_to_essay cte on essay.essayid = cte.essayid\n" +
                                "left join classify c on cte.classfy_id = c.id where user.username = ? and essay.isDelete = 0 and YNcollect = 1 ",
                        new BeanPropertyRowMapper<>(UserPub.class),username);
                if(CollectionUtils.isEmpty(essay)){
                    result.setCode("202");
                    result.setResult("您还没发过文章哦！");
                    return result;
                }
                result.setCode("200");
                result.setResult(essay);
                return result;
            }catch (DataAccessException e){
                result.setCode("202");
                result.setResult("您还没发过文章哦！");
                return result;
            }
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("查找失败");
            return result;
        }
    }

    public User login(String username, String password){
        String sql = "select * from user where username = ? and password = ?";
        try {
            User user = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

   /* @Override
    public List<Blog> likelog(String userID) {
        return null;
    }*/






    /*@Override
    public Result getlike(oneunbook) {
        Result result = new Result();
        try {
            jdbc.queryForMap("")
        }
    }*/
}
