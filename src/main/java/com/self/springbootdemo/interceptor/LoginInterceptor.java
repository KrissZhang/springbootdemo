package com.self.springbootdemo.interceptor;

import com.self.springbootdemo.constant.SysConstant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author zp
 */
public class LoginInterceptor implements HandlerInterceptor {

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
        //从会话中获取登录用户id
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("uid");

        //若找不到登录用户id则拦截并重定向到登录页面，否则放行
        if(obj == null){
            response.sendRedirect(SysConstant.SYS_LOGIN_REDIRECT_URL);
            return false;
        }

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
