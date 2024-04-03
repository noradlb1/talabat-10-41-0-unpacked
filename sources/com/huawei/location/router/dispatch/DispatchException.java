package com.huawei.location.router.dispatch;

public class DispatchException extends RuntimeException {
    private static final long serialVersionUID = -6632599877015588781L;
    private int exceptionCode;

    public DispatchException(int i11, String str) {
        super(str);
        setExceptionCode(i11);
    }

    public DispatchException(int i11, String str, Throwable th2) {
        super(str, th2);
        setExceptionCode(i11);
    }

    private void setExceptionCode(int i11) {
        this.exceptionCode = i11;
    }

    public int getExceptionCode() {
        return this.exceptionCode;
    }
}
