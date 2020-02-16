package com.weichuang.dao;

import com.weichuang.pojo.User;
import com.weichuang.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr;
    public UserDao(){
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }
    public User getUserByUserName(String userName) {
        String sql = "select u.username from user u where u.username = ?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
