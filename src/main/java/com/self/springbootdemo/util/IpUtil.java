package com.self.springbootdemo.util;

import com.self.springbootdemo.constant.Constant;
import com.self.springbootdemo.constant.SysConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Ip工具类
 * @author zp
 */
public class IpUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(IpUtil.class);

    /**
     * 获取请求真实ip地址
     * @param request 请求
     * @return ip地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress;

        try {
            ipAddress = request.getHeader("x-forwarded-for");

            if (StringUtils.isBlank(ipAddress) || SysConstant.SYS_IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }

            if (StringUtils.isBlank(ipAddress) || SysConstant.SYS_IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }

            if (StringUtils.isBlank(ipAddress) || SysConstant.SYS_IP_UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();

                if (SysConstant.SYS_IP_LOCAL.equals(ipAddress)) {
                    //根据网卡取本机配置的IP
                    InetAddress inet = null;

                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        logger.error(e.getMessage());
                    }

                    ipAddress = inet.getHostAddress();
                }
            }

            if (ipAddress != null && ipAddress.length() > Constant.Number.FIFTEEN) {
                if (ipAddress.indexOf(SysConstant.SYS_COMMA) > Constant.Number.ZERO) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(SysConstant.SYS_COMMA));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }

        return ipAddress;
    }

}
