package com.example.jdbc.mapper;

import com.example.jdbc.user.commodity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface product {
    //搜索商品表
    @Select("SELECT pre_product.*,pre_category.name as category_name FROM  pre_product,pre_category where pre_product.category_id=pre_category.id and pre_category.status!=3 order by sort asc")
    List<commodity> getAll();
    //增加商品
    @Insert("INSERT INTO pre_product (category_id,name, sale_num,content,sort,status,created_at,updated_at) VALUES (#{category_id},#{name},#{sale_num},#{content},#{sort},#{status},#{created_at},#{updated_at})")
    void increase2(commodity a);
    //搜索商品
    @Select("SELECT * FROM pre_product Where id=#{id}")
    commodity getOne2(long id);
    //修改商品
    @Update("UPDATE pre_product SET name=#{name},sale_num=#{sale_num},content=#{content},sort=#{sort},status=#{status},updated_at=#{updated_at} WHERE id =#{id}")
    void change(commodity a);
    @Update("UPDATE  pre_product SET status=3 WHERE id =#{id}")
    void delete1(long id);
    @Update("UPDATE  pre_product SET status=2 WHERE id =#{id}")
    void hide1(long id);
    @Update("UPDATE  pre_product SET status=1 WHERE id =#{id}")
    void display1(long id);
}
