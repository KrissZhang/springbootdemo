package com.self.springbootdemo.exception;

import com.self.springbootdemo.constant.RespCode;

/**
 * 运行时异常处理类
 * @author zp
 */
public class SpringbootDemoRuntimeException extends RuntimeException {

    /**
     * 异常编码
     */
    private String code;

    /**
     * 异常内容
     */
    private String msg;

    public SpringbootDemoRuntimeException(){
        super();
    }

    public SpringbootDemoRuntimeException(Exception e){
        super(e);
    }

    public SpringbootDemoRuntimeException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public SpringbootDemoRuntimeException(RespCode respCode){
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public SpringbootDemoRuntimeException(RespCode respCode,Exception e){
        super(e);
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
