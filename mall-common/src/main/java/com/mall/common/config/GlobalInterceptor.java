package com.mall.common.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author HC
 * @Date 2020/5/20 16:47
 * @Version 1.0
 */
public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String secretKey = request.getHeader("from");
        if(StringUtils.isNotBlank(secretKey) && secretKey.equals("gateway")){
            return true;
        }
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("error");
        return false;
    }
}
