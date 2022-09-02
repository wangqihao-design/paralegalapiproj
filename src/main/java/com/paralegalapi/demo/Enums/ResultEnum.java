package com.paralegalapi.demo.Enums;


public enum ResultEnum {

    ERROR(400,"操作失败"),
    SUCCESS(200,"成功操作"),
    USEREXIST(100, "用户存在")

    ;


    private Integer code;

    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
