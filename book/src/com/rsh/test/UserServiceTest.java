package com.rsh.test;

import com.rsh.dao.UserDao;
import com.rsh.pojo.User;
import com.rsh.service.UserService;
import com.rsh.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"qq","1234","123@qq.com"));
    }

    @Test
    public void login() {
        userService.login(new User(null,"qq","1234",null));
    }

    @Test
    public void existsUserName() {
        if (userService.existsUserName("qq")){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}