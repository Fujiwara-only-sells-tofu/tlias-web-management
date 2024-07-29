package com.wuyanzu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override //初始化的方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("初始化");
    }

    @Override //拦截到请求之后调用，调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("拦截成功-执行放行前的逻辑");
        //放行
        chain.doFilter(request,response);
        System.out.println("放行成功-执行放行后的逻辑");
    }

    @Override //销毁的方法，只会调用一次
    public void destroy() {
        System.out.println("销毁");
//        Filter.super.destroy();
    }
}
