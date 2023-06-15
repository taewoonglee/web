package com.playdata.todos.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        req.getRequestDispatcher("views/user.html").forward(req,resp);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        System.out.println(username);
        System.out.println(password);
        System.out.println(name);
        resp.setStatus(201);
        resp.sendRedirect("/user");  //여기서 다음페이지로 넘어감
        //super.doPost(req, resp);
    }
}
