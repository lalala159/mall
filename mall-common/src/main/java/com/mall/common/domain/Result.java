package com.mall.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈响应实体〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private int code;
    private String message;
    private Object data;

    public Result(Integer code, String message) {
        this(code, message, null);
    }

    public Result(Integer code, Object data) {
        this(code, null, data);
    }

    public static Result success(String message){
        return new Result(200, message);
    }

    public static Result success(Object data){
        return new Result(200, data);
    }

    public static Result fail(String message){
        return new Result(500, message);
    }

    public static Result fail(Object data){
        return new Result(500, data);
    }
}
