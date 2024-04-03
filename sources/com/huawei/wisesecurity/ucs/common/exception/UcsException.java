package com.huawei.wisesecurity.ucs.common.exception;

public class UcsException extends Exception {
    public transient UcsErrorCode errorCode;

    public UcsException(long j11, String str) {
        super(str);
        this.errorCode = new UcsErrorCode(j11);
    }

    public UcsException(long j11, String str, Throwable th2) {
        super(str, th2);
        this.errorCode = new UcsErrorCode(j11);
    }

    public long getErrorCode() {
        return this.errorCode.getCode();
    }
}
