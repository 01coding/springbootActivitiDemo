package com.zjrodger.component.shiro;

import com.zjrodger.modules.system.entity.User;
import com.zjrodger.modules.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangjian
 * @create 2018-08-16
 */
@Component
public class MyRealm extends AuthorizingRealm {

    private final static Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 权限校验
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 查询用户是否存在
        User user = userService.findByUsername(upToken.getUsername());
        if(null == user){
            throw new AuthenticationException("用户不存在");
        }

        // 获取用户的权限
        SimpleAuthenticationInfo sainfo=new SimpleAuthenticationInfo();
        return sainfo;
    }
}
