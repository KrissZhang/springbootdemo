package com.self.springbootdemo.util;

import cn.hutool.core.date.DateTime;
import com.self.springbootdemo.constant.Constant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 * @author zp
 */
public class DateTimeUtil extends DateTime {

    /**
     * 时间格式
     */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间戳转时间字符串
     * @param timestamp 时间戳
     * @return 时间字符串
     */
    public static String timestampToStr(long timestamp){
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(Constant.Number.EIGHT)).toLocalDateTime();
        return localDateTime.format(formatter);
    }

}
