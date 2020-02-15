package com.weichuang.controller;

import com.weichuang.pojo.Category;
import com.weichuang.service.ICategoryService;
import com.weichuang.service.impl.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryList" , urlPatterns = "/adminCategoryList")
public class AdminCategoryListServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        ICategoryService cs = new CategoryService();
        //访问分类表获取数据
        List<Category> categoryList = cs.getCategoryList();
        //放入域中，跳转页面
        req.setAttribute("categoryList" , categoryList);
        req.getRequestDispatcher("/admin/product/add.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
