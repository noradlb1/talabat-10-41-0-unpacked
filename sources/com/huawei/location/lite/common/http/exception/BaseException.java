package com.huawei.location.lite.common.http.exception;

public abstract class BaseException extends Throwable {

    /* renamed from: b  reason: collision with root package name */
    public ErrorCode f50144b;

    public BaseException(ErrorCode errorCode) {
        this.f50144b = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.f50144b;
    }
}
