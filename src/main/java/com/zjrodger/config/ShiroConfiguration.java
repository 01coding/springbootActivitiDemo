package com.zjrodger.config;


import com.zjrodger.component.shiro.MyCredentialsMatcher;
import com.zjrodger.component.shiro.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    // 5.配置shiro与spring集成相关内容
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


    // 4.配置shiroFilter，将SecurityManager注入到shiroFilter中
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        // 设置shiroFilter要使用的securityManager
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauthorized");

        // 配置shiro的过滤规则
        Map<String, String> map = new HashMap<>();
        // 配置shiro不拦截的URL资源
        map.put("/login", "anon");
        map.put("/druid/**", "anon");

//        map.put("/index", "authc");
        map.put("/**", "authc");  // 对所有请求都需要验证
        factoryBean.setFilterChainDefinitionMap(map);

        return factoryBean;
    }

    // 3.配置SecurityManager，将Realm注入到SecurityManager
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }


    // 2.配置Realm，将CredentialsMatcher注入到Realm
    @Bean("myRealm")
    public MyRealm myRealm(@Qualifier("myCredentialsMatcher") MyCredentialsMatcher myCredentialsMatcher) {
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(myCredentialsMatcher);
        return realm;
    }

    // 1.配置CredentialsMatcher，负责登录定义身份校验的规则，比如密码相等用户名相等
    @Bean("myCredentialsMatcher")
    public MyCredentialsMatcher myCredentialsMatcher() {
        MyCredentialsMatcher matcher = new MyCredentialsMatcher();
        return matcher;
    }

}
