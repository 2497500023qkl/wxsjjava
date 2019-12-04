package com.example.jdbc.mapper;

import com.example.jdbc.user.qkl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Qkl {
    @Insert("insert into qkl (attr1,attr2,product_id) VALUES (#{attr1},#{attr2},#{product_id})")
    void increase4(qkl a);
    @Select("select * from qkl where product_id=#{id}")
    List<qkl> getAll3(long id);
    @Delete("delete from qkl where id=#{id}")
    void delec(long id);
}
