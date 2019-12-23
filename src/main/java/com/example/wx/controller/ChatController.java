package com.example.wx.controller;

import com.example.wx.entity.Chat;
import com.example.wx.entity.Friend;
import com.example.wx.entity.Resonse;
import com.example.wx.mapper.ChatMapper;
import com.example.wx.mapper.FriendMapper;
import com.example.wx.mapper.TokenMapper;
import com.example.wx.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChatController {
    @Autowired
    ChatMapper chatMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    FriendMapper friendMapper;
    @RequestMapping("/insert/chat")
    public String NewNews(HttpServletRequest request){
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
        Chat chat=new Chat();
        chat.setCreatedAt(new Date());
        chat.setUpdatedAt(new Date());
        chat.setFriendId(friend.getFriendId());
        chat.setUserId(friend.getUserId());
        chat.setStatus(1);
        chat.setContent(request.getParameter("content"));
        chatMapper.insert(chat);
        return "发送成功";
    }
    @RequestMapping("/select/nchat")
    public Resonse NewSelectNews(HttpServletRequest request){
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
        resonse.setObject(chatMapper.selectAlln(Integer.parseInt(tokenMapper.selectid(request.getParameter("token")))));
        resonse.setTips("成功");
        return resonse;
    }
    @RequestMapping("/select/nfchat")
    public Resonse NewSelectNewsF(HttpServletRequest request){
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
        resonse.setObject(chatMapper.selectn(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))),Long.parseLong(request.getParameter("friendId"))));
        resonse.setTips(""+tokenMapper.selectid(request.getParameter("token")));
        return resonse;
    }
    @RequestMapping("/select/chat")
    public Resonse SelectNews(HttpServletRequest request){
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
        if(userMapper.lookup(request.getParameter("username"))==null){
            resonse.setObject(null);
            resonse.setTips("用户不存在");
            return resonse;
        }
        resonse.setTips(""+tokenMapper.selectid(request.getParameter("token")));
        resonse.setObject(chatMapper.selectAll(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))),userMapper.lookup(request.getParameter("username")).getId(),Long.parseLong(request.getParameter("f"))*10));
        return resonse;
    }
    @RequestMapping("/updata/chat")
    public String UpNewNews(HttpServletRequest request){
        if(request.getParameter("token")==null){
            return "没token";
        }
        if (tokenMapper.selectid(request.getParameter("token"))==null){
            return "token错误";
        }
        if(userMapper.lookup(request.getParameter("username"))==null){
            return "该用户不存在";
        }
        chatMapper.update(Integer.parseInt(tokenMapper.selectid(request.getParameter("token"))),userMapper.lookup(request.getParameter("username")).getId());
        return "成功";
    }
}
