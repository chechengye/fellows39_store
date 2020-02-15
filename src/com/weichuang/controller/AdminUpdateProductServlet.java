package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@WebServlet(name = "AdminUpdateProduct" , urlPatterns = "/adminUpdateProduct")
public class AdminUpdateProductServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        IProductService ps = new ProductService();
        Product product = new Product();
        try {
            BeanUtils.populate(product , req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int rows = ps.updateProductByPid(product);
        if(rows > 0){
            resp.sendRedirect(req.getContextPath() + "/adminProductList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}