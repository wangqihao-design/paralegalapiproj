package com.paralegalapi.demo.DAO;


import com.paralegalapi.demo.domain.User;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "controller")

public class UserMapper {


    /* 添加一位用户
     */

    public boolean addUser(User user){

        Jedis jedis = new JedisPool().getResource();
        Logger.getLogger(getClass()).info("Add User " + user.getUsername());

        List userinfo = new ArrayList<String>();
        // [Username, Password, Uid]
        userinfo.add(user.getUsername());
        userinfo.add(user.getPassword());
        userinfo.add(user.getUid());

        Gson gson = new Gson();
        String JsonUserinfo = gson.toJson(userinfo);
        jedis.set("User:" + user.getUsername(), JsonUserinfo);
        return true;
    }

    /* 删除一位用户
    *
     */

    public boolean delUser(String username){

        Jedis jedis = new JedisPool().getResource();

        jedis.del(username);

        Logger.getLogger(getClass()).info("Del User " + username);
        return true;
    }

    // 查找一个用户

    public String getUser(String username){
        Jedis jedis = new JedisPool().getResource();
        return jedis.get(username);
    }

    // 查看用户是否存在

    public boolean UserExist(String username){
        Jedis jedis = new JedisPool().getResource();
        System.out.println(jedis.exists("User:"+username));
        return jedis.exists("User:"+username);
    }

}
