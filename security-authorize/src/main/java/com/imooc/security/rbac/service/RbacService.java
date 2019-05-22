package com.imooc.security.rbac.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * RbacService
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 13:54
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
