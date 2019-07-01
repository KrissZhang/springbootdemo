package com.self.springbootdemo.util;

import com.self.springbootdemo.constant.RespCode;
import com.self.springbootdemo.constant.RespCodeMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户端响应
 * @author zp
 */
@ApiModel(value = "响应结果", description = "api接口响应结果")
public class RpcClientResult<T> {

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功")
    private boolean success;

    /**
     * 响应码
     */
    @ApiModelProperty(value = "状态码")
    private String code;

    /**
     * 响应消息
     */
    @ApiModelProperty(value = "响应消息")
    private String msg;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    public RpcClientResult(){
        super();
    }

    public RpcClientResult(boolean success,String code,String msg){
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public RpcClientResult(boolean success,String code,String msg,T data){
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RpcClientResult(boolean success, RespCode respCode){
        this.success = success;
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public static RpcClientResult getSuccess(){
        return new RpcClientResult(true, RespCodeMsg.SUCCESS);
    }

    public static RpcClientResult getSuccess(RespCode respCode){
        return new RpcClientResult(true, respCode);
    }

    public static RpcClientResult getFail(){
        return new RpcClientResult(false, RespCodeMsg.FAIL);
    }

    public static RpcClientResult getFail(String msg){
        return new RpcClientResult(false, RespCodeMsg.FAIL.getCode(), msg);
    }

    public static RpcClientResult getFail(RespCode respCode){
        return new RpcClientResult(false, respCode);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
