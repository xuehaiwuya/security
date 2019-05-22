package com.imooc.security.core.support;

/**
 * 简单响应的封装类
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 15:05
 */
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
