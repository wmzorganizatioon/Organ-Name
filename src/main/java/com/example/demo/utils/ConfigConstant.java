package com.example.demo.utils;

/**
 * created by:wisdom
 *
 * effect:状态区域
 * **/
@Deprecated
public final class ConfigConstant {
    public ConfigConstant(){

    }

    public static final String DATA_SUCCESS_PRESENCE = "0000";     //数据成功返回“0000”        （默认的code状态是1111）

    public static final String DATA_FAIL_PRESENCE = "2222";   //数据不存在存在

    public static final String DATA_FAIL_NULL_PRESENCE = "3333";   //数据重复

    public static final String DATA_FAIL_EXPENCTION = "9999";      //异常
}
