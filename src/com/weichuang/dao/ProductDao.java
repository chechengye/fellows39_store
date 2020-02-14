package com.weichuang.dao;

import com.weichuang.pojo.Product;
import com.weichuang.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * 数据库访问层
 */
public class ProductDao {
    private QueryRunner qr;
    public ProductDao(){
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }
    public List<Product> getProductList() {
        //不建议直接写*
        String sql = "select p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice  ,  p.pimage , p.is_hot as isHot from product p";
        try {
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Product getProductById(String pid) {
        String sql = "select p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice  ,  p.pimage , p.pdesc from product p where pid = ?";
        Product product = new Product();
        try {
            product = qr.query(sql, new BeanHandler<>(Product.class), pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public int deleteProductById(String pid) {
        String sql = "delete from product where pid = ?";
        try {
            int rows = qr.update(sql , pid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
