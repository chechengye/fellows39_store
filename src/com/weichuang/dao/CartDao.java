package com.weichuang.dao;

import com.weichuang.pojo.Cart;
import com.weichuang.pojo.CartProduct;
import com.weichuang.pojo.Product;
import com.weichuang.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CartDao {
    private QueryRunner qr;

    public CartDao(){
        qr = new QueryRunner(C3P0Utils.getDataSource());
    }
    public Cart findCartByUidAndPid(String uid, String pid) {
        String sql = "select * from t_cart c where c.uid = ? and c.pid = ?";
        Cart cart = null;
        try {
            cart = qr.query(sql , new BeanHandler<>(Cart.class), uid  , pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    public int saveCart(Cart cart) {
        String sql = "insert into t_cart values(null , ? , ? ,?)";
        try {
            int rows = qr.update(sql, cart.getUid(), cart.getPid(), cart.getCount());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateCart(Cart oldCart) {
        String sql = "update t_cart set count = ? where id = ?";
        try {
            int rows = qr.update(sql, oldCart.getCount() , oldCart.getId());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<CartProduct> getCartProductsByUid(String uid){
        String sql = "select p.pimage , p.pname , p.shop_price as shopPrice, c.id , c.count from t_cart c INNER JOIN product p on c.pid = p.pid where c.uid = ?";
        try {
            List<CartProduct> cartProductList = qr.query(sql, new BeanListHandler<>(CartProduct.class), uid);
            return cartProductList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
