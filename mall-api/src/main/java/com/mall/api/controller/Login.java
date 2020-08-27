package com.mall.api.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.Md5Utils;
import com.mall.api.domain.EsMember;
import com.mall.api.service.EsMemberServiceI;
import com.mall.common.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HC
 * @Date 2020/7/29 10:56
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "api")
@Api(tags = "小程序登陆")
@Slf4j
public class Login {
    @Autowired
    private EsMemberServiceI esMemberServiceI;

    @Value("${api.appId}")
    private String appId;

    @Value("${api.secret}")
    private String secret;


    @GetMapping("/getOpenId")
    @ApiOperation("获取openid")
    public Result getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + appId + "&secret=" + secret
                + "&js_code=" + code + "&grant_type=authorization_code";

        String data;
        log.debug("微信服务请求url:" + url);
        String openid = null;
        try {
            JSONObject obj = null;
            for (int i = 0; i < 3; i++) {
                data = HttpRequest.get(url)
                        .timeout(20000)
                        .execute().body();

                obj = JSONObject.parseObject(new String(data));
                log.debug("微信服务响应:" + obj.toJSONString());
                if (obj.getString("errcode") == null) {
                    break;
                }
                // 三次失败，则返回失败状态
                if (i == 2) {
                    return Result.fail(obj.toString());
                }
                Thread.sleep(300);
            }
            openid = obj.getString("openid");
            if(StringUtils.isNotEmpty(openid)){
                EsMember esMember = esMemberServiceI.getMemberByOpenId(openid);
               if(esMember!=null){
                   String token = Md5Utils.getMD5(openid, "UTF-8");
                   esMember.setToken(token);
                   esMemberServiceI.update(esMember);
                   return Result.success("1");
               }
            }else{
                return Result.fail("登陆异常");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.fail();
    }
}
