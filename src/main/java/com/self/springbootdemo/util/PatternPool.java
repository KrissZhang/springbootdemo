package com.self.springbootdemo.util;

import java.util.regex.Pattern;

/**
 * 模式池
 * @author zp
 */
public class PatternPool extends cn.hutool.core.lang.PatternPool {

    /**
     * 特殊字符
     */
    public static final Pattern SPECIAL_CHAR = Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\n|\t");

}
