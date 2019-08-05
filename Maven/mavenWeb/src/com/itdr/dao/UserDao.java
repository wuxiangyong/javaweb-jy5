package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-07-31 17:31
 */
public class UserDao {
    //查找所有用户
    public List<Users> selectAll(String pageSize, String pageNum) {
        // ComboPooledDataSource co= ;
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select*from users ";
        List<Users> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Users>(Users.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //根据姓名密码查找一个用户
    public Users selectOne(String username, String password) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select*from users where uname=?and pad=?";
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class), username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //根据id查找一个用户
    public Users selectOne(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "select*from users where id=?";
        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class), uid);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //根据id禁用一个用户

    public int updateByUid(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUTil.getCom());
        String sql = "update  users  set stats=1 where id=?";
        int row = 0;
        try {
            row = qr.update(sql, uid);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

}

