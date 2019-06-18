package com.self.springbootdemo.constant;

/**
 * 响应码信息
 * @author zp
 */
public interface RespCodeMsg {

    /**
     * 成功
     */
    RespCode SUCCESS = RespCode.build("1000");

    /**
     * 失败
     */
    RespCode FAIL = RespCode.build("1001");

    /**
     * 参数错误
     */
    RespCode PARAM_ERROR = RespCode.build("10001");

    /**
     * 未知账户
     */
    RespCode UNKNOWN_ACCOUNT = RespCode.build("2001");

    /**
     * 密码错误
     */
    RespCode PASSWORD_ERROR = RespCode.build("2002");

    /**
     * 账户已锁定
     */
    RespCode LOCKED_ACCOUNT = RespCode.build("2003");

    /**
     * 用户名或密码错误次数过多
     */
    RespCode EXCESSIVE_ATTEMPTS = RespCode.build("2004");

    /**
     * 用户名或密码不正确
     */
    RespCode AUTHENTICATION = RespCode.build("2005");

    /**
     * 登录成功
     */
    RespCode LOGIN_SUCCESS = RespCode.build("2006");

    /**
     * 登录失败
     */
    RespCode LOGIN_FAIL = RespCode.build("2007");

}
