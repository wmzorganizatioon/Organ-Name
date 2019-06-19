package com.example.demo.common.enums;

import com.example.demo.common.annotation.BooleanAnnotation;

/**
 *@Author 86151
 *@date 2019/6/19 14:09
 *@description 简单的使用枚举
 *return
 */
public enum WeekEnum {
    SSUCCESSENUM("0000","数据正确",true),  //成功    -----------所以接口成功都是这个code
    NOTEXISTENUM("2222","账号不存在;接口名称:"),  //不存在
    REPEATENUM("3333","账户重复;接口名称:"),      //重复
    EXCPETIONENUM("9999","接口异常;接口名称:");      //异常

    private String value;

    private String content;

    @BooleanAnnotation()
    private boolean isRest;

    WeekEnum(String value, String content, boolean isRest) {
        this.value = value;
        this.content = content;
        this.isRest = isRest;
    }

    WeekEnum(String value, String content) {
        this.value = value;
        this.content = content;
    }

    public String getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }

    public boolean isRest() {
        return isRest;
    }
}
