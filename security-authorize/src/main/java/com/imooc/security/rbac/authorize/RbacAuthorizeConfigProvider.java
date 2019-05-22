package com.imooc.security.rbac.authorize;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.imooc.security.core.authorize.AuthorizeConfigProvider;

/**
 * RbacAuthorizeConfigProvider
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 10:34
 */
@Component
@Order
public class RbacAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers(HttpMethod.GET, "/fonts/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/*.html", "/admin/me", "/resource")
                .authenticated()
                .anyRequest()
                .access("@rbacService.hasPermission(request, authentication)");
        return true;
    }

}
