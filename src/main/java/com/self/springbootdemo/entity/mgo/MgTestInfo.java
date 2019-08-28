package com.self.springbootdemo.entity.mgo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDb测试集合
 * @author zp
 */
@ApiModel(value = "MongoDb测试集合", description = "MongoDb测试集合")
@Document(collection = "MgTestInfo")
public class MgTestInfo {

    /**
     * id
     */
    @ApiModelProperty(value = "测试集合id")
    @Id
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Field
    private String mgName;

    /**
     * 值
     */
    @ApiModelProperty(value = "值")
    @Field
    private String mgValue;

    public MgTestInfo() {
        super();
    }

    public MgTestInfo(Integer id, String mgName, String mgValue) {
        this.id = id;
        this.mgName = mgName;
        this.mgValue = mgValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMgName() {
        return mgName;
    }

    public void setMgName(String mgName) {
        this.mgName = mgName;
    }

    public String getMgValue() {
        return mgValue;
    }

    public void setMgValue(String mgValue) {
        this.mgValue = mgValue;
    }

    @Override
    public String toString() {
        return "MgTestInfo{" +
                "id=" + id +
                ", mgName='" + mgName + '\'' +
                ", mgValue='" + mgValue + '\'' +
                '}';
    }

}
