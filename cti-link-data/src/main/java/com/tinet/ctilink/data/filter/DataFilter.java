package com.tinet.ctilink.data.filter;

import com.tinet.ctilink.util.ContextUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fengwei //
 * @date 16/6/15 09:59
 */
public class DataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //TODO 频度和访问限制

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
