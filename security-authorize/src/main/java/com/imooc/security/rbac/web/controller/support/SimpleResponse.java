package com.imooc.security.rbac.web.controller.support;

/**
 * SimpleResponse
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 13:57
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
