package com.example.wx.controller;

import com.example.wx.entity.Friend;
import com.example.wx.entity.Resonse;
import com.example.wx.entity.User;
import com.example.wx.mapper.FriendMapper;
import com.example.wx.mapper.TokenMapper;
import com.example.wx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class FriendController {
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/insert/friend")
    public String NewFriend(HttpServletRequest request){
        if(request.getParameter("token")==null){
            return "没有token";
        }
        if (tokenMapper.selectid(request.getParameter("token"))==null){
            return "token错误";
        }
        if(userMapper.lookup(request.getParameter("username"))==null){
            return "该用户不存在";
        }
        Friend friend=new Friend();
        friend.setCreatedAt(new Date());
        friend.setUpdatedAt(new Date());
        friend.setFriendId(userMapper.lookup(request.getParameter("username")).getId());
        friend.setUserId(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))));
        if(friendMapper.selectF(friend)==null){
            friendMapper.insert(friend);
            return "成功";
        }
        return "他已经是你好友啦";
    }
    @RequestMapping("/delect/friendMapper")
    public String DFriend(HttpServletRequest request){
        if(request.getParameter("token")==null){
            return "没有token";
        }
        if (tokenMapper.selectid(request.getParameter("token"))==null){
            return "token错误";
        }
        if(userMapper.lookup(request.getParameter("username"))==null){
            return "该用户不存在";
        }
        Friend friend=new Friend();
        friend.setFriendId(userMapper.lookup(request.getParameter("username")).getId());
        friend.setUserId(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))));
        if(friendMapper.selectF(friend)==null){
            return "他并不是你打好友";
        }
        friendMapper.delect(friend);
        return "成功";
    }
    @RequestMapping("/select/friendMapper")
    public Resonse SFriend(HttpServletRequest request){
        Resonse resonse=new Resonse();
        if(request.getParameter("token")==null){
            resonse.setObject(null);
            resonse.setTips("没有token");
            return resonse;
        }
        if (tokenMapper.selectid(request.getParameter("token"))==null){
            resonse.setObject(null);
            resonse.setTips("token错误");
            return resonse;
        }
        List<User> friend=new LinkedList();
        friend=friendMapper.select(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))));
        resonse.setObject(friend);
        resonse.setTips("成功");
        return resonse;
    }
}
