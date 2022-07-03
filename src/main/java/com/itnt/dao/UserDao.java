package com.itnt.dao;

import com.itnt.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {
    @Insert("insert into tbl_book  values (null,#{type},#{name},#{description})")
    public int save(User user);
    @Delete("delete from tbl_book where id=#{id}")
    public int delete(Integer id);
    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    public int update(User user);
    @Select("select * from tbl_book where id=#{id}")
    public User getById(Integer id);
    @Select("select * from tbl_book")
    public List<User> getAll();
}
