package com.mall.sys.config;

import com.mall.common.config.GlobalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author HC
 * @Date 2020/5/20 16:54
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
/*    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置对“/”的请求映射到index
        //如果没有数据返回到页面，没有必要用控制器方法对请求进行映射
        registry.addViewController("/").setViewName("index");
    }*/

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
    }


}
