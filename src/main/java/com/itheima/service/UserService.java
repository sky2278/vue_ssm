package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();


    User findById(Integer uid);

    void update(User user);
}
