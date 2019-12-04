package com.example.jdbc.api;

import com.example.jdbc.mapper.Tag;
import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.mapper.product;
import com.example.jdbc.user.tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class TagController {
    @Autowired
    Tag userMapper;
    @RequestMapping("/hello11")
    public List<tag> say1(HttpServletRequest request) {
        tag product = new tag();
        if(request.getParameter("id")!=null){
            List<tag> userList = userMapper.getAll5(Integer.parseInt(request.getParameter("id")));
            return userList;
        }else{
            return null;
        }
    }
    @RequestMapping("/delete3")
    public String delete3(HttpServletRequest request){
        userMapper.delete3(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/hide3")
    public String hide3(HttpServletRequest request){
        userMapper.hide3(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/display3")
    public String display3(HttpServletRequest request){
        userMapper.display3(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/increase5")
    public String increase5(HttpServletRequest request) {
        tag product = new tag();
        if(request.getParameter("id")!=null){
            product.setProduct_id(Integer.parseInt(request.getParameter("id")));
        }else{
            return "失败";
        }
        if(request.getParameter("vid")!=null){
            product.setId(request.getParameter("vid"));
        }else{
            return "名为空";
        }
        if(request.getParameter("value")!=null){
            product.setValue(request.getParameter("value"));
        }else{
            product.setValue("");
        }
        if(request.getParameter("status")!=null){
            product.setStatus(request.getParameter("status").charAt(0));
        }else{
            product.setStatus('1');
        }
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
        userMapper.increase5(product);
        return "成功";
    }
    @RequestMapping("/upda")
    public String upda(HttpServletRequest request) {
        tag product = new tag();
        if(request.getParameter("id")!=null){
            product.setTag_id(Integer.parseInt(request.getParameter("id")));
        }else{
            return "名为空";
        }
        if(request.getParameter("vid")!=null){
            product.setId(request.getParameter("vid"));
        }else{
            return "名为空";
        }
        if(request.getParameter("value")!=null){
            product.setValue(request.getParameter("value"));
        }else{
            product.setValue("");
        }
        product.setUpdated_at(new Date());
        userMapper.upda(product);
        return "成功";
    }

}
