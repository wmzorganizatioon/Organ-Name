package com.example.demo.utils;

/**
 * created by:wisdom
 *
 * efect:成功之后返回状态
 * **/
public final class JsonResponseValue {

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

    public JsonResponseValue() {
        reason = "ok";
        success = true;
        code = "1111";
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
