package com.Ha_rlan.vueshoppingback.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ajaxFilter",urlPatterns = "/*")
public class AjaxFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","http//localhost:8081");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","POST, GET, DELETE, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Origin","Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request,response);
    }
}
