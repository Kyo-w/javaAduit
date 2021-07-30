package com.kyo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class hello extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletConfig().getServletContext();
//        context.addFilter("", "");
//        此代码如果不注释，系统会报错，所以只适合debug使用，了解内部原理。
        resp.getWriter().write("Hello World");
        resp.getWriter().flush();
        System.out.println("Hello World");
    }
}