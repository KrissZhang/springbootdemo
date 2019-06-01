package com.self.springbootdemo.util;

/**
 * 数字工具类
 * @author zp
 */
public class NumberUtil extends cn.hutool.core.util.NumberUtil {

    /**
     * 判断字符串是否是自然数
     * @param intStr 数值字符串
     * @return true--是自然数,false--不是自然数
     */
    public static boolean isNaturalNumber(String intStr){
        return (NumberUtil.isInteger(intStr) && Integer.parseInt(intStr) >= 0);
    }

    /**
     * 判断数值是否是自然数
     * @param integer integer
     * @return true--是自然数,false--不是自然数
     */
    public static boolean isNaturalNumber(Integer integer){
        return (integer != null && integer >= 0);
    }

}
