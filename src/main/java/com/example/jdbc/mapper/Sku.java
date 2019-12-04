package com.example.jdbc.mapper;

import com.example.jdbc.user.commodity;
import com.example.jdbc.user.sku;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Sku {
    //查看指定商品库存
    @Select("SELECT * FROM pre_sku where product_id=#{product_id}")
    List<sku> getAllByPage(long product_id);
    @Select("SELECT * FROM pre_product Where id=#{id}")
    commodity getOne2(long id);
    //增加库存
    @Insert("INSERT INTO pre_sku (product_id,original_price,price,attr1,attr2,attr3,quantity,sort,status,created_at,updated_at) VALUES (#{product_id},#{original_price},#{price},#{attr1},#{attr2},#{attr3},#{quantity},#{sort},#{status},#{created_at},#{updated_at})")
    void increase3(sku a);
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
}
