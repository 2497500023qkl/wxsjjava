package com.example.jdbc.mapper;

import com.example.jdbc.user.tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Tag {
    //商品标签
    @Select("select * from pre_product_tag where product_id=#{id} and status!=3")
    List<tag> getAll5(long id);
    @Update("UPDATE  pre_product_tag SET status=3 WHERE tag_id =#{id}")
    void delete3(long id);
    @Update("UPDATE  pre_product_tag SET status=2 WHERE tag_id =#{id}")
    void hide3(long id);
    @Update("UPDATE  pre_product_tag SET status=1 WHERE tag_id =#{id}")
    void display3(long id);
    @Insert("insert into pre_product_tag(product_id,id,value,status,created_at,updated_at)values(#{product_id},#{id},#{value},#{status},#{created_at},#{updated_at})")
    void increase5(tag a);
    @Update("UPDATE  pre_product_tag set id=#{id} , value=#{value} ,updated_at=#{updated_at} WHERE tag_id =#{tag_id}")
    void upda(tag a);
}
