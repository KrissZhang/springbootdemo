package com.self.springbootdemo.constant;

import com.self.springbootdemo.i18n.I18nUtil;

/**
 * 响应码
 * @author zp
 */
public class RespCode {

    /**
     * 响应编码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    public RespCode(){
        super();
    }

    public RespCode(String code){
        this.code = code;
    }

    public RespCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取响应码信息
     * @return 响应码信息
     */
    public String getMsg(){
        return I18nUtil.get(code);
    }

    /**
     * 获取响应码
     * @return 响应码
     */
    public String getCode(){
        return code;
    }

    /**
     * 定义响应码
     * @param code 响应码
     * @return 响应码对象
     */
    public static RespCode build(String code){
        return new RespCode(code);
    }

}
