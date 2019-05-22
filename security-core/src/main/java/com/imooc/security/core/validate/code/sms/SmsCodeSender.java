package com.imooc.security.core.validate.code.sms;

/**
 * 短信发送接口
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 15:12
 */
public interface SmsCodeSender {

    /**
     * 发送方法
     *
     * @param mobile 手机号
     * @param code   验证码
     */
    void send(String mobile, String code);

}
