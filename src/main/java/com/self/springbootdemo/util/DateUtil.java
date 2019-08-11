package com.self.springbootdemo.util;

import com.self.springbootdemo.constant.Constant;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 * @author zp
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

    /**
     * 日期格式
     */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 时间戳转日期字符串
     * @param timestamp 时间戳
     * @return 日期字符串
     */
    public static String timestampToStr(long timestamp){
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(Constant.Number.EIGHT)).toLocalDate();
        return localDate.format(formatter);
    }

}
