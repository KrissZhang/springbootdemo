package com.self.springbootdemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 城市信息dto
 * @author zp
 */
@ApiModel(value = "城市信息dto", description = "城市信息dto")
public class CityDto {

    /**
     * 国家编码
     */
    @ApiModelProperty(value = "国家编码")
    private String isoCode;

    /**
     * 国家名称
     */
    @ApiModelProperty(value = "国家名称")
    private String countryName;

    /**
     * 省份名称
     */
    @ApiModelProperty(value = "省份名称")
    private String proviceName;

    /**
     * 城市名称
     */
    @ApiModelProperty(value = "城市名称")
    private String cityName;

    /**
     * 城市纬度
     */
    @ApiModelProperty(value = "城市纬度")
    private double latitude;

    /**
     * 城市经度
     */
    @ApiModelProperty(value = "城市经度")
    private double longitude;

    public CityDto() {
        super();
    }

    public CityDto(String isoCode, String countryName, String proviceName, String cityName, double latitude, double longitude) {
        this.isoCode = isoCode;
        this.countryName = countryName;
        this.proviceName = proviceName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "isoCode='" + isoCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", proviceName='" + proviceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

}
