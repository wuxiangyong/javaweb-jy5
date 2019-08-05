package com.itdr.dao;

import com.itdr.pojo.Products;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-03 10:56
 */
public class ProductDao {
    //查找全部的商品信息
    public List<Products> selectAll(String pageSize, String pageNum) {

        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select*from products ";
        List<Products> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Products>(Products.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
