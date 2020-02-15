package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.ICategoryService;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.CategoryService;
import com.weichuang.service.impl.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AdminProductSave" , urlPatterns = "/adminProductSave")
public class AdminProductSaveServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Product product = new Product();
        IProductService ps = new ProductService();
        //封装product实体
        try {
            BeanUtils.populate(product , req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int rows = ps.saveProduct(product);
        if(rows > 0){
            resp.sendRedirect(req.getContextPath() + "/adminProductList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
