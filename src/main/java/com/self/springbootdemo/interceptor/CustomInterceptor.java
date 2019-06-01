package com.self.springbootdemo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * @author zp
 */
public class CustomInterceptor implements HandlerInterceptor {

    /**
     * 请求处理前执行
     * @param request 请求
     * @param response 响应
     * @param handler handler
     * @return boolean (true--放行,false--拦截)
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 请求处理后视图渲染前执行
     * @param request 请求
     * @param response 响应
     * @param handler handler
     * @param modelAndView modelAndView
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求结束后执行
     * @param request 请求
     * @param response 响应
     * @param handler handler
     * @param ex 异常
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
