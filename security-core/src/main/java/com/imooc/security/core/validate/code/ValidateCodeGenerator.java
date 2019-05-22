package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:02
 */
public interface ValidateCodeGenerator {

    /**
     * 图形验证码实现方法接口
     *
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);

}
