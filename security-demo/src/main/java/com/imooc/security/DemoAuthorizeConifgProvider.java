package com.imooc.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.imooc.security.core.authorize.AuthorizeConfigProvider;

/**
 * DemoAuthorizeConifgProvider
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:46
 */
@Component
public class DemoAuthorizeConifgProvider implements AuthorizeConfigProvider {

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        //demo项目授权配置
        //config.antMatchers("/demo.html").hasRole("ADMIN");
        //config.anyRequest().access("@rbacService.hasPermission(request,authentication)");
        //return true;
        return false;
    }

}
