package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.ProductService;
import com.weichuang.vo.PageBean;

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
        //从前端获取当前页
        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        //从前端获取每页最大数
        int maxCount = 12;

        IProductService ps = new ProductService();
        PageBean pageBean = ps.getPageBeanByCurrentPageAndMaxCount(currentPage , maxCount);
        System.out.println(pageBean);
        req.setAttribute("pageBean" , pageBean);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
