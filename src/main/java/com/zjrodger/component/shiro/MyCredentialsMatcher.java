package com.zjrodger.component.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义比较规则
 */
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        // 获取用户前端传来的密码
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String passwordFromFrontEnd = new String(upToken.getPassword());

        // 获取从数据库中取出的密码
        String dbPassword = (String) info.getCredentials();

        // 定义自己的判断规则
        return passwordFromFrontEnd.equals(dbPassword);
    }
}
