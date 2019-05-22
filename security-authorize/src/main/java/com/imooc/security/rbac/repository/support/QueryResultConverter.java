package com.imooc.security.rbac.repository.support;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * QueryResultConverter
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 11:20
 */
@Slf4j
public class QueryResultConverter {

    /**
     * @param pageData
     * @param clazz
     * @param pageable
     * @return
     */
    public static <T, I> Page<I> convert(Page<T> pageData, Class<I> clazz, Pageable pageable) {
        List<T> contents = pageData.getContent();
        List<I> infos = convert(contents, clazz);
        return new PageImpl<>(infos, pageable, pageData.getTotalElements());
    }

    public static <I, T> List<I> convert(List<T> contents, Class<I> clazz) {
        List<I> infos = Lists.newArrayList();
        for (T domain : contents) {
            I info = null;
            try {
                info = clazz.newInstance();
                BeanUtils.copyProperties(info, domain);
            } catch (Exception e) {
                log.info("转换数据失败", e);
                throw new RuntimeException("转换数据失败");
            }
            if (info != null) {
                infos.add(info);
            }
        }
        return infos;
    }

    /**
     * @param pageData
     * @param pageable
     * @param converter
     * @return
     */
    public static <T, I> Page<I> convert(Page<T> pageData, Pageable pageable, Domain2InfoConverter<T, I> converter) {
        List<T> contents = pageData.getContent();
        List<I> infos = convert(contents, converter);
        return new PageImpl<>(infos, pageable, pageData.getTotalElements());
    }

    public static <I, T> List<I> convert(List<T> contents, Domain2InfoConverter<T, I> converter) {
        List<I> infos = Lists.newArrayList();
        for (T domain : contents) {
            infos.add(converter.convert(domain));
        }
        return infos;
    }


}
