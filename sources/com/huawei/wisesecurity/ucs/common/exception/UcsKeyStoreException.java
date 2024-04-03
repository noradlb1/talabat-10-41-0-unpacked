package com.huawei.wisesecurity.ucs.common.exception;

public class UcsKeyStoreException extends UcsException {
    public UcsKeyStoreException(long j11, String str) {
        super(j11, str);
    }

    public UcsKeyStoreException(long j11, String str, Throwable th2) {
        super(j11, str, th2);
    }
}
