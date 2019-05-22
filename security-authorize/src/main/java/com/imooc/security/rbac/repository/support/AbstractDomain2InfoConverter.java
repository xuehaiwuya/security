package com.imooc.security.rbac.repository.support;

import org.springframework.beans.BeanUtils;


/**
 * AbstractDomain2InfoConverter
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:15
 */
public abstract class AbstractDomain2InfoConverter<T, I> implements Domain2InfoConverter<T, I> {

    @Override
    public I convert(T domain) {
        I info = null;
        try {
            Class<I> clazz = GenericUtils.getGenericClass(getClass(), 1);
            info = clazz.newInstance();
            BeanUtils.copyProperties(domain, info);
            doConvert(domain, info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    protected abstract void doConvert(T domain, I info) throws Exception;

}
