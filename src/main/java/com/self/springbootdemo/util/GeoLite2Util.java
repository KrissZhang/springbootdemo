package com.self.springbootdemo.util;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.entity.dto.CityDto;
import com.self.springbootdemo.entity.dto.CountryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * GeoLite2工具类
 * @author zp
 */
public class GeoLite2Util {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(GeoLite2Util.class);

    /**
     * geoLite国家文件路径
     */
    private static String geoLiteCountryPath = "";

    /**
     * geoLite城市文件路径
     */
    private static String geoLiteCityPath = "";

    /**
     * geoLiteCountryReader
     */
    private static DatabaseReader geoLiteCountryReader;

    /**
     * geoLiteCityReader
     */
    private static DatabaseReader geoLiteCityReader;

    /**
     * 初始化加载Reader
     */
    public static void geoLite2Init(){
        try {
            //国家
            geoLiteCountryPath = CommonsUtil.getProjectRootPath() + SysConstant.SYS_GEOLITE_PACKAGE + SysConstant.SYS_SLASH + SysConstant.SYS_GEOLITE_COUNTRY + SysConstant.SYS_DOT + SysConstant.SYS_MMDB;
            File countryDb = new File(geoLiteCountryPath);
            geoLiteCountryReader = new DatabaseReader.Builder(countryDb).build();

            //城市
            geoLiteCityPath = CommonsUtil.getProjectRootPath() + SysConstant.SYS_GEOLITE_PACKAGE + SysConstant.SYS_SLASH + SysConstant.SYS_GEOLITE_CITY + SysConstant.SYS_DOT + SysConstant.SYS_MMDB;
            File cityDb = new File(geoLiteCityPath);
            geoLiteCityReader = new DatabaseReader.Builder(cityDb).build();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 通过ip地址获取国家信息
     * @param ip ip地址
     * @return 国家信息
     */
    @SuppressWarnings("unchecked")
    public static RpcClientResult<CountryDto> getCountryMsgByIpAddress(String ip){
        RpcClientResult<CountryDto> result = RpcClientResult.getFail();

        try {
            CountryResponse response = geoLiteCountryReader.country(InetAddress.getByName(ip));
            Country country = response.getCountry();

            CountryDto countryDto = new CountryDto();
            countryDto.setIsoCode(country.getIsoCode());
            countryDto.setGeoNameId(country.getGeoNameId());
            countryDto.setCountryName(country.getNames().get("zh-CN"));

            result = RpcClientResult.getSuccess(RespCodeMsg.SUCCESS);
            result.setData(countryDto);

        } catch (IOException | GeoIp2Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    /**
     * 通过ip地址获取城市信息
     * @param ip ip地址
     * @return 城市信息
     */
    @SuppressWarnings("unchecked")
    public static RpcClientResult<CityDto> getCityMsgByIpAddress(String ip){
        RpcClientResult<CityDto> result = RpcClientResult.getFail();

        try {
            CityResponse response = geoLiteCityReader.city(InetAddress.getByName(ip));

            CityDto cityDto = new CityDto();
            cityDto.setIsoCode(response.getCountry().getIsoCode());
            cityDto.setCountryName(response.getCountry().getNames().get("zh-CN"));
            cityDto.setProviceName(response.getMostSpecificSubdivision().getNames().get("zh-CN"));
            cityDto.setCityName(response.getCity().getNames().get("zh-CN"));
            cityDto.setLatitude(response.getLocation().getLatitude());
            cityDto.setLongitude(response.getLocation().getLongitude());

            result = RpcClientResult.getSuccess(RespCodeMsg.SUCCESS);
            result.setData(cityDto);

        } catch (IOException | GeoIp2Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

}
