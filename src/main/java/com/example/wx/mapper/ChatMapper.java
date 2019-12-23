package com.example.wx.mapper;

import com.example.wx.entity.NewChat;
import org.apache.ibatis.annotations.*;
import com.example.wx.entity.Chat;

import java.util.List;

@Mapper
public interface ChatMapper {
    @Select("select aa.id,aa.username,aa.username,aa.nickname,aa.avatar, bb.content,bb.created_at from user aa,(select a.* from chat a,(select user_id,friend_id,max(created_at) as c from chat group by user_id,friend_id) b where b.friend_id=a.friend_id and a.user_id=b.user_id and a.created_at=b.c and a.`status`=1) bb where aa.id=bb.user_id and bb.friend_id=#{user_id} order by bb.created_at desc")
    List<NewChat> selectAlln(long userd);
    @Select("select * from chat where status=1 and user_id=#{friendId} and friend_id = #{userId} order by created_at asc")
    List<Chat> selectn(long userId,long friendId);
    @Select("select a.* from (select * from chat where user_id in(#{userId},#{friendId}) and friend_id in(#{friendId},#{userId}) order by created_at desc limit #{in},10) a order by created_at asc")
    List<Chat> selectAll(long userId,long friendId,long in);
    @Update("update chat set status=2 where user_id=#{friendId} and friend_id=#{userId}")
    void update(long userId,long friendId);
    @Insert("insert into chat (user_id,friend_id,content,status,created_at,updated_at)values(#{userId},#{friendId},#{content},#{status},#{createdAt},#{updatedAt})")
    void insert(Chat chat);
}
