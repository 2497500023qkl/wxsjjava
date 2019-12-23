package com.example.wx.controller;

import com.example.wx.entity.Resonse;
import com.example.wx.entity.Token;
import com.example.wx.entity.User;
import com.example.wx.mapper.TokenMapper;
import com.example.wx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenMapper tokenMapper;
    @RequestMapping("/insert/user")
        public String   plus(HttpServletRequest request){
        if(request.getParameter("username")==""||request.getParameter("password")==""){
            return "输入用户名或密码";
        }
        if(request.getParameter("username")==null||request.getParameter("password")==null){
            return "没有参数username或password";
        }
        if(userMapper.lookup(request.getParameter("username"))!=null){
                return "创建的用户已存在";
            }
        if(request.getParameter("nickname")==""||request.getParameter("nickname")==null){
            return "未输入用户昵称";
        }
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPasswordHash(request.getParameter("password").hashCode()+"");
        user.setNickname(request.getParameter("nickname"));
        user.setAvatar("#");
        user.setStatus(1);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userMapper.insert(user);
        return "成功";
    }
    @RequestMapping("/select/user")
    public Resonse check(HttpServletRequest request){
        Resonse resonse=new Resonse();
        if(request.getParameter("username")==""||request.getParameter("password")==""){
            resonse.setTips("输入用户名或密码");
            resonse.setObject(null);
            return resonse;
        }
        if(request.getParameter("username")==null||request.getParameter("password")==null){
            resonse.setTips("没有参数username或password");
            resonse.setObject(null);
            return resonse;
        }
        if(userMapper.select(request.getParameter("username"),request.getParameter("password").hashCode()+"")==null){
            resonse.setTips("没有此用户");
            resonse.setObject(null);
            return resonse;
        }
        try{
            userMapper.update(2,request.getParameter("username"),new Date(),request.getParameter("password").hashCode()+"");
            String uu="";
            if(tokenMapper.selectToken(request.getParameter("username"))==null){
                Token token=new Token();
                UUID uuid=UUID.randomUUID();
                uu=uuid.toString();
                token.setToken(uu);
                token.setCreatedAt(new Date());
                token.setUpdatedAt(new Date());
                token.setUserId(userMapper.lookup(request.getParameter("username")).getId());
                tokenMapper.insertToken(token);
            }else{
                UUID uuid=UUID.randomUUID();
                uu=uuid.toString();
                tokenMapper.updateToken(uu,userMapper.lookup(request.getParameter("username")).getId(),new Date());
            }
            resonse.setObject(userMapper.select(request.getParameter("username"),request.getParameter("password").hashCode()+""));
            resonse.setTips(uu);
        }catch (Exception e){
            resonse.setTips("数据库读取失败");
            resonse.setObject(null);
        }
        return resonse;
    }
    @RequestMapping("/update/user1")
    public String change(HttpServletRequest request){
        if(request.getParameter("username")==""||request.getParameter("password")==""){
            return "输入用户名或密码";
        }
        if(request.getParameter("username")==null||request.getParameter("password")==null){
            return "没有参数username或password";
        }
        userMapper.update(1,request.getParameter("username"),new Date(),request.getParameter("password").hashCode()+"");
        return "成功";
    }
    @RequestMapping("/select/username")
    public Resonse username(HttpServletRequest request){
        Resonse resonse=new Resonse();
        if(request.getParameter("token")==null){
            resonse.setObject(null);
            resonse.setTips("无token");
            return resonse;
        }
        if(request.getParameter("token")==""){
            resonse.setObject(null);
            resonse.setTips("token为空");
            return resonse;
        }
        User user=new User();
        user=tokenMapper.selectuser(request.getParameter("token"));
        resonse.setObject(user);
        resonse.setTips("ok");
        return resonse;
    }
}
