package com.huawei.location.lite.common.http.exception;

public class OnErrorException extends BaseException {
    private String apiCode;
    private String apiMsg;

    public OnErrorException(ErrorCode errorCode) {
        super(errorCode);
        this.apiCode = String.valueOf(errorCode.code);
        this.apiMsg = errorCode.msg;
    }

    public OnErrorException(String str, String str2) {
        super(ErrorCode.valueOf(ErrorCode.LOCATION_SERVER_ERROR));
        this.apiCode = str;
        this.apiMsg = str2;
    }

    public String getApiCode() {
        return this.apiCode;
    }

    public String getApiMsg() {
        return this.apiMsg;
    }
}
