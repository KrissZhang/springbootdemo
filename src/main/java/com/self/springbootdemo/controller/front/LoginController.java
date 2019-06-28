package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.constant.RespCodeMsg;
import com.self.springbootdemo.constant.SysConstant;
import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.UserService;
import com.self.springbootdemo.util.Md5;
import com.self.springbootdemo.util.RedisUtil;
import com.self.springbootdemo.util.RpcClientResult;
import com.self.springbootdemo.util.StringUtils;
import io.swagger.annotations.*;
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
    @ApiOperation(value = "重定向到登录页面", httpMethod = "GET", notes = "重定向到登录页面")
    @RequestMapping(value = "/toLoginPage", method = RequestMethod.GET)
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
