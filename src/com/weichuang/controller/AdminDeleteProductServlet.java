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

@WebServlet(name = "AdminDeleteProduct" , urlPatterns = "/adminDeleteProduct")
public class AdminDeleteProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        IProductService ps = new ProductService();
        String pid = req.getParameter("pid");
        int rows = ps.deleteProductById(pid);
        if(rows > 0){
            resp.sendRedirect(req.getContextPath() + "/adminProductList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
