package com.weichuang.dao;

import com.weichuang.pojo.Category;
import com.weichuang.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryDao {
    private QueryRunner qr;

    public CategoryDao(){
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }
    public List<Category> getCategoryList() {
        try {
            String sql = "select * from category";
            return qr.query(sql , new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
