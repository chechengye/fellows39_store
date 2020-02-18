package com.weichuang.controller;


import com.weichuang.pojo.Cart;
import com.weichuang.service.ICartService;
import com.weichuang.service.impl.CartService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "CartSave" , urlPatterns = "/cartSave")
public class CartSaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Cart cart = new Cart();
        ICartService cs = new CartService();
        int rows = -1;
        try {
            BeanUtils.populate(cart , req.getParameterMap());
            Cart oldCart = cs.findCartByUidAndPid(cart.getUid() , cart.getPid());
            if(oldCart != null){
                oldCart.setCount(oldCart.getCount() + cart.getCount());
                rows = cs.updateCart(oldCart);

            }else{
                rows = cs.saveCart(cart);
            }
            if(rows > 0){
                resp.getWriter().write("添加购物车成功！");
            }else{
                resp.getWriter().write("添加购物车失败！");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}