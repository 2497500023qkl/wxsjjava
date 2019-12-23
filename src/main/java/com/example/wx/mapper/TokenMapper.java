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
public interface TokenMapper {
    @Select("select a.* from token a,user where a.user_id=user.id and user.username=#{username}")
    Token selectToken(String username);
    @Select("select user_id from token where token=#{token}")
    String selectid(String token);
    @Select("select user.* from (select user_id from token where token=#{token}) a ,user where a.user_id=user.id")
    User selectuser(String token);
    @Insert("insert into token(id,token,user_id,created_at,updated_at)values(#{id},#{token},#{userId},#{createdAt},#{updatedAt})")
    void insertToken(Token token);
    @Update("update token set token=#{token}, updated_at=#{updatedAt} where user_id=#{userId}")
    void updateToken(String token, long userId, Date updatedAt);
}
