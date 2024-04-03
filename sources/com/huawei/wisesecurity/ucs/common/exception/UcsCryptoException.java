package com.huawei.wisesecurity.ucs.common.exception;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

public class UcsCryptoException extends CryptoException {
    public transient UcsErrorCode errorCode;

    public UcsCryptoException(long j11, String str) {
        super(str);
        this.errorCode = new UcsErrorCode(j11);
    }

    public long getErrorCode() {
        return this.errorCode.getCode();
    }
}
