package com.paralegalapi.demo.service;

import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.domain.User;

public interface UserService {

    boolean add(User user);
    boolean del(String username);

    Result EditUser(User oldUser, String UserName, String Password);

    Result Login(String username, String password);
    Result regist(String username, String password);
}
