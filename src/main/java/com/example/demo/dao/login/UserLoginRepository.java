package com.example.demo.dao.login;

import com.example.demo.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginRepository {

    Integer queryByUserNameCount(User user);

    /**
     *@Author 86151
     *@Date 2019/6/18 9:22
     *Description 注册
     @Param
     *return
     */
    Integer addUser(User user);
}
