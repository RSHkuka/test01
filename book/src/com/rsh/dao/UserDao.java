package com.rsh.dao;

import com.rsh.pojo.User;

public interface UserDao {

    //查询用户名
    /**
     *用户名
      * @param username 用户名
        * @return: com.rsh.pojo.User
        * @Author: rsh
        * @Date:2022/3/17 20:43
    **/
    public User queryUsername(String username);
    //查询用户名和密码
    /**
    *查询
        * @param username	用户名
        * @param password	密码
        * @return: com.rsh.pojo.User 失败返回空
        * @Author: rsh
        * @Date:2022/3/17 20:41
    **/
    public User queryNameAndPassword(String username,String password);
    //保存用户信息
    public int saveUser(User user);
}
