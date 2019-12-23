package com.example.wx.mapper;

import com.example.wx.entity.Token;
import com.example.wx.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User lookup(String username);
    @Select("select * from user where username=#{username} and password_hash=#{password}")
    User select(String username,String password);
    @Insert("insert into user (username,nickname,password_hash,avatar,status,created_at,updated_at)values(#{username},#{nickname},#{passwordHash},#{avatar},#{status},#{createdAt},#{updatedAt})")
    void insert(User user);
    @Update("update user set status=#{status},updated_at=#{updatedAt} where username=#{username} and password_hash=#{passwordHash}")
    void update(long status, String username, Date updatedAt,String passwordHash);
}