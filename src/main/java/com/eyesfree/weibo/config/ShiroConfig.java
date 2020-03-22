package com.eyesfree.weibo.config;

import com.eyesfree.weibo.config.shiro.LoginRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 */
@Configuration
public class ShiroConfig {

    @Bean("securityManager")
    public SecurityManager securityManager(LoginRealm loginRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(loginRealm);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/regist", "anon");
        filterMap.put("/follow/**", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        //未登录页面
        shiroFilterFactoryBean.setLoginUrl("/unauthorized");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/forbidden");
        filterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }


}
