package com.example.jdbc.api;

import com.example.jdbc.mapper.Logo;
import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.user.logo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class LogoCpntroller {

    //导航
    @Autowired
    Logo userMapper;
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
