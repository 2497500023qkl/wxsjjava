package com.example.jdbc.mapper;

import com.example.jdbc.user.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM pre_product Where id=#{id}")
    commodity getOne2(long id);
    //搜索分类
    @Select("SELECT * FROM pre_category where status!=3  order by sort asc")
    List<category> getAll2();
    //增加分类
    @Insert("INSERT INTO pre_category (name, property,sort,status,created_at,updated_at) VALUES (#{name},#{property},#{sort},#{status},#{created_at},#{updated_at})")
    void increase1(category a);
    //修改分类
    @Update("UPDATE pre_category SET name=#{name},property=#{property},sort=#{sort},status=#{status},updated_at=#{updated_at} WHERE id =#{id}")
    void update(category a);
    //搜索分类
    @Select("SELECT * FROM pre_category Where id=#{id}")
    category getOne(long id);
    @Update("UPDATE  pre_category SET status=3 WHERE id =#{id}")
    void delete(long id);
    @Update("UPDATE  pre_category SET status=2 WHERE id =#{id}")
    void hide(long id);
    @Update("UPDATE  pre_category SET status=1 WHERE id =#{id}")
    void display(long id);


}
