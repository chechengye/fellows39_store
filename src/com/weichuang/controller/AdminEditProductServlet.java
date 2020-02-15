package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.ICategoryService;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.CategoryService;
import com.weichuang.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminEditProduct" , urlPatterns = "/adminEditProduct")
public class AdminEditProductServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        IProductService ps = new ProductService();
        ICategoryService cs = new CategoryService();
        String pid = req.getParameter("pid");
        Product product = ps.getProductById(pid);

        req.setAttribute("product" , product);
        req.setAttribute("categoryList" , cs.getCategoryList());
        req.getRequestDispatcher("/admin/product/edit.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}