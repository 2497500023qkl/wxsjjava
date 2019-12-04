package com.example.jdbc.api;

import com.example.jdbc.mapper.Qkl;
import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.user.qkl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class QklController {

    @Autowired
    Qkl userMapper;
    @RequestMapping("/into")
    public String a(HttpServletRequest request){
        qkl qkl=new qkl();
        qkl.setAttr1(request.getParameter("attr1"));
        qkl.setAttr2(request.getParameter("attr2"));
        qkl.setProduct_id(Long.parseLong(request.getParameter("product_id")));
        userMapper.increase4(qkl);
        return "成功";
    }
    @RequestMapping("/see")
    public List<qkl> see(HttpServletRequest request){
        List<qkl> a=userMapper.getAll3(Long.parseLong(request.getParameter("product_id")));
        return a;
    }
    @RequestMapping("/delectqkl")
    public String a1(HttpServletRequest request){
        userMapper.delec(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
}
