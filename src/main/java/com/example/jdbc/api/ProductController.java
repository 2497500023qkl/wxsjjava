package com.example.jdbc.api;

import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.mapper.product;
import com.example.jdbc.user.commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductController {
    @Autowired
    product userMapper;
    @RequestMapping("/hello")
    public List<commodity> say() {
        commodity product = new commodity();
        List<commodity> userList = userMapper.getAll();
        return userList;
    }
    @RequestMapping("/create1")
    public String cre1(HttpServletRequest request){
        commodity cate =new commodity();
        if(request.getParameter("sort")==null||request.getParameter("sort").equals("")){
            cate.setSort(10);
        }else{
            cate.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        if(request.getParameter("status")==null||request.getParameter("status").equals("")){
            cate.setStatus('1');
        }else{
            cate.setStatus(request.getParameter("status").charAt(0));
        }
        if(request.getParameter("name")==null||request.getParameter("name").equals("")){
            return "用户名不能为空";
        }else{
            cate.setName(request.getParameter("name"));
        }
        cate.setCreated_at(new Date());
        cate.setUpdated_at(new Date());
        if(request.getParameter("content")==null||request.getParameter("content").equals("")){
            cate.setContent("无");
        }else{
            cate.setContent(request.getParameter("content"));
        }
        if(request.getParameter("sale_num")==null||request.getParameter("sale_num").equals("")){
            cate.setSale_num(0);
        }else{
            cate.setSale_num(Integer.parseInt(request.getParameter("sale_num")));
        }
        if(request.getParameter("category_id")==null||request.getParameter("category_id").equals("")){
            cate.setCategory_id(1);
        }else{
            cate.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
        }
        if(cate.getStatus()!='1'||cate.getStatus()!='2'||cate.getStatus()!='3'){
            cate.setStatus('1');
        }
        try{
            userMapper.increase2(cate);
            return "[{\"name\":\"成功\"}]";
        }catch (Error e){
            return "[{\"name\":\"服务器错误\"}]";
        }
    }
    @RequestMapping("/select")
    public String select(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.getOne2(c);
        return "成功";
    }
    @RequestMapping("/change")
    public String change(HttpServletRequest request){
        commodity cate =new commodity();
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
            cate=userMapper.getOne2(c);
        }else{
            return "无id";
        }
        if(cate.equals("")){
            return "失败";
        }
        if(request.getParameter("sort")==null||request.getParameter("sort").equals("")){
        }else{
            cate.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        if(request.getParameter("status")==null||request.getParameter("status").equals("")){
        }else{
            cate.setStatus(request.getParameter("status").charAt(0));
        }
        if(request.getParameter("name")==null||request.getParameter("name").equals("")){
        }else{
            cate.setName(request.getParameter("name"));
        }
        if(request.getParameter("content")==null||request.getParameter("content").equals("")){
        }else{
            cate.setContent(request.getParameter("content"));
        }
        if(request.getParameter("sale_num")==null||request.getParameter("sale_num").equals("")){
        }else{
            cate.setSale_num(Integer.parseInt(request.getParameter("sale_num")));
        }
        cate.setUpdated_at(new Date());
        if(cate.getStatus()!='1'||cate.getStatus()!='2'||cate.getStatus()!='3'){
            cate.setStatus('1');
        }
        userMapper.change(cate);
        return "成功";
    }

    @RequestMapping("/delect1")
    public String dele1(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.delete1(c);
        return "成功";
    }
    @RequestMapping("/hide1")
    public String hide1(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.hide1(c);
        return "成功";
    }
    @RequestMapping("/display1")
    public String display1(HttpServletRequest request){
        long c;
        if(request.getParameter("id")!=null){
            c=Long.parseLong(request.getParameter("id"));
        }else{
            return "无id";
        }
        userMapper.display1(c);
        return "成功";
    }
}
