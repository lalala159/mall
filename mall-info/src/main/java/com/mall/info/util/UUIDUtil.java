package com.mall.info.util;

import com.mall.common.util.SnowFlows;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author HC
 * @Date 2020/6/24 15:08
 * @Version 1.0
 */
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
