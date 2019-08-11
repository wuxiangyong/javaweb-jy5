package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Orders;
import com.itdr.utils.PropertiesGetUTil;

import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-09 10:13
 */
public class OrderService {
    OrderDao od = new OrderDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        Integer s = null;
        Integer n = null;
        //进行非空判断
        if(pageSize == null || pageSize.equals("")){
            pageSize = "10";
            s = Integer.parseInt(pageSize);
        }
        if(pageNum == null || pageNum.equals("")){
            pageNum = "1";
            n = Integer.parseInt(pageNum);
       }

        List<Orders> li = od.selectAll(s,n);
        //如果集元素是空呢？

        ResponseCode rs = new ResponseCode();
        rs = ResponseCode.successRs(li);
        return rs;
    }

    //查找订单
    public ResponseCode selectOne(String orderId) {
        Long orderid = Long.parseLong(orderId);
        ResponseCode rs = new ResponseCode();
        Orders or = od.selectOne(orderid);
        if(or!= null){
            rs  = ResponseCode.successRs(or);
            return rs;
        }
        rs  = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("ORDER_SELECT_FAIL")),
                PropertiesGetUTil.getValue("ORDER_SELECT_FAIL_MSG"));
        return rs;
    }

    //订单发货
    public ResponseCode updateNo(String orderId) {
        ResponseCode rs = new ResponseCode();
        Long orderid = Long.parseLong(orderId);
        int i  = od.updateNo(orderid);
        if(i != 0){
            rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("ORDER_UPDATE_SUCCESS")),
                    PropertiesGetUTil.getValue("ORDER_UPDATE_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("ORDER_UPDATE_FAIL")),
                PropertiesGetUTil.getValue("ORDER_UPDATE_FAIL_MSG"));
        return rs;
    }
}
