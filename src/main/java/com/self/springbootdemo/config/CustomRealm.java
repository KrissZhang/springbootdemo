package com.self.springbootdemo.config;

import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.UserService;
import com.self.springbootdemo.util.Md5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义认证器
 * @author zp
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService service;

    /**
     * 用户权限配置
     * @param principalCollection principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //用户名
        String userName = SecurityUtils.getSubject().getPrincipal().toString();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissionSet = new HashSet<>();

        //获取用户权限--TODO
        permissionSet.add("admin:see");

        info.setStringPermissions(permissionSet);

        return info;
    }

    /**
     * 用户身份认证
     * @param authenticationToken authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名
        String userName = authenticationToken.getPrincipal().toString();

        //密码
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        String userPwdMd5 = Md5.encodeByMD5(userPwd);

        //根据用户名从数据库获取加密密码
        User user = service.selectByUserName(userName).getData();
        String password = user.getPassword();

        if (userName == null) {
            throw new AccountException("username error");
        } else if (!userPwdMd5.equals(password)) {
            throw new AccountException("password error");
        }

        return new SimpleAuthenticationInfo(userName, password, getName());
    }

}
