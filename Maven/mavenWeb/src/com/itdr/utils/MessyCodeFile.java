package com.itdr.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Excellent吴
 * @date 2019-08-01 15:55
 */
@WebFilter(filterName = "MessyCodeFile" ,value="/manage/* ")
public class MessyCodeFile implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("UTf-8");
        resp.setContentType("text/html;charset=utf-8");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
