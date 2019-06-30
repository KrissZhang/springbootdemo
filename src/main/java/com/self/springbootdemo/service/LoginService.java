package com.self.springbootdemo.service;

import com.self.springbootdemo.util.RpcClientResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录Service
 * @author zp
 */
public interface LoginService {

    /**
     * 重定向到登录页面
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * 登录
     * @param request 请求
     * @param response 响应
     * @param uname 用户名
     * @param pwd 密码
     * @return 登录结果
     */
    RpcClientResult login(HttpServletRequest request, HttpServletResponse response, String uname, String pwd);

    /**
     * 退出登录
     * @param request 请求
     * @param response 响应
     * @return 退出登录结果
     */
    RpcClientResult logout(HttpServletRequest request, HttpServletResponse response);

}
