package com.rsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ResponseIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方法一
        //设置服务器端的字符相应编码
//        response.setCharacterEncoding("UTF-8");
        //设置相应头 使浏览器端字符集改变
//        response.setHeader("Content-Type","text/html charset=UTF-8");
        //方法二 同时设置服务器端和浏览器端的字符集 还设置了相应头
        response.setContentType("text/html charset=UTF-8");
        PrintWriter writer=response.getWriter();
        writer.print("你好！");
    }
}
