package com.self.springbootdemo.controller.front;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toString());

        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }

        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }

    @RequiresPermissions("admin:add")
    @RequestMapping("/permission")
    public String permission() {
        String result = "this is permission";
        return result;
    }

}
