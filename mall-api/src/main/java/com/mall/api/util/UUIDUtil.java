package com.mall.api.util;

import com.mall.common.util.SnowFlows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author HC
 * @Date 2020/6/24 15:08
 * @Version 1.0
 */
@RefreshScope
public class UUIDUtil {
    @Value("${UUID.dataCenterId}")
    private static long dataCenterId;

    @Value("${UUID.machineId}")
    private static long machineId;

    /**
     * @Description:获取唯一标识
     * @return:
     * @param:
    */
    public static String getId(){
        SnowFlows snowFlake = new SnowFlows(dataCenterId, machineId);
        return String.valueOf(snowFlake.nextId());
    }
}
