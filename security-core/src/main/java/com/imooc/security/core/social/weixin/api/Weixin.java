package com.imooc.security.core.social.weixin.api;

/**
 * 微信API调用接口
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 14:52
 */
public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);

}
