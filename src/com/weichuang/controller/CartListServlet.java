package com.weichuang.controller;

import com.alibaba.fastjson.JSON;
import com.weichuang.pojo.CartProduct;
import com.weichuang.pojo.Product;
import com.weichuang.service.ICartService;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.CartService;
import com.weichuang.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartList" , urlPatterns = "/cartList")
public class CartListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        ICartService cs = new CartService();
        List<CartProduct> cartProductList = cs.getCartProductsByUid(req.getParameter("uid"));
        req.setAttribute("cartProductList" , cartProductList);
        System.out.println("cartProductList = " + cartProductList);
        req.getRequestDispatcher("/cart.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}