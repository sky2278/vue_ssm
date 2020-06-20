package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/deleteById")
    public void deleteById(@RequestBody User user) {
        System.out.println("删除成功!");
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        List<User> list = userService.findAll();
        return list;
    }

    @RequestMapping("/findById")
    public User findById(Integer uid) {
        User user = userService.findById(uid);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/update")
    public Map<String, Object> update(@RequestBody User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        userService.update(user);
        map.put("flag", true);
        map.put("message", "修改成功!");
        return map;
    }

}
