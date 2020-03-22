package com.eyesfree.weibo.config.shiro;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eyesfree.weibo.entity.User;
import com.eyesfree.weibo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    /**
     * 认证(登录时调用)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", token.getUsername()));
        if(user == null){
            return null; // shiro底层会抛出UnknownAccountException
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), ""); // shiro会自动帮我们校验密码，如果密码错误会抛出AuthenticationException
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权处理逻辑。。。");
        return null;
    }

}

