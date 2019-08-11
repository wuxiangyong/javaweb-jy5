package com.itdr.dao;

import com.itdr.pojo.Categorys;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-09 10:30
 */
public class CategoryDao {
    QueryRunner qr = new QueryRunner(PoolUTil.getCom());
    //按catepory查询
    public List<Categorys> selectCategory(Integer category) {
        String sql = "select* from category where cparentId = ?" ;
        List<Categorys> li  = null;
        try {
            li = qr.query(sql,new BeanListHandler<Categorys>(Categorys.class),category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //增加节点
    public int addCategory(Integer id, String categoryName) {
        String sql = "insert into category values(null,?,?,null,null,now(),now())";
        int a = 0;
        try {
            a = qr.update(sql,id,categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //修改他的子节点
    public int setCategoryName(Integer id, String categoryName) {
        String sql = "update category set c_name＝? where c_id=?";
        int a = 0;
        try {
            a = qr.update(sql,categoryName,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
