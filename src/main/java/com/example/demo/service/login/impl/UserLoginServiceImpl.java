package com.example.demo.service.login.impl;

import com.example.demo.dao.login.UserLoginRepository;
import com.example.demo.entity.user.User;
import com.example.demo.service.login.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public Integer SelectByUserNameCount(User user) {
        return userLoginRepository.queryByUserNameCount(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userLoginRepository.addUser(user);
    }
}
