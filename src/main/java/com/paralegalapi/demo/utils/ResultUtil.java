package com.paralegalapi.demo.utils;

import com.paralegalapi.demo.domain.Result;
import com.paralegalapi.demo.Enums.ResultEnum;

public class ResultUtil {

    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }

    public static Result success(ResultEnum resultEnum,Object data){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(data);
        return result;
    }

    public static Result error(int i, String defaultMessage) {
        Result result = new Result();
        result.setCode(i);
        result.setMsg(defaultMessage);
        result.setData(null);
        return result;
    }
}