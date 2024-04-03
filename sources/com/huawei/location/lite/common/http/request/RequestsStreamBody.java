package com.huawei.location.lite.common.http.request;

import com.huawei.location.lite.common.http.adapter.RequestBodyAdapter;

public class RequestsStreamBody extends RequestBodyAdapter {
    private static final String BINARY_OCTET_STREAM = "binary/octet-stream";
    private final byte[] binaryStream;

    public static final class Builder {
        /* access modifiers changed from: private */
        public byte[] binaryStream = new byte[0];

        public RequestsStreamBody build() {
            return new RequestsStreamBody(this);
        }

        public RequestsStreamBody build(byte[] bArr) {
            if (bArr != null) {
                this.binaryStream = (byte[]) bArr.clone();
            }
            return new RequestsStreamBody(this);
        }

        public Builder setBinaryStream(byte[] bArr) {
            if (bArr != null) {
                this.binaryStream = (byte[]) bArr.clone();
            }
            return this;
        }
    }

    public RequestsStreamBody(Builder builder) {
        this.binaryStream = builder.binaryStream;
    }

    public String contentType() {
        return BINARY_OCTET_STREAM;
    }

    public byte[] getBody() {
        byte[] bArr = this.binaryStream;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }
}
