package com.ourblog.blog.service.impl;

import com.ourblog.blog.pojo.*;
import com.ourblog.blog.service.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Adminlmpl implements AdminInterface {
    @Autowired(required = false)
    private JdbcTemplate jdbc;

    //管理员删除用户
    public Result deleteUser(User user){
    Result result = new Result();
    try {
        System.out.println(user);
        jdbc.update("update user set YNlogout=1 where userid=?",user.getUserid());
        result.setCode("200");
        result.setResult("删除成功！");
        return result;
    }catch (DataAccessException e){
        result.setCode("201");
        result.setResult("删除失败");
        return result;
    }
    }
    public Result deleteUser(Essay essay){
        Result result = new Result();
        try {
            System.out.println(essay);
            jdbc.update("update essay set isDelete=1 where essayid=?",essay.getEssayid());
            result.setCode("200");
            result.setResult("删除成功！");
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("删除失败");
            return result;
        }
    }
    public Result ynadmin(String username,String password){
        Result result = new Result();
        Integer admin = 0;
        try {
            admin = jdbc.queryForObject("select id from admin where username = ? and password =?"
            ,Integer.class,username,password);
            result.setCode("200");
            result.setResult("管理员登录成功");
            return result;
        }catch (DataAccessException e){
            result.setCode("202");
            result.setResult("管理员账号或密码错误！");
            return result;
        }
    }

    public Result addclass(String classify){
        Result result = new Result();
        try {
            jdbc.update("insert into classify (classify) value (?)",classify);
            result.setCode("200");
            result.setResult("插入成功");
            return result;
        }catch (DataAccessException e){
            e.printStackTrace();
            result.setCode("201");
            result.setResult("插入失败");
            return result;
        }



    }

    public Result hotessay(){
        Result result = new Result();
        try {
            List<Hotessay> hotessay=jdbc.query("select essayid,title,count(YNcollect) as collectnum,count(likenumber) as likenum, sum(read_num)\n" +
                    " as readnum from essay left join user_to_eassy_likes_collect_read co on essay.essayid = co.eassy_id\n" +
                    "  group by essayid order by likenum desc limit 6",new BeanPropertyRowMapper<>(Hotessay.class));
            result.setCode("200");
            result.setResult(hotessay);
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("查找失败");
            return result;
        }
    }

    public Result deleteclass(String classify){
        Result result = new Result();
        try {
            jdbc.update("update classfy_to_essay set classfy_id = 12 where classfy_id in\n" +
                    " (select id from classify where classify = ?)",classify);
            jdbc.update("delete from classify where classify = ?",classify);
            result.setCode("200");
            result.setResult("删除成功！");
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("删除失败！");
            return result;
        }
    }
    //public Result addclass(String class)
    /*
    public Result classcount(){
        Result result = new Result();
        try {
            List<ClassCount> clc=jdbc.query("select classify,sum(read_num) as value from classify " +
                           "left join classfy_to_essay ce on classify.id = ce.classfy_id inner join " +
                    "user_to_eassy_likes_collect_read on essayid= eassy_id group by classify",
                    new BeanPropertyRowMapper<>(ClassCount.class));
            if (CollectionUtils.isEmpty(clc)){
                result.setCode("202");
                result.setResult("您的网站尚无足迹");
                return result;
            }
            result.setCode("200");
            result.setResult(clc);
            return result;
        }catch (DataAccessException e){
            result.setCode("201");
            result.setResult("查找错误");
            return result;
        }
    }*/
    //获取总用户数
    public Result countuser(){
        Result result = new Result();
        Integer uc = 0;
        try {
            uc=jdbc.queryForObject("select count(*) as value from user where YNlogout = '0'",Integer.class);
            result.setResult(uc);
            result.setCode("200");
            return result;
        }catch (DataAccessException e){
            result.setResult("查找失败");
            result.setCode("201");
            return result;
        }

    }

    /*//获取总阅读量
    public Result countread(){
        Result result = new Result();
        Integer rc = 0;
        try {
            rc=jdbc.queryForObject("select sum(read_num) from user_to_eassy_likes_collect_read left join essay\n" +
                    " on eassy_id = essayid where isDelete = '0';",Integer.class);
            result.setResult(rc);
            result.setCode("200");
            return result;
        }catch (DataAccessException e){
            result.setResult("查找失败");
            result.setCode("201");
            return result;
        }

    }*/
}
