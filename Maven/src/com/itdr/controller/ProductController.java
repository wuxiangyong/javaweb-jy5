package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductService;
import com.itdr.utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Excellent吴
 * @date 2019-08-03 15:46
 */
@WebServlet("/manage/product/*")
public class  ProductController extends HttpServlet {
    static ProductService ps = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //怎么获得请求路径
        String pathInfo = request.getPathInfo();
        String path = PathUTil.getPath(pathInfo);
        //返回统一对象
        ResponseCode rs = null;

        //判断需要什么样的请求
        switch (path) {
            case "list":
                rs = listDo(request);
                break;
            case "search":
                rs = searchDo(request);
                break;

            case "detail":
                rs = detailDo(request);
                break;
            case "set_sale_status":
                rs = set_sale_statusDo(request);
                break;
            case "update":
                rs = updateDo(request);
                break;

        }
        //返回相应数据
        response.getWriter().write(rs.toString());
    }

    //获取所有商品的的请求
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rs = new ResponseCode();
//        if (product.getType()!=1){
//            rs.setStatus(3);
//            rs.setMsg("账号或者密码错误");
//            return  rs;
//        }
        //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");

        rs = ps.selectAll(pageSize, pageNum);

        //调用业务处理的业务

        return rs;
    }

    //搜索商品的请求根据他的产品名和产品号来搜索
    private ResponseCode searchDo(HttpServletRequest request) {
        ResponseCode rs = new ResponseCode();
        //获取参数
        String pname = request.getParameter("pname");
        String pid = request.getParameter("pid");
        rs = ps.selectOne(pname,pid);
        return rs;
    }
     //商品详情根据商品的id号来查询他的详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        ResponseCode rs =  new ResponseCode();
        rs = ps.selectOneAll(pid);
        return rs ;
    }
    //
    //产品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        String status = request.getParameter("status");
        ResponseCode rs =  ps.updateOne(pid,status);
        return rs ;
    }

    //更新或添加产品
    private ResponseCode updateDo(HttpServletRequest request) {
        String id = request.getParameter("id");
        String categoryid = request.getParameter("categoryid");
        String gname = request.getParameter("gname");
        String subtitle = request.getParameter("subtitle");
        String mainImage = request.getParameter("mainImage");
        String status = request.getParameter("status");
        String price = request.getParameter("price");
        ResponseCode rs =  ps.updateAddOne(id,categoryid,gname,subtitle,mainImage,
                status,price);
        return rs ;
    }
}