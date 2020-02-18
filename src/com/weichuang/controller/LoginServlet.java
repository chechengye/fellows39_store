package com.weichuang.controller;

import com.weichuang.pojo.User;
import com.weichuang.service.IUserService;
import com.weichuang.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "Login" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        IUserService us = new UserService();
        User user = us.login(username , password);
        if(null != user){
            HttpSession session = req.getSession();
            Cookie cookie = new Cookie("JSESSIONID" , session.getId());
            cookie.setMaxAge(60 * 30);
            resp.addCookie(cookie);
            session.setAttribute("user" , user);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            req.setAttribute("loginInfo" , "用户名或密码错误!");
            req.getRequestDispatcher("/login.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}