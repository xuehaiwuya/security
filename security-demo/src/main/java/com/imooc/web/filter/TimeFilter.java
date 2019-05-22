package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器拦截请求
 *
 * @author Leslie
 * @email panxiang_work@163.com
 * @create 2019/5/22 17:35
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("time filter start");

        long start = System.currentTimeMillis();
        chain.doFilter(request, response);

        System.out.println("time filter 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("time filter init");
    }

}
