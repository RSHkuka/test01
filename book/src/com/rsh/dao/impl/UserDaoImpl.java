package com.rsh.dao.impl;

import com.rsh.dao.BaseDao;
import com.rsh.dao.UserDao;
import com.rsh.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUsername(String username) {
        String sql="select * from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryNameAndPassword(String username, String password) {
        String sql="select * from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        //String sql="insert into t_user('username','password','email') values (?,?,?)";
        //insert into t_user(`username`,`password`,`email`) values('admin','admin','admin@atguigu.com');
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
