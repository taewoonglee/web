package com.playdata.todos.servlet;

import com.playdata.todos.config.History;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ret = History.back(req,resp);

        if(ret=="-1")
        {
            resp.sendRedirect("/login");
        }
        else {
            resp.sendRedirect(ret);
        }
    }
}
