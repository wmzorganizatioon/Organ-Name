package com.example.demo.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.user.User;

/**
 *@Author 86151
 *@date 2019/7/7 11:06
 *@description token 的通用方法
 *return
 */
public class LoginTicketToken {

    /**
     *@Author 86151
     *@Date 2019/7/7 11:07
     *Description 未登陆加个token令牌，以防止未登陆
     @Param
     *return
     */
    public String addLoginToken(User user){
        String token = "";
        //token = JWT.create().withAudience(String.valueOf(user.getId())).sign(Algorithm.HMAC256(user.getPassword()));
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));

        return token;
    }
}
