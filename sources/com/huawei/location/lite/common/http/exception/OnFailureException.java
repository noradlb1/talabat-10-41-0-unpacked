package com.huawei.location.lite.common.http.exception;

public class OnFailureException extends BaseException {
    public OnFailureException(ErrorCode errorCode) {
        super(errorCode);
    }
}
