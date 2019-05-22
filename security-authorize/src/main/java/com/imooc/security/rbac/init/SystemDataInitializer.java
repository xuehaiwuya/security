package com.imooc.security.rbac.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * 系统初始化器
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 10:51
 */
@Component
@Slf4j
public class SystemDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 系统中所有的{@link DataInitializer}接口实现
     */
    @Autowired(required = false)
    private List<DataInitializer> dataInitializers;

    /**
     * 循环调用系统中所有的{@link DataInitializer}
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (CollectionUtils.isNotEmpty(dataInitializers)) {
            /**
             * <p>
             * Comparator.comparing(DataInitializer::getIndex) 代码实现的功能等同于:
             * dataInitializers.sort((initor1, initor2) -> {return initor1.getIndex().compareTo(initor2.getIndex());});
             */
            dataInitializers.sort(Comparator.comparing(DataInitializer::getIndex));

            dataInitializers.stream().forEach(dataInitializer -> {
                try {
                    dataInitializer.init();
                } catch (Exception e) {
                    log.info("系统数据初始化失败(" + dataInitializer.getClass().getSimpleName() + ")", e);
                }
            });
        }
    }

}
