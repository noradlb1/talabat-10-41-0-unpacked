package com.huawei.agconnect.exception;

public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String str, int i11) {
        this.code = i11;
        this.errMsg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}
