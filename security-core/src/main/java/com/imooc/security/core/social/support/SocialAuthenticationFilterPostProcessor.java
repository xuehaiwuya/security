package com.imooc.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * 社交认证过滤器后处理器
 * SocialAuthenticationFilter后处理器，用于在不同环境下个性化社交登录的配置
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 14:49
 */
public interface SocialAuthenticationFilterPostProcessor {

    /**
     * @param socialAuthenticationFilter
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
