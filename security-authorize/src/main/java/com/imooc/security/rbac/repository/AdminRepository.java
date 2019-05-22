package com.imooc.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.imooc.security.rbac.domain.Admin;

/**
 * AdminRepository
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:30
 */
@Repository
public interface AdminRepository extends ImoocRepository<Admin> {

    Admin findByUsername(String username);

}
