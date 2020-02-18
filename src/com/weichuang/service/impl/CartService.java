package com.weichuang.service.impl;

import com.weichuang.dao.CartDao;
import com.weichuang.pojo.Cart;
import com.weichuang.pojo.CartProduct;
import com.weichuang.service.ICartService;

import java.util.List;

public class CartService implements ICartService {
    private CartDao cartDao;

    public CartService(){
        cartDao = new CartDao();
    }

    /**
     * 保存数据到购物车
     * @param cart
     * @return
     */
    @Override
    public int saveCart(Cart cart) {
        return cartDao.saveCart(cart);
    }

    /**
     * 查询购物车中是否存在重复商品
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public Cart findCartByUidAndPid(String uid, String pid) {
        return cartDao.findCartByUidAndPid(uid , pid);
    }

    /**
     * 更新操作
     * @param oldCart
     * @return
     */
    @Override
    public int updateCart(Cart oldCart) {
        return cartDao.updateCart(oldCart);
    }

    /**
     * 根据用户id获取他的购物车列表
     * @param uid
     * @return
     */
    @Override
    public List<CartProduct> getCartProductsByUid(String uid) {
        return cartDao.getCartProductsByUid(uid);
    }
}
