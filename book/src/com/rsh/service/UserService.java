package com.rsh.service;

import com.rsh.pojo.User;

public interface UserService {

    //用户注册

    public void registUser(User user);

    //用户登录
    /*
            * @Param: [user]
            * @return: 登录失败返回null
            * @Author: rsh
            * @Date:2022/3/17 16:04
     */
    public User login(User user);

    //判断用户名
    /*
            * @Param: [username]
            * @return: 是否存在
            * @Author: rsh
            * @Date:2022/3/17 15:54
     */ 
    public boolean existsUserName(String username);
}
