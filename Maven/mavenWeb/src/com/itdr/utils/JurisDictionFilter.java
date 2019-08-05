package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Excellent吴
 * @date 2019-08-02 22:40
 */
@WebFilter(filterName = "JurisDictionFilter",value = "/manage/*")
public class JurisDictionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //乱码处理
        req.setCharacterEncoding("UTf-8");
        resp.setContentType("text/html;charset=utf-8");
        //统一数据返回对象
        ResponseCode rs=new ResponseCode();

        //转型，使用了类的更多方法
        HttpServletRequest request=(HttpServletRequest) req;
        //获取路径
        String pathInfo=request.getPathInfo();
        //判断是否登录，是登录直接放行
        if (pathInfo.equals("/login.do")){
            chain.doFilter(req, resp);
            return;
        }
        //其他请求处理
        //验证session是否有用户信息
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        if (user==null){
            rs.setStatus(3);
            rs.setMsg("请登录后此操作");
            resp.getWriter().write(rs.toString());
        }
        if (user.getType() !=1){
            rs.setStatus(3);
            rs.setMsg("没有操作权限！");
            resp.getWriter().write(rs.toString());
            return;
        }
        //没有问题就放行
        chain.doFilter(req,resp);
        return;


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
