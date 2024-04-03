package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final int f49688a;

    /* renamed from: b  reason: collision with root package name */
    private final ErrorEnum f49689b;

    public BaseException(int i11) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i11);
        this.f49689b = fromCode;
        this.f49688a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f49688a;
    }

    public String getMessage() {
        return this.f49689b.getMessage();
    }
}
