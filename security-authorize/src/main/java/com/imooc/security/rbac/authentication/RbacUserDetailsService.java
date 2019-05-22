package com.imooc.security.rbac.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.security.rbac.domain.Admin;
import com.imooc.security.rbac.repository.AdminRepository;

/**
 * RbacUserDetailsService
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 10:31
 */
@Component
@Transactional
public class RbacUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名:" + username);
        Admin admin = adminRepository.findByUsername(username);
        admin.getUrls();
        return admin;
    }

}
