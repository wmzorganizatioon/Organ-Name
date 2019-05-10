package com.example.demo.service.login;

import com.example.demo.entity.user.User;

public interface UserLoginService {

    /**
     *@userName：
     * 通过userName查询用户
     * **/
    Integer SelectByUserNameCount(User user);
}
