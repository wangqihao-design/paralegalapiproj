package com.paralegalapi.demo.service.impl;

import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.domain.User;
import com.paralegalapi.demo.service.UserService;
import com.paralegalapi.demo.DAO.UserMapper;
import com.paralegalapi.demo.utils.ResultUtil;
import com.paralegalapi.demo.Enums.ResultEnum;

import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService{


    @Override
    public boolean add(User user) {
        UserMapper userMapper = new UserMapper();
        userMapper.addUser(user);

        return false;
    }

    @Override
    public boolean del(String username) {
        UserMapper userMapper = new UserMapper();
        userMapper.delUser(username);
        return false;
    }

    @Override
    public Result EditUser(User oldUser, String UserName, String Password){
        UserMapper userMapper = new UserMapper();
        User user = new User();
        user.setUsername(UserName);
        user.setPassword(Password);
        userMapper.addUser(user);
        return null;
    }



    @Override
    public Result Login(String username, String password) {
        UserMapper userMapper = new UserMapper();

        if(!userMapper.UserExist(username))
            return ResultUtil.error(101, "请先注册");
        else {
            String user = userMapper.getUser("User:"+username);
            user = user.substring(1, user.length()-1);

            username = "\"" + username + "\"";
            password = "\"" + password + "\"";


            if(username.equals(user.split(",")[0]) && password.equals(user.split(",")[1])) {
                Logger.getLogger(getClass()).info("User " + username + " Login");

                return ResultUtil.success(ResultEnum.SUCCESS, "");
            }
            else
                return ResultUtil.error(103, "密码错误");

        }
    }

    @Override
    public Result regist(String username, String password) {
        UserMapper userMapper = new UserMapper();
        User user = new User();
        if(userMapper.UserExist(username)){
            return ResultUtil.error(100, "用户名已存在");
        }
        else {

            user.setUsername(username);
            user.setPassword(password);
            //TODO
            user.setUid(12);

            userMapper.addUser(user);

            return ResultUtil.success(ResultEnum.SUCCESS, user);
        }
    }
}
