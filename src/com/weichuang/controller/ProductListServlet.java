package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制层，实现商品列表功能。url地址不要忘记/
 */
@WebServlet(name = "ProductList" , urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        IProductService ps = new ProductService();
        List<Product> productList = ps.getProductList();
        System.out.println(productList.size());
        req.setAttribute("productList" , productList);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
