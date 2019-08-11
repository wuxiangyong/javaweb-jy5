package com.itdr.dao;

import com.itdr.pojo.Orders;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-09 10:12
 */
public class OrderDao {
    public List<Orders> selectAll(Integer s, Integer n) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from orders limit ?,?";
        List<Orders> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Orders>(Orders.class),n,s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Orders selectOne(Long orderid) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select * from orders where o_orderNo = ?";
        Orders od = null;
        try {
            od = qr.query(sql,new BeanHandler<Orders>(Orders.class),orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return od;
    }

    public int updateNo(Long orderid) {
        QueryRunner qr =new QueryRunner(PoolUTil.getCom());
        String sql = "update orders set o_sendTime = now() where o_orderNo = ?";
        int i = 0;
        try {
            i = qr.update(sql,orderid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
