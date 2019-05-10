package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by:wisdom
 *
 * efect:成功之后返回状态及数组集合
 * **/
public final class JsonDomainArray<T> {

    /**
     * @data:返回数据
     * **/
    private List<T> data;

    /**
     * @success：是否成功
     * **/
    private boolean success;

    /**
     * @reason：描述
     * **/
    private String reason;

    /**
     * 接口返回状态
     * **/
    private String code;

    public JsonDomainArray(){
        reason = "ok";
        data = new ArrayList<>();
        success = true;
        code = "1111";
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
