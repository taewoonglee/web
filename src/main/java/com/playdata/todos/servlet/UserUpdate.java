package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/userupdate.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//       UserDao userDao = new UserDao();
        User user = new UserDao().login(username,password);
//        String name = user.getName();
//        String pw = user.getPassword();
        int id = user.getId();
        String password2 = req.getParameter("password2");
        String name2 = req.getParameter("name");
        new UserDao().chanege(password2,name2,id);
        resp.sendRedirect("/user");
    }
}
