package com.self.springbootdemo.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 测试表po
 * @author zp
 */
@ApiModel(value = "测试表po", description = "测试表po")
public class TestInfo {
    /**
     * id
     */
    @ApiModelProperty(value = "测试表主键id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 值
     */
    @ApiModelProperty(value = "值")
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}