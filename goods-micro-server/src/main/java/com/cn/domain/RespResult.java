package com.cn.domain;

public class RespResult<T> {

    private T data;
    private String message;
    private Integer code;

    public RespResult() {
    }

    public RespResult(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public RespResult(String message, Integer code) {

        this(null, message, code);
    }

    public RespResult(T data) {
        this(data, "操作成功", 200);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
