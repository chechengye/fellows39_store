package com.weichuang.dao;

import com.weichuang.pojo.Product;
import com.weichuang.utils.C3P0Utils;
import com.weichuang.vo.Condition;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "select p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice  ,  p.pimage , p.pdesc , p.cid from product p where pid = ?";
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

    public int saveProduct(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        int rows = -1;
        try {
            rows = qr.update(sql , product.getPid() , product.getPname() , product.getMarketPrice()
                    , product.getShopPrice() , product.getPimage() , product.getPdate()
                    , product.getIsHot() , product.getPdesc() , product.getPflag() , product.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int updateProductByPid(Product product) {
        String sql = "update product set pname = ? , market_price = ? , shop_price = ? , pdate = ? , is_hot = ? , cid = ? where pid = ?";
        int rows = -1;
        try {
            rows = qr.update(sql , product.getPname() , product.getMarketPrice()
                    , product.getShopPrice(),product.getPdate() , product.getIsHot() , product.getCid() , product.getPid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public List<Product> getProductListByCondition(Condition condition) {
        String sql = "select p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice  ,  p.pimage , p.pdesc , p.cid , p.is_hot as isHot from product p where 1=1 ";
        //模糊查询有三种方式 like %name% 完全匹配 、%name 以name结尾的  、name% 以name开头的
        List<Object> list = new ArrayList<>();
        if(null != condition.getPname() && !condition.getPname().equals("")){
            sql += " and p.pname like ? ";
            list.add("%" + condition.getPname() + "%");
        }
        if(condition.getIsHot() != -1){
            sql += " and p.is_hot = ? ";
            list.add( condition.getIsHot());
        }
        if(null != condition.getCid() && !condition.getCid().equals("")){
            sql += " and p.cid = ? ";
            list.add( condition.getCid());
        }
        try {
            return qr.query(sql , new BeanListHandler<>(Product.class) , list.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
