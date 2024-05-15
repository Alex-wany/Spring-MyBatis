package com.javasm.vo;

public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "ResultVO{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }
}
