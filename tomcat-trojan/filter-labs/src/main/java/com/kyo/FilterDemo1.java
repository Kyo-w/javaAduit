package com.kyo;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("hello FilterDemo1\n");
        response.getWriter().flush();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
