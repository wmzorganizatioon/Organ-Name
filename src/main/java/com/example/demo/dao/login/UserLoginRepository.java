package com.example.demo.dao.login;

import com.example.demo.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginRepository {

    Integer queryByUserNameCount(User user);
}
