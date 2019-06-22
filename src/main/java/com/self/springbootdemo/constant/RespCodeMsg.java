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

}
