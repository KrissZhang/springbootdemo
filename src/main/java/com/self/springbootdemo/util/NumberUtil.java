package com.self.springbootdemo.util;

import java.math.BigInteger;

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

    /**
     * long精确加法
     * @param val1 加数1
     * @param val2 加数2
     * @return 运算结果
     */
    public static long decimalAdd(long val1, long val2){
        return BigInteger.valueOf(val1).add(BigInteger.valueOf(val2)).longValue();
    }

    /**
     * long精确减法
     * @param val1 被减数
     * @param val2 减数
     * @return 运算结果
     */
    public static long decimalSubtract(long val1, long val2){
        return BigInteger.valueOf(val1).subtract(BigInteger.valueOf(val2)).longValue();
    }

    /**
     * long精确乘法
     * @param val1 乘数1
     * @param val2 乘数2
     * @return 运算结果
     */
    public static long decimalmultiply(long val1, long val2){
        return BigInteger.valueOf(val1).multiply(BigInteger.valueOf(val2)).longValue();
    }

    /**
     * long精确除法
     * @param val1 被除数
     * @param val2 除数
     * @return 运算结果
     */
    public static long decimalDiv(long val1, long val2){
        return BigInteger.valueOf(val1).divide(BigInteger.valueOf(val2)).longValue();
    }

    /**
     * long精确取模
     * @param val1 参数1
     * @param val2 参数2
     * @return 运算结果
     */
    public static long decimalMod(long val1, long val2){
        return BigInteger.valueOf(val1).divide(BigInteger.valueOf(val2)).longValue();
    }

}
