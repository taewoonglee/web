package com.playdata.todos.config;

import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.List;

//import static com.playdata.todos.servlet.UserServlet.list;

public class History {

    public static void setHistory(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        String requestURI = req.getRequestURI();
        String history = "history";
        int index = 0;
        if(cookies == null) {
            resp.addCookie(new Cookie(history + index , requestURI));
            return;
        }
        int max=0;
//        for (Cookie c : cookies) {
//            if(c.getName().contains(history))
//                index = Math.max(index, Integer.parseInt(
//                        c.getName().replace(history,"")
//                ));
//        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie c= cookies[i];
            if(c.getName().contains(history))
            {
                if(index<Integer.parseInt(c.getName().replace(history,"")))
                {
                    index=Integer.parseInt(c.getName().replace(history,""));
                }
                max=i;
            }
        }
        index++;
        if(!cookies[max].getValue().equals(requestURI))
        resp.addCookie(new Cookie(history + index , requestURI));

    }

    public static String back(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        System.out.println(cookies.length);
        String requestURI = req.getRequestURI();
        String history = "history";
        int index = 0;
        if(cookies == null) {
            return "-1";
        }
        int max=0;
//        for (Cookie c : cookies) {
//            if(c.getName().contains(history))
//                index = Math.max(index, Integer.parseInt(
//                        c.getName().replace(history,"")
//                ));
//        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie c= cookies[i];
            if(c.getName().contains(history))
            {
                if(index<Integer.parseInt(c.getName().replace(history,"")))
                {
                    index=Integer.parseInt(c.getName().replace(history,""));
                }
                max=i;
            }
        }
        index++;
        String requestURI2 = cookies[max-1].getValue();
        System.out.println(max-1);


        return requestURI2;
    }


}