package com.shops.shop.Bean;

public class Result {
    private int status;
    private String msg;
    private Object value;

    //构造函数
    public Result() {
        this.status = 300;
        this.msg = "wrong";
        this.value = null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
