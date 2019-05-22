package com.imooc.service.impl;

import org.springframework.stereotype.Service;

import com.imooc.service.HelloService;

/**
 * HelloServiceImpl
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 16:51
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }

}
