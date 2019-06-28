package com.self.springbootdemo.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户po
 * @author zp
 */
@ApiModel(value = "用户po", description = "用户po")
public class User {
    /**
     * id
     */
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String uname;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码")
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}