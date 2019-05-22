package com.imooc.code;

import org.springframework.web.context.request.ServletWebRequest;

import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import com.imooc.security.core.validate.code.image.ImageCode;

/**
 * 自定义验证码生成器
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:05
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    /**
     * 新的验证码生成逻辑
     *
     * @param request
     * @return
     */
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }

}
