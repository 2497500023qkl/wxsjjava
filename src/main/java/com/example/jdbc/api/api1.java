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
public class api1 {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/hello")
    public List<commodity> say() {
        commodity product = new commodity();
        List<commodity> userList = userMapper.getAll();
        return userList;
    }
    @RequestMapping("/hello1")
    public List<category> say1() {
        category product = new category();
        List<category> userList = userMapper.getAll2();
        return userList;
    }
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
        if(request.getParameter("category_id")==null||request.getParameter("category_id").equals("")){
            userMapper.change1(cate);
            return "成功";
        }else{
            cate.setCategory_id(Long.parseLong(request.getParameter("category_id")));
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
    //导航
    @RequestMapping("/hello111")
    public List<logo> say3(HttpServletRequest request) {
            List<logo> userList = userMapper.getAll6();
            return userList;
    }
    @RequestMapping("/hello1111")
    public List<logo> say4(HttpServletRequest request) {
        List<logo> userList = userMapper.getAll7(Integer.parseInt(request.getParameter("id")));
        return userList;
    }
    @RequestMapping("/increase6")
    public String increase6(HttpServletRequest request) {
        logo product = new logo();
        if(request.getParameter("id")!=null){
            product.setId(Integer.parseInt(request.getParameter("id")));
        }else{
            return "失败";
        }
        if(request.getParameter("sort")!=null){
            product.setSort(Integer.parseInt(request.getParameter("sort")));
        }else{
            return "失败";
        }
        if(request.getParameter("link_type")!=null){
            product.setLink_type(Integer.parseInt(request.getParameter("link_type")));
        }else{
            return "失败";
        }
        if(request.getParameter("title")!=null){
            product.setTitle(request.getParameter("title"));
        }else{
            return "名为空";
        }
        if(request.getParameter("picture")!=null){
            product.setPicture(request.getParameter("picture"));
        }else{
            product.setPicture("");
        }
        if(request.getParameter("link_target")!=null){
            product.setLink_target(request.getParameter("link_target"));
        }else{
            product.setLink_target("");
        }
        if(request.getParameter("status")!=null){
            product.setStatus(request.getParameter("status").charAt(0));
        }else{
            product.setStatus('1');
        }
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
        userMapper.increase6(product);
        return "成功";
    }
    @RequestMapping("/upda1")
    public String upda1(HttpServletRequest request) {
        logo product = new logo();
        if(request.getParameter("vid")!=null){
            product.setType_id(Integer.parseInt(request.getParameter("vid")));
        }else{
            return "名为空";
        }
        if(request.getParameter("id")!=null){
            product.setId(Integer.parseInt(request.getParameter("id")));
        }else{
            return "名为空";
        }
        if(request.getParameter("sort")!=null){
            product.setSort(Integer.parseInt(request.getParameter("sort")));
        }else{
            return "名为空";
        }
        if(request.getParameter("link_type")!=null){
            product.setLink_type(Integer.parseInt(request.getParameter("link_type")));
        }else{
            return "名为空";
        }
        if(request.getParameter("link_target")!=null){
            product.setLink_target(request.getParameter("link_target"));
        }else{
            return "名为空";
        }
        if(request.getParameter("title")!=null){
            product.setTitle(request.getParameter("title"));
        }else{
            return "名为空";
        }
        if(request.getParameter("picture")!=null){
            product.setPicture(request.getParameter("picture"));
        }else{
            product.setPicture("");
        }
        product.setUpdated_at(new Date());
        userMapper.upda1(product);
        return "成功";
    }
    @RequestMapping("/delete4")
    public String delete4(HttpServletRequest request){
        userMapper.delete4(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/hide4")
    public String hide4(HttpServletRequest request){
        userMapper.hide4(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/display4")
    public String display4(HttpServletRequest request){
        userMapper.display4(Long.parseLong(request.getParameter("id")));
        return "成功";
    }
    @RequestMapping("/img")
    public List<String> img(@RequestParam Map<String, Object> params, HttpServletRequest request) throws IOException {
        // 复杂类型的request对象
        List<String> ca=new ArrayList<String>();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        // 获取文件名集合放入迭代器
        Iterator<String> files = mRequest.getFileNames();
        while (files.hasNext()) {
            // 获取上传文件的对象
            MultipartFile mFile = mRequest.getFile(files.next());
            if (mFile != null) {
                //原始文件名称
                UUID uuid=UUID.randomUUID();
                String oldfile = mFile.getOriginalFilename();
                String suffix2 = oldfile.substring(oldfile.indexOf('.'), oldfile.length());
                System.out.println(mFile);
                String filePath ="/home/qkl/jdbc/img/" +uuid+suffix2;
                String s="http://192.168.28.55:8080/"+uuid+suffix2;
                // 转存文件
                System.out.println(filePath);
                mFile.transferTo(new File(filePath));
                ca.add(s);
            }
        }
        return ca;
    }
}
