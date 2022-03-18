package com.rsh.service.impl;

import com.rsh.dao.UserDao;
import com.rsh.dao.impl.UserDaoImpl;
import com.rsh.pojo.User;
import com.rsh.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUserName(String username) {
        if(userDao.queryUsername(username)==null){
            return false;
        }
        return true;
    }
}
