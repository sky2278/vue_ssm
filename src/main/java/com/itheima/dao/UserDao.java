package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{uid}")
    User findById(Integer uid);

    @Update("update user set age=#{age},username=#{username},password=#{password},email=#{email},sex=#{sex} where id = #{id}")
    void update(User user);
}
