package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.util.RpcClientResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页接口
 * @author zp
 */
@RestController
@RequestMapping("/")
public class IndexController {

    /**
     * 用户身份认证
     * @param userName 用户名
     * @param password 密码
     * @return 认证结果
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        //身份令牌
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        //身份认证
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            //未知账户
            return RpcClientResult.getFail(RespCodeMsg.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException ice) {
            //密码错误
            return RpcClientResult.getFail(RespCodeMsg.PASSWORD_ERROR);
        } catch (LockedAccountException lae) {
            //账户已锁定
            return RpcClientResult.getFail(RespCodeMsg.LOCKED_ACCOUNT);
        } catch (ExcessiveAttemptsException eae) {
            //用户名或密码错误次数过多
            return RpcClientResult.getFail(RespCodeMsg.EXCESSIVE_ATTEMPTS);
        } catch (AuthenticationException ae) {
            //用户名或密码不正确
            return RpcClientResult.getFail(RespCodeMsg.AUTHENTICATION);
        }

        if (subject.isAuthenticated()) {
            //登录成功
            RpcClientResult result = RpcClientResult.getSuccess();
            result.setCode(RespCodeMsg.LOGIN_SUCCESS.getCode());
            result.setMsg(RespCodeMsg.LOGIN_SUCCESS.getMsg());

            return result;
        } else {
            //登录失败
            token.clear();
            return RpcClientResult.getFail(RespCodeMsg.LOGIN_FAIL);
        }
    }

    /**
     * 权限请求
     * @return 请求结果
     */
    @RequiresPermissions("admin:see")
    @RequestMapping("/permission")
    public RpcClientResult permission() {
        return RpcClientResult.getSuccess();
    }

}
