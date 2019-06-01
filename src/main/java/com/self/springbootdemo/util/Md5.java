package com.self.springbootdemo.util;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * Md5工具类
 * @author zp
 */
public class Md5 {

    /**
     * 字符串Md5加密
     * @param originString 加密源字符串
     * @return Md5值
     */
    public static String encodeByMD5(String originString){
        return DigestUtil.md5Hex(originString);
    }

}
