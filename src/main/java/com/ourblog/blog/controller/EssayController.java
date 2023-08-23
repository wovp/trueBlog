package com.ourblog.blog.controller;

import com.ourblog.blog.pojo.Result;
import com.ourblog.blog.service.impl.EssayImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * ClassName: BlogController
 * Package: com.ourbolg.blog.controller
 * Description:
 * Author: my
 * Creat: 2023/8/18 14:42
 * @author 11
 */
@RestController
@CrossOrigin(origins = "*")
@Api(tags = "首页 博客详情页 博客发布的模块 还有个人中心对博客的操作模块")
public class EssayController {

    @Autowired
    EssayImpl essayImpl;
    @ApiOperation(value = "查询所有博客列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogList")
    public Result getEssayList(){
        Result result = new Result();
        result.setResult(essayImpl.getEssayList());
        result.setCode("200");
        return result;
    }
    @ApiOperation(value = "通过分类查询博客列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/form",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getEssayListByCategory")
    public Result getEssayListByCategory(String classify){
        Result result = new Result();
        result.setResult(essayImpl.getEssayListByCategory());
        result.setCode("200");
        return result;
    }


    @ApiOperation(value = "根据关键词查询博客题目",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/form",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogByKeyword")
    public Result getBlogByKeyword(String keyword){
        Result result = new Result();
        keyword = "'%" + keyword + "%'";
        result.setResult(essayImpl.getEssayListByKeyInTitle(keyword));
        result.setCode("200");
        return result;
    }

    @ApiOperation(value = "根据博客ID查询博客详情",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/form",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogDetail")
    public Result getEssayDetail(String id){
        Result result = new Result();
        result.setResult(essayImpl.getEssayDetail(id));
        result.setCode("200");
        return result;
    }

    @ApiOperation(value = "查询博客的阅读量",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/form",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogDetailRead")
    public Result getEssayDetailRead(String id){
        Result result = new Result();
        result.setResult(essayImpl.getEssayDetailReadNum(id));
        result.setCode("200");
        return result;
    }


    @ApiOperation(value = "添加博客",
            protocols = "http",
            httpMethod = "POST",
            consumes="application/json",
            response=Integer.class,
            notes = "code:200 表示成功"
    )
    @PostMapping("/api/blog/addBlog")
    public Result addEssay(@RequestBody Map<String,Object> map){
        Result result = new Result();
        String author_id = (String) map.get("author_id");
        String author = (String) map.get("author");
        String articleTitle = (String) map.get("articleTitle");
        String articleContent = (String) map.get("articleContent");
        String articleCategories = (String) map.get("articleCategories");
        String publishDate = (String) map.get("publishDate");
        String articleSummary = (String) map.get("articleSummary");
        String article_url = (String) map.get("article_url");
        String article_pic = (String) map.get("article_pic");
        System.out.println(article_pic);
        System.out.println("进入addContorller");

        int i = essayImpl.publishEssay(author_id, author, articleTitle, articleContent, articleCategories, publishDate, articleSummary, article_pic);
        if(i == 1) {
            result.setCode("200");
        }
        else{
            result.setCode("400");
        }
        return result;
    }

    @ApiOperation(value = "上传博客的封面",
            protocols = "http",
            httpMethod = "Post",
            consumes="application/json",
            response=Result.class,
            notes = "result:返回图片地址， code : 200 表示成功"
    )
    @PostMapping(value = "/api/blog/addBlogPic")
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }

        String fileName = file.getOriginalFilename();  // 文件名
        System.out.println(fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "F:/Code/CodeSource/JavaCode/shixunBlog/src/main/resources/static/"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String getFilePath = "/image/" + fileName;
        Result result = new Result();
        result.setCode("200");
        result.setResult(getFilePath);
        System.out.println(result.getResult());
        return result;
    }

    @ApiOperation(value = "根据点赞量返回博客列表的前五个",
            protocols = "http",
            httpMethod = "GET",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getBlogListLikes")
    public Result getBlogListLikes(){
        Result result = new Result();
        result.setResult(essayImpl.getEssayListByLikes());
        result.setCode("200");
        return result;
    }


    @ApiOperation(value = "返回所有博客的阅读量，阅读总量",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/getAllEssayAllRead")
    public Result getAllEssayAllRead(){
        Result result = new Result();
        result.setResult(essayImpl.getAllEssayAllRead());
        result.setCode("200");
        return result;
    }


    @ApiOperation(value = "删除自己发布的博客",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=Result.class,
            notes = "code:200  result: 1表示成功"
    )
    @PostMapping("/api/blog/deleteBlog")
    public Result deleteEssay(@RequestBody Map<String,Object> map){
        String uid = map.get("uid").toString();
        String eid = map.get("eid").toString();
        Result result = new Result();
        result.setResult(essayImpl.deleteEssay(eid, uid));
        result.setCode("200");
        return result;
    }

    @ApiOperation(value = "根据 不同分类查询博客数量",
            protocols = "http",
            httpMethod = "GET",
            response=Result.class,
            notes = "code:200表示成功 result 返回一个数组"
    )
    @GetMapping("/api/blog/getPublishCategoriesName")
    public Result getPublishCategoriesName(){
        Result result = new Result();
        result.setResult(essayImpl.getPublishCategoriesName());
        result.setCode("200");
        return result;
    }

    @ApiOperation(value = "查询所有博客列表",
            protocols = "http",
            httpMethod = "GET",
            consumes="application/json",
            response=List.class,
            notes = "code:200 表示成功"
    )
    @GetMapping("/api/blog/addBlogLikes")
    public Result addEssayLikes(String uid, String eid){
        Result result = new Result();
        result.setResult(essayImpl.addEssayLikes(eid, uid));
        result.setCode("200");
        return result;
    }


    @GetMapping("/api/blog/addBlogReaded")
    public Result addEssayReaded(String uid, String eid){
        Result result = new Result();
        result.setResult(essayImpl.addEssayReaded(uid, eid));
        result.setCode("200");
        return result;
    }

    @GetMapping("/api/blog/addBlogCollect")
    public Result addEssayCollect(String uid, String eid){
        Result result = new Result();
        result.setResult(essayImpl.addEssayCollect(uid, eid));
        result.setCode("200");
        return result;
    }



    @GetMapping("/api/blog/getEssayAllCount")
    public Result getEssayAllCount(){
        int essayAllCount = essayImpl.getEssayAllCount();
        Result result = new Result();
        result.setCode("200");
        result.setResult(essayAllCount);
        return result;
    }

    @GetMapping("/api/blog/getEssayCateAllCount")
    public Result getEssayCateAllCount(){
        Result result = new Result();
        result.setCode("200");
        result.setResult(essayImpl.getEssayCateAllCount());
        return result;
    }


    // --------------------------------
    // 下面是引入的 解析word文档的函数
    @ApiOperation(value = "上传word文档发布博客",
            protocols = "http",
            httpMethod = "GET",
            consumes="file",
            response=Result.class,
            notes = "code:200 表示成功"
    )
    @PostMapping("/api/blog/addBlogByWord")
    public Result addEssayByWord(@RequestParam(value = "file", required = true) MultipartFile file){
        Result result = new Result();
        result.setResult(essayImpl.getEssayList());
        result.setCode("200");
        return result;
    }




}
