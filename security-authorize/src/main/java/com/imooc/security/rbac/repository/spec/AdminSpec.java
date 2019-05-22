package com.imooc.security.rbac.repository.spec;

import com.imooc.security.rbac.domain.Admin;
import com.imooc.security.rbac.dto.AdminCondition;
import com.imooc.security.rbac.repository.support.ImoocSpecification;
import com.imooc.security.rbac.repository.support.QueryWraper;

/**
 * AdminSpec
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:01
 */
public class AdminSpec extends ImoocSpecification<Admin, AdminCondition> {

    public AdminSpec(AdminCondition condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Admin> queryWraper) {
        addLikeCondition(queryWraper, "username");
    }

}
