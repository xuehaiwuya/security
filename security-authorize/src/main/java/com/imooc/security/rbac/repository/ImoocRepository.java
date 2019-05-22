package com.imooc.security.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * ImoocRepository
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:31
 */
@NoRepositoryBean
public interface ImoocRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
