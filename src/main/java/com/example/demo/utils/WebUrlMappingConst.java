package com.example.demo.utils;

/**
 * created by:wisdom
 *
 * effect:视图调接口区域
 * **/
public class WebUrlMappingConst {
    public WebUrlMappingConst() {

    }

    /**
     * ①用户登录、注册区域
     * **/
    public static final String URL_USER = "/user/";

    //登录
    public static final String URL_USER_LOGIN = URL_USER + "login";

    //注册
    public static final String URL_USER_REGISTERED = URL_USER + "registered";

    //忘记密码
    public static final String URL_USER_FORGETPASSWORD = URL_USER + "forgetpassword";

    //获取验证码
    public static final String URL_USER_GET_CODE = URL_USER + "getCode";


    /**
     *②菜单模块
     */
    public static final String URL_MEUN = "/meun/";

    //获取所有菜单
    public static final String URL_MEUN_GET_ALL_MEUNS = URL_MEUN + "get/meuns";
}
