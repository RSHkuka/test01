package com.rsh.servlet;

import com.rsh.pojo.User;
import com.rsh.service.UserService;
import com.rsh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        response.setContentType("text/html charset=utf-8");
        //1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //判断验证码是否正确
        //正确
        if (code.equalsIgnoreCase("abcd")){
        //用户名是否存在
            if (userService.existsUserName(username)){
                System.out.println("用户名已存在");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }else {
            userService.registUser(new User(null,username,password,email));
            System.out.println("注册成功");
            request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            }
        }else {
        //错误
            System.out.println("验证码["+code+"]错误");
            //返回原来页面
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
