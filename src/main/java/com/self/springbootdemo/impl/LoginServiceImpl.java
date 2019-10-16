package com.self.springbootdemo.impl;

import cn.hutool.setting.dialect.Props;
import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.LoginService;
import com.self.springbootdemo.service.UserService;
import com.self.springbootdemo.util.Md5;
import com.self.springbootdemo.util.RedisUtil;
import com.self.springbootdemo.util.RpcClientResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录Service
 * @author zp
 */
@Service
public class LoginServiceImpl implements LoginService {

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
    @Override
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
    @Override
    public RpcClientResult login(HttpServletRequest request, HttpServletResponse response, String uname, String pwd) {
        //Md5加密密码
        String pwdMd5 = Md5.encodeByMD5(pwd.trim());

        //从数据库中获取对应用户信息
        User user = service.findUserByUName(uname.trim());

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
        String sessionTimeout = new Props(SysConstant.SYS_CFG_NAME).get("session.timeout")==null?"30":new Props(SysConstant.SYS_CFG_NAME).get("session.timeout").toString();

        boolean loginUserSetStatus = redisUtil.hmset("loginUser", loginUserMap,Integer.valueOf(sessionTimeout) * 60);

        //返回登录结果
        if(loginUserSetStatus){
            return RpcClientResult.getSuccess(RespCodeMsg.LOGIN_SUCCESS);
        }else{
            return RpcClientResult.getFail(RespCodeMsg.FAIL);
        }
    }

    /**
     * 退出登录
     * @param request 请求
     * @param response 响应
     * @return 退出登录结果
     */
    @Override
    public RpcClientResult logout(HttpServletRequest request, HttpServletResponse response) {
        //删除用户登录会话信息
        HttpSession session = request.getSession();
        session.removeAttribute("uid");
        session.removeAttribute("uname");
        session.removeAttribute("pwd");

        //删除Redis缓存中用户登录信息
        long delNum = redisUtil.hdel("loginUser" , "uid", "uname", "pwd");

        return delNum>0?RpcClientResult.getSuccess():RpcClientResult.getFail(RespCodeMsg.FAIL);
    }

}
