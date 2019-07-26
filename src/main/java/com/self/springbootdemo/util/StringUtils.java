package com.self.springbootdemo.util;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 * @author zp
 */
public class StringUtils extends StrUtil {

    /**
     * 模糊匹配关键字符处理
     * @return 处理后的关键字符
     */
    public static String addLikeSymbol(String keyword){
        return "%" + keyword + "%";
    }

}
