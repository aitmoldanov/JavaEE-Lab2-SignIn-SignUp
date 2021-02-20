package com.example.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class LogReqFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.servletContext.log("Logging");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        Enumeration<String> params = httpServletRequest.getParameterNames();

        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = httpServletRequest.getParameter(name);
            this.servletContext.log(httpServletRequest.getRemoteAddr() + name +value);
            System.out.println(httpServletRequest.getRemoteAddr() + name + value);
        }

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
                this.servletContext.log(httpServletRequest.getRemoteAddr());
                this.servletContext.log(cookie.getName());
                this.servletContext.log(cookie.getValue());
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
