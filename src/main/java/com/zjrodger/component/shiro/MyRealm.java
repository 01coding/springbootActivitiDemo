package com.zjrodger.component.shiro;

import com.zjrodger.modules.system.entity.Permission;
import com.zjrodger.modules.system.entity.Role;
import com.zjrodger.modules.system.entity.User;
import com.zjrodger.modules.system.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhangjian
 * @create 2018-08-16
 */
@Component
public class MyRealm extends AuthorizingRealm {

    private final static Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 权限校验
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();

        List<String> permissionSet = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(CollectionUtils.isNotEmpty(roles)){
            for(Role role : roles){
                Set<Permission> permissions = role.getPermissions();
                if(CollectionUtils.isNotEmpty(permissions)){
                    for(Permission p : permissions){
                        permissionSet.add(p.getPname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo saorInfo = new SimpleAuthorizationInfo();
        saorInfo.addStringPermissions(permissionSet);
        return saorInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 查询用户是否存在
        User user = userService.findByUsername(upToken.getUsername());
        if (null == user) {
            throw new AuthenticationException("用户不存在");
        }
        SimpleAuthenticationInfo sainfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
        return sainfo;
    }


//    public static void main(String[] args) {
//        MyRealm m = new MyRealm();
//        System.out.println(m.getClass().getName());
//    }
}
