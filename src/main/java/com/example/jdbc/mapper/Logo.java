package com.example.jdbc.mapper;

import com.example.jdbc.user.logo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Logo {
    //导航
    @Select("select * from pre_nav where status!=3")
    List<logo> getAll6();
    @Select("select * from pre_nav where id=#{id}")
    List<logo> getAll7(long id);
    @Update("UPDATE  pre_nav SET status=3 WHERE type_id =#{id}")
    void delete4(long id);
    @Update("UPDATE  pre_nav SET status=2 WHERE type_id =#{id}")
    void hide4(long id);
    @Update("UPDATE  pre_nav SET status=1 WHERE type_id =#{id}")
    void display4(long id);
    @Insert("insert into pre_nav(id,sort,title,picture,link_type,link_target,status,created_at,updated_at)values(#{id},#{sort},#{title},#{picture},#{link_type},#{link_target},#{status},#{created_at},#{updated_at})")
    void increase6(logo a);
    @Update("UPDATE  pre_nav set id=#{id} ,sort=#{sort} , title=#{title}, picture=#{picture}, link_type=#{link_type} , link_target=#{link_target},updated_at=#{updated_at} WHERE type_id =#{type_id}")
    void upda1(logo a);
}
