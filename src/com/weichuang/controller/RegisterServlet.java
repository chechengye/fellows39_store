package com.weichuang.controller;

import com.weichuang.pojo.User;
import com.weichuang.service.IProductService;
import com.weichuang.service.IUserService;
import com.weichuang.service.impl.ProductService;
import com.weichuang.service.impl.UserService;
import com.weichuang.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "Register" , urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        IUserService us = new UserService();
        User user = us.getUserByUserName(userName);

        if(user != null){
            resp.getWriter().write("此用户名已存在");
        }else{
            resp.getWriter().write("用户名可用");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
