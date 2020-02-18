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

    public User login(String username, String password) {
        String sql = "select u.uid , u.username , u.name from user u where username = ? and password = ?";
        User user = null;
        try {
            user =  qr.query(sql , new BeanHandler<>(User.class) ,username , password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
