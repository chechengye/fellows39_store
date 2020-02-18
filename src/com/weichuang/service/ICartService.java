package com.weichuang.service;

import com.weichuang.pojo.Cart;
import com.weichuang.pojo.CartProduct;

import java.util.List;

public interface ICartService {
    int saveCart(Cart cart);

    Cart findCartByUidAndPid(String uid, String pid);

    int updateCart(Cart oldCart);

    List<CartProduct> getCartProductsByUid(String uid);
}
