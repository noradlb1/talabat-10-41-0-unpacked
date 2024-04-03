package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

public class ResponseHeader implements IMessageEntity {
    @Packed
    protected int statusCode;

    public ResponseHeader() {
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ResponseHeader(int i11) {
        this.statusCode = i11;
    }
}
