package com.eyesfree.weibo.config.shiro;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

import java.io.Serializable;

public class LoginToken implements HostAuthenticationToken, RememberMeAuthenticationToken, Serializable {


    private String empSn;
    private String host;

    /**
     * 重写getPrincipal方法
     */
    @Override
    public Object getPrincipal() {
        return empSn;
    }

    /**
     * 重写getCredentials方法
     */
    @Override
    public Object getCredentials() {
        return empSn;
    }


    public LoginToken(String empSn) { this(empSn, false, null); }

    public LoginToken(String empSn, boolean rememberMe) { this(empSn, rememberMe, null); }

    public LoginToken(String empSn, boolean rememberMe, String host) {
        this.empSn = empSn;
        this.host = host;
    }

    public String getPhone() {
        return empSn;
    }

    public void setPhone(String empSn) {
        this.empSn = empSn;
    }

    @Override
    public String getHost() {
        return host;
    }


    @Override
    public boolean isRememberMe() {
        return false;
    }
}
