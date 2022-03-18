package com.rsh.test;

import com.rsh.dao.UserDao;
import com.rsh.dao.impl.UserDaoImpl;
import com.rsh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUsername() {

        if(userDao.queryUsername("admin")==null) {
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryNameAndPassword() {

        if(userDao.queryNameAndPassword("admin","1234")==null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("查询成功！");
        }
    }

    @Test
    public void saveUser() {

        if(userDao.saveUser(new User(null,"rsh","1234","66@qq.com"))==-1){
            System.out.println("插入失败");
        }else {
            System.out.println("插入成功");
        };
    }
}