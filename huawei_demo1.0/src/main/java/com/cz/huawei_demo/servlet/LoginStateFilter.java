package com.cz.huawei_demo.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
/**
 * 过滤器过滤未登录状态发起的请求
 * @author yingfeng
 * @date 2022/10/27 18:04
 */

@Slf4j
public class LoginStateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我filter到了");
        System.out.println(servletRequest.toString());
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");

    }
}
