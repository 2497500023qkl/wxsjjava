package com.example.wx.mapper;

import com.example.wx.entity.Friend;
import com.example.wx.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendMapper {
    @Select("select b.* from friend a,user b where a.user_id=#{user_id} and a.friend_id=b.id")
    List<User> select(long user_id);
    @Select("select * from friend where user_id=#{user_id} and friend_id=#{friend_id}")
    Friend selectF(Friend friend);
    @Delete("delete friend where user_id=#{user_id} and friend_id=#{friend_id}")
    void delect(Friend friend);
    @Insert("insert into friend (user_id,friend_id,created_at,updated_at)values(#{user_id},#{friend_id},#{created_at},#{updated_at})")
    void insert(Friend friend);
}
