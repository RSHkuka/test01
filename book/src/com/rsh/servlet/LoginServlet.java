package com.rsh.servlet;

import com.rsh.pojo.User;
import com.rsh.service.UserService;
import com.rsh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        response.setContentType("text/html charset=utf-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名和密码
        if (userService.login(new User(null,username,password,null))==null){
            System.out.println("登录失败");
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }else {
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
