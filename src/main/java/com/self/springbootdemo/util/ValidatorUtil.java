package com.self.springbootdemo.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.self.springbootdemo.constant.Constant;

import java.util.Set;
import java.util.regex.Matcher;

/**
 * 校验工具类
 * @author zp
 */
public class ValidatorUtil {

    /**
     * 判断字符序列是否是邮箱
     * @param value 字符序列
     * @return true--是邮箱,false--不是邮箱
     */
    public static boolean isEmail(CharSequence value){
        return Validator.isEmail(value);
    }

    /**
     * 判断字符序列是否包含中文
     * @param value 字符序列
     * @return true--包含中文,false--不包含中文
     */
    public static boolean containsChinese(CharSequence value){
        return ReUtil.contains(PatternPool.CHINESES,value);
    }

    /**
     * 判断字符序列是否是手机号码
     * @param value 字符序列
     * @return true--是手机号码,false--不是手机号码
     */
    public static boolean isMobile(CharSequence value){
        return Validator.isMobile(value);
    }

    /**
     * 判断字符序列是否是身份证号
     * @param value 字符序列
     * @return true--是身份证号,false--不是身份证号
     */
    public static boolean isIdCard(CharSequence value){
        return Validator.isCitizenId(value);
    }

    /**
     * 判断字符序列是否包含特殊字符
     * @param value 字符序列
     * @return true--包含特殊字符,false--不包含特殊字符
     */
    public static boolean containsSpecialChar(CharSequence value){
        return ReUtil.contains(PatternPool.SPECIAL_CHAR,value);
    }

    /**
     * 判断字符序列是否是指定长度范围内的字母、数字、下划线
     * @param value 字符序列
     * @return true--复合规则,false--不复合规则
     */
    public static boolean isGeneral(CharSequence value,Integer min,Integer max){
        return Validator.isGeneral(value, min, max);
    }

    /**
     * 判断是否是日期
     * @param year 年
     * @param month 月
     * @param day 日
     * @return true--是日期,false--不是日期
     */
    public static boolean isDate(Integer year, Integer month, Integer day){
        if((month < Constant.Number.ONE) || (month > Constant.Number.TWELVE)){
            return false;
        }

        if((day < Constant.Number.ONE) || (day > Constant.Number.THIRTY_ONE)){
            return false;
        }

        Set<Integer> smallMonthSet = CollUtil.newHashSet(Constant.Number.FOUR,Constant.Number.SIX,Constant.Number.NINE,Constant.Number.ELEVEN);
        if((smallMonthSet.contains(month)) && (Constant.Number.THIRTY_ONE.equals(day))){
            return false;
        }

        return ((!Constant.Number.TWO.equals(month)) || ((day <= Constant.Number.TWENTY_NINE) && ((!Constant.Number.TWENTY_NINE.equals(day)) || (DateUtil.isLeapYear(year)))));
    }

    /**
     * 判断字符序列是否是日期
     * @param value 字符序列
     * @return true--是日期,false--不是日期
     */
    public static boolean isDate(CharSequence value){
        if(ReUtil.isMatch(PatternPool.BIRTHDAY, value)){
            Matcher matcher = PatternPool.BIRTHDAY.matcher(value);
            if(matcher.find()){
                int year = Integer.parseInt(matcher.group(Constant.Number.ONE));
                int month = Integer.parseInt(matcher.group(Constant.Number.THREE));
                int day = Integer.parseInt(matcher.group(Constant.Number.FIVE));
                return isDate(year, month, day);
            }
        }

        return false;
    }

}
