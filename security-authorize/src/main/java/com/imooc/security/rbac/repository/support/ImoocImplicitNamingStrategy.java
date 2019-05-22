package com.imooc.security.rbac.repository.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 * ImoocImplicitNamingStrategy
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:30
 */
public class ImoocImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    private static final long serialVersionUID = 769122522217805485L;

    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier("imooc_" + stringForm.toLowerCase(), buildingContext);
    }

}
