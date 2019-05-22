package com.imooc.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.imooc.security.rbac.domain.Resource;

/**
 * ResourceRepository
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:31
 */
@Repository
public interface ResourceRepository extends ImoocRepository<Resource> {

    Resource findByName(String name);

}
