package com.imooc.security.app;

/**
 * AppSecretException
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 9:53
 */
public class AppSecretException extends RuntimeException {

    private static final long serialVersionUID = -1629364510827838114L;

    public AppSecretException(String msg) {
        super(msg);
    }

}
