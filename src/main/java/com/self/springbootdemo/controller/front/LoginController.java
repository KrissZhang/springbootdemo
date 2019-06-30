package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.service.LoginService;
import com.self.springbootdemo.util.RpcClientResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录接口
 * @author zp
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * 重定向到登录页面
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @ApiOperation(value = "重定向到登录页面", httpMethod = "GET", notes = "重定向到登录页面")
    @RequestMapping(value = "/toLoginPage", method = RequestMethod.GET)
    public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.toLoginPage(request, response);
    }

    /**
     * 登录
     * @param request 请求
     * @param response 响应
     * @param uname 用户名
     * @param pwd 密码
     * @return 登录结果
     */
    @ApiOperation(value = "登录", httpMethod = "POST", notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uname", dataType = "String", required = true, value = "用户名", defaultValue = " "),
            @ApiImplicitParam(paramType = "query", name = "pwd", dataType = "String", required = true, value = "密码", defaultValue = " ")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "参数错误"),
            @ApiResponse(code = 2001, message = "用户名或密码错误"),
            @ApiResponse(code = 2002, message = "登录成功")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam String uname, @RequestParam String pwd){
        return service.login(request, response, uname, pwd);
    }

    /**
     * 退出登录
     * @param request 请求
     * @param response 响应
     * @return 退出登录结果
     */
    @ApiOperation(value = "退出登录", httpMethod = "POST", notes = "退出登录")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败")
    })
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult logout(HttpServletRequest request, HttpServletResponse response){
        return service.logout(request, response);
    }

}
