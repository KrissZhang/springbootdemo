package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.UserService;
import com.self.springbootdemo.util.Md5;
import com.self.springbootdemo.util.RedisUtil;
import com.self.springbootdemo.util.RpcClientResult;
import com.self.springbootdemo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录接口
 * @author zp
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 重定向到登录页面
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @RequestMapping("/toLoginPage")
    public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(SysConstant.SYS_LOGIN_PAGE_URL);
    }

    /**
     * 登录
     * @param request 请求
     * @param response 响应
     * @param uname 用户名
     * @param pwd 密码
     * @return 登录结果
     */
    @RequestMapping(value = "/login", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public RpcClientResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam String uname, @RequestParam String pwd){
        //校验用户名是否为空
        if(StringUtils.isBlank(uname)){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        //校验密码是否为空
        if(StringUtils.isBlank(pwd)){
            return RpcClientResult.getFail(RespCodeMsg.PARAM_ERROR);
        }

        //Md5加密密码
        String pwdMd5 = Md5.encodeByMD5(pwd);

        //从数据库中获取对应用户信息
        User user = service.findUserByUName(uname);

        //校验用户名和密码是否匹配
        if(!pwdMd5.equals(user.getPwd())){
            return RpcClientResult.getFail(RespCodeMsg.USER_OR_PWD_ERROR);
        }

        //设置会话
        HttpSession session = request.getSession();
        session.setAttribute("uid", user.getId());
        session.setAttribute("uname", user.getUname());
        session.setAttribute("pwd", user.getPwd());

        //保存Redis缓存
        Map<String, Object> loginUserMap = new HashMap<>(3);
        loginUserMap.put("uid", user.getId().toString());
        loginUserMap.put("uname", user.getUname());
        loginUserMap.put("pwd", user.getPwd());
        boolean loginUserSetStatus = redisUtil.hmset("loginUser", loginUserMap,30 * 60);

        //返回登录结果
        if(loginUserSetStatus){
            RpcClientResult result = new RpcClientResult();
            result.setSuccess(true);
            result.setCode(RespCodeMsg.LOGIN_SUCCESS.getCode());
            result.setMsg(RespCodeMsg.LOGIN_SUCCESS.getMsg());

            return result;
        }else{
            return RpcClientResult.getFail(RespCodeMsg.FAIL);
        }
    }

}
