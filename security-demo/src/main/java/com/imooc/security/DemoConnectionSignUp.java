package com.imooc.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * 配置ConnectionSignUp实现类
 * <p>
 * 实现用户使用第三方登录完默认注册一个用户并登录
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:48
 */
//@Component
public class DemoConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }

}
