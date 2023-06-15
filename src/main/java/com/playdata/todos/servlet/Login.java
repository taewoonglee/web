package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.html").forward(req,resp);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();


        if(userDao.login(username,password))
        {
            System.out.println("로그인");
            resp.sendRedirect("/main");
        }
        else {
            System.out.println("실패");
            resp.sendRedirect("/user");
        }
    }
}
