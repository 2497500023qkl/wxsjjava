package com.example.jdbc.api;

import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategoryController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/hello1")
    public List<category> say1() {
        category product = new category();
        List<category> userList = userMapper.getAll2();
        return userList;
    }
    @RequestMapping("/create")
    public String cre(HttpServletRequest request){
        category cate =new category();
        if(request.getParameter("sort").equals("")){
            cate.setSort(10);
        }else{
            cate.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        if(request.getParameter("status").equals("")){
            cate.setStatus('1');
        }else{
            cate.setStatus(request.getParameter("status").charAt(0));
        }
        if(request.getParameter("name").equals("")||request.getParameter("name").equals("")){
            return "[{\"name\":\"用户名不能为空\"}]";
        }else{
            cate.setName(request.getParameter("name"));
        }
        if(request.getParameter("property").equals("")){
            cate.setProperty("[{\"attr1\"：\"\",\"attr2\":\"\",\"attr3\":\"\"}]");
        }else{
            cate.setProperty(request.getParameter("property"));
        }
        cate.setCreated_at(new Date());
        cate.setUpdated_at(new Date());
        if(cate.getStatus()!='1'||cate.getStatus()!='2'||cate.getStatus()!='3'){
            cate.setStatus('1');
        }
        try{
            userMapper.increase1(cate);
            return "[{\"name\":\"成功\"}]";
        }catch (Error e){
            return "[{\"name\":\"服务器错误\"}]";
        }

    }
    @RequestMapping("/getone")
    public category one(HttpServletRequest request){
        category cate =new category();
        if(request.getParameter("id")!=null){
            long c=Long.parseLong(request.getParameter("id"));
            cate=userMapper.getOne(c);
        }
        return cate;
    }
    @RequestMapping("/update")
    public String up(HttpServletRequest request){
        category cate =new category();
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
            cate=userMapper.getOne(c);
        }else{
            return "[{\"name\":\"无id\"}]";
        }
        if(cate.equals("")){
            return "[{\"name\":\"失败\"}]";
        }
        if(request.getParameter("sort").equals("")){
        }else{
            cate.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        if(request.getParameter("name").equals("")){
        }else{
            cate.setName(request.getParameter("name"));
        }
        if(request.getParameter("property").equals("")){
        }else{
            cate.setProperty(request.getParameter("property"));
        }
        cate.setUpdated_at(new Date());
        userMapper.update(cate);
        return "[{\"name\":\"成功\"}]";
    }
    @RequestMapping("/delect")
    public String dele(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.delete(c);
        return "[{\"name\":\"成功\"}]";
    }
    @RequestMapping("/hide")
    public String hide(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.hide(c);
        return "[{\"name\":\"成功\"}]";
    }
    @RequestMapping("/display")
    public String display(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.display(c);
        return "[{\"name\":\"成功\"}]";
    }


}
