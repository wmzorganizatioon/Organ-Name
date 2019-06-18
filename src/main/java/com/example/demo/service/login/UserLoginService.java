package com.example.demo.service.login;

import com.example.demo.entity.user.User;

public interface UserLoginService {

    /**
     *@userName：
     * 通过userName查询用户
     * **/
    Integer SelectByUserNameCount(User user);

    /**
     *@Author 86151
     *@Date 2019/6/18 9:20
     *Description 注册
     @Param
     *return
     */
    Integer insertUser(User user);
}
