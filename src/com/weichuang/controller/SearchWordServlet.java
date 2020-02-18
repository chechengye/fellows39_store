package com.weichuang.controller;


import com.alibaba.fastjson.JSON;
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

@WebServlet(name = "SearchWord" , urlPatterns = "/searchWord")
public class SearchWordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String word = req.getParameter("word");
        IProductService ps = new ProductService();
        List<Product> productList =  ps.getProductListByWord(word);
        System.out.println(productList.size());
        String jsonString = JSON.toJSONString(productList);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}