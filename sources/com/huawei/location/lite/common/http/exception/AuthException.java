package com.huawei.location.lite.common.http.exception;

import java.io.IOException;

public class AuthException extends IOException {
    private ErrorCode errorCode;

    public AuthException(ErrorCode errorCode2) {
        this.errorCode = errorCode2;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
