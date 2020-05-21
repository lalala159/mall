package com.mall.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author HC
 * @Date 2020/5/20 10:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseUtil(Integer code, String message) {
        this(code, message, null);
    }
}
