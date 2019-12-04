package com.example.jdbc.mapper;

import com.example.jdbc.user.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //搜索商品表
    @Select("SELECT pre_product.*,pre_category.name as category_name FROM  pre_product,pre_category where pre_product.category_id=pre_category.id and pre_category.status!=3 order by sort asc")
    List<commodity> getAll();
    //搜索分类
    @Select("SELECT * FROM pre_category where status!=3  order by sort asc")
    List<category> getAll2();
    //查看指定商品库存
    @Select("SELECT * FROM pre_sku where product_id=#{product_id}")
    List<sku> getAllByPage(long product_id);
    //增加分类
    @Insert("INSERT INTO pre_category (name, property,sort,status,created_at,updated_at) VALUES (#{name},#{property},#{sort},#{status},#{created_at},#{updated_at})")
    void increase1(category a);
    //增加商品
    @Insert("INSERT INTO pre_product (category_id,name, sale_num,content,sort,status,created_at,updated_at) VALUES (#{category_id},#{name},#{sale_num},#{content},#{sort},#{status},#{created_at},#{updated_at})")
    void increase2(commodity a);
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
    //搜索商品
    @Select("SELECT * FROM pre_product Where id=#{id}")
    commodity getOne2(long id);
    //修改商品
    @Update("UPDATE pre_product SET name=#{name},sale_num=#{sale_num},content=#{content},sort=#{sort},status=#{status},updated_at=#{updated_at} WHERE id =#{id}")
    void change(commodity a);
    @Update("UPDATE pre_product SET name=#{name},sale_num=#{sale_num},content=#{content},sort=#{sort},status=#{status},updated_at=#{updated_at} WHERE id =#{id}")
    void change1(commodity a);
    @Update("UPDATE  pre_product SET status=3 WHERE id =#{id}")
    void delete1(long id);
    @Update("UPDATE  pre_product SET status=2 WHERE id =#{id}")
    void hide1(long id);
    @Update("UPDATE  pre_product SET status=1 WHERE id =#{id}")
    void display1(long id);
    //增加库存
    @Insert("INSERT INTO pre_sku (product_id,original_price,price,attr1,attr2,attr3,quantity,sort,status,created_at,updated_at) VALUES (#{product_id},#{original_price},#{price},#{attr1},#{attr2},#{attr3},#{quantity},#{sort},#{status},#{created_at},#{updated_at})")
    void increase3(sku a);
    @Insert("insert into qkl (attr1,attr2,product_id) VALUES (#{attr1},#{attr2},#{product_id})")
    void increase4(qkl a);
    @Select("select * from qkl where product_id=#{id}")
    List<qkl> getAll3(long id);
    @Delete("delete from qkl where id=#{id}")
    void delec(long id);
    @Select("select * from pre_sku where product_id=#{id} and status!=3")
    List<sku> getAll4(long id);
    @Update("UPDATE  pre_sku SET status=3 WHERE id =#{id}")
    void delete2(long id);
    @Update("UPDATE  pre_sku SET status=2 WHERE id =#{id}")
    void hide2(long id);
    @Update("UPDATE  pre_sku SET status=1 WHERE id =#{id}")
    void display2(long id);
    @Update("Update  pre_sku set original_price=#{original_price},price=#{price},quantity=#{quantity},sort=#{sort},updated_at=#{updated_at} WHERE id=#{id}")
    void Update(sku a);
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
