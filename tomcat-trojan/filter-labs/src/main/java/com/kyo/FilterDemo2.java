package com.kyo;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("hello FilterDemo2\n");
        response.getWriter().flush();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
