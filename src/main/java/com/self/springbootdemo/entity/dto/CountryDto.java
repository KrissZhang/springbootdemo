package com.self.springbootdemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 国家信息dto
 * @author zp
 */
@ApiModel(value = "国家信息dto", description = "国家信息dto")
public class CountryDto {

    /**
     * 国家编码
     */
    @ApiModelProperty(value = "国家编码")
    private String isoCode;

    /**
     * geoNameId
     */
    @ApiModelProperty(value = "geoNameId")
    private Integer geoNameId;

    /**
     * 国家名称
     */
    @ApiModelProperty(value = "国家名称")
    private String countryName;

    public CountryDto() {
        super();
    }

    public CountryDto(String isoCode, Integer geoNameId, String countryName) {
        this.isoCode = isoCode;
        this.geoNameId = geoNameId;
        this.countryName = countryName;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Integer getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(Integer geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "isoCode='" + isoCode + '\'' +
                ", geoNameId=" + geoNameId +
                ", countryName='" + countryName + '\'' +
                '}';
    }

}
