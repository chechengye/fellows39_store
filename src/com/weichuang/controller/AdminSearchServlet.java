package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.ICategoryService;
import com.weichuang.service.IProductService;
import com.weichuang.service.impl.CategoryService;
import com.weichuang.service.impl.ProductService;
import com.weichuang.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "AdminSearch" , urlPatterns = "/adminSearch")
public class AdminSearchServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        IProductService ps = new ProductService();
        ICategoryService cs = new CategoryService();
        Condition condition = new Condition();
        try {
            BeanUtils.populate(condition , req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("condition = " + condition);
        List<Product> productList =  ps.getProductListByCondition(condition);
        System.out.println("productList = " + productList);
        req.setAttribute("productList" , productList);
        req.setAttribute("condition" , condition);
        req.setAttribute("categoryList" , cs.getCategoryList());
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
