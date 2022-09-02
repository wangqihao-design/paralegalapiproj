package com.paralegalapi.demo.utils;



public class UserInfoSpliter {
    public String[] userinfoSpliter(String userInfo){
        userInfo = userInfo.substring(1, userInfo.length()-1);
        String[] userInfos = userInfo.split(",");
        return userInfos;
    }
}
