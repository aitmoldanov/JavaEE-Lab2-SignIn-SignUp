package com.example.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReqFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig){
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestURL = httpServletRequest.getRequestURI();
        this.servletContext.log(requestURL);

        HttpSession session = httpServletRequest.getSession(false);

        if (session == null && requestURL.endsWith("SignInServlet") ||  !(requestURL.endsWith("jsp") || requestURL.endsWith("SignUpServlet"))) {
            httpServletResponse.sendRedirect("signIn.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
