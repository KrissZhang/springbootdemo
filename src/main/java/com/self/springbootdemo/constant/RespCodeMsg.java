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
    RespCode PARAM_ERROR = RespCode.build("1002");

    /**
     * 用户名或密码错误
     */
    RespCode USER_OR_PWD_ERROR = RespCode.build("2001");

    /**
     * 登录成功
     */
    RespCode LOGIN_SUCCESS = RespCode.build("2002");

    /**
     * 邮件发送成功
     */
    RespCode EMAIL_SEND_SUCCESS = RespCode.build("3001");

    /**
     * 邮件发送失败
     */
    RespCode EMAIL_SEND_FAIL = RespCode.build("3002");

}
