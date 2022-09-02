package com.paralegalapi.demo.controller;


import com.paralegalapi.demo.domain.User;
import com.paralegalapi.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paralegalapi.demo.service.UserService;


@RestController


public class UserController {


    @GetMapping(value="/test")
    public String test() {
        return "success";
    }

    // 添加用户

    @PostMapping(value = "/addUser")
    public String addUser(User user){
        UserService userService = new UserServiceImpl();
        userService.add(user);
        return "success";
    }

    //删除用户

    @PostMapping(value = "/delUser")
    public String delUser(String user){
        UserService userService = new UserServiceImpl();
        userService.del(user);

        return "success";
    }

    //注册用户

    @PostMapping(value = "/regist")
    public String regist(String username, String password){
        UserService userService = new UserServiceImpl();

        return userService.regist(username, password).getMsg();
    }

    //登录

    @PostMapping(value = "/login")
    public String login(String username, String password){
        UserService userService = new UserServiceImpl();
        return userService.Login(username, password).getMsg();
    }

    //修改信息
    //TODO
    @PostMapping(value = "/edit")
    public String edit(String oldUserName, String newUserName, String password){
        UserService userService = new UserServiceImpl();
        User user = new User();
        return null;
    }


}
