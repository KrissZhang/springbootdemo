package com.self.springbootdemo.config;

import com.self.springbootdemo.entity.po.User;
import com.self.springbootdemo.service.PermissionService;
import com.self.springbootdemo.service.RoleService;
import com.self.springbootdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
        String username = (String) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("admin:see");

        info.setStringPermissions(stringSet);

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
        String userName = (String) authenticationToken.getPrincipal();

        String userPwd = new String((char[]) authenticationToken.getCredentials());
        userPwd = new SimpleHash("MD5", userPwd, ByteSource.Util.bytes(userName + "salt"), 2).toHex();

        //根据用户名从数据库获取密码
        User user = service.selectByUserName(userName).getData();
        String password = user.getPassword();

        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password)) {
            throw new AccountException("密码不正确");
        }

        return new SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes(userName + "salt"), getName());
    }

}
