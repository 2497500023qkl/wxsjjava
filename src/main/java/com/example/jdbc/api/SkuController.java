package com.example.jdbc.api;

import com.example.jdbc.mapper.Sku;
import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.mapper.product;
import com.example.jdbc.user.commodity;
import com.example.jdbc.user.sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SkuController {
    @Autowired
    Sku userMapper;
    @RequestMapping("/hello2")
    public List<sku> say2(HttpServletRequest request) {
        if(request.getParameter("id").equals("")){
            return null;
        }
        String sk=request.getParameter("id");
        sku product = new sku();
        List<sku> userList = userMapper.getAllByPage(Integer.parseInt(sk));
        return userList;
    }
    @RequestMapping("/create2")
    public String cre2(HttpServletRequest request){
        commodity cate =new commodity();
        sku sk=new sku();
        if(request.getParameter("id").equals("")){
            return "没传入id";
        }else{
            cate=userMapper.getOne2(Integer.parseInt(request.getParameter("id")));
        }
        if(cate.equals("")){
            return "id错误";
        }
        sk.setCreated_at(new Date());
        sk.setUpdated_at(new Date());
        sk.setAttr1(request.getParameter("attr1"));
        sk.setAttr2(request.getParameter("attr2"));
        sk.setAttr3(request.getParameter("attr3"));
        sk.setProduct_id(Long.parseLong(request.getParameter("id")));
        if(request.getParameter("original_price").equals("")){
            sk.setOriginal_price(0);
        }else{
            sk.setOriginal_price(Integer.parseInt(request.getParameter("original_price")));
        }
        if(request.getParameter("price").equals("")){
            sk.setPrice(0);
        }else{
            sk.setPrice(Integer.parseInt(request.getParameter("price")));
        }
        if(request.getParameter("quantity").equals("")){
            sk.setQuantity(0);
        }else{
            sk.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        }
        if(request.getParameter("sort").equals("")){
            sk.setSort(10);
        }else{
            sk.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        if(request.getParameter("status").equals("")){
            sk.setStatus(cate.getStatus());
        }else{
            sk.setStatus(request.getParameter("status").charAt(0));
        }
        try{
            userMapper.increase3(sk);
            return "[{\"name\":\"成功\"}]";
        }catch (Error e){
            return "[{\"name\":\"服务器错误\"}]";
        }
    }
    @RequestMapping("/change3")
    public List<sku> change3(HttpServletRequest request){
        List<sku> cate =userMapper.getAll4(Long.parseLong(request.getParameter("id")));
        return cate;
    }
    @RequestMapping("/delete2")
    public String delete2(HttpServletRequest request){
        userMapper.delete2(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/hide2")
    public String hide2(HttpServletRequest request){
        userMapper.hide2(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/display2")
    public String display2(HttpServletRequest request){
        userMapper.display2(Long.parseLong(request.getParameter("id")));
        return "成功";
    }

    @RequestMapping("/Update")
    public String Update(HttpServletRequest request){
        sku sk=new sku();
        sk.setUpdated_at(new Date());
        if(request.getParameter("id")!=null){
            sk.setId(Integer.parseInt(request.getParameter("id")));
        }else{
            return "失败";
        }
        if(request.getParameter("original_price").equals("")){
        }else{
            sk.setOriginal_price(Integer.parseInt(request.getParameter("original_price")));
        }
        if(request.getParameter("price").equals("")){
        }else{
            sk.setPrice(Integer.parseInt(request.getParameter("price")));
        }
        if(request.getParameter("quantity").equals("")){
        }else{
            sk.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        }
        if(request.getParameter("sort").equals("")){
        }else{
            sk.setSort(Integer.parseInt(request.getParameter("sort")));
        }
        try{
            userMapper.Update(sk);
            return "[{\"name\":\"成功\"}]";
        }catch (Error e){
            return "[{\"name\":\"服务器错误\"}]";
        }
    }
}
