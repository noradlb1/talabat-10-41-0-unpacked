package com.huawei.location.lite.common.http.adapter;

public class ResponseBodyAdapter {
    /* access modifiers changed from: private */
    public long contentLength;
    /* access modifiers changed from: private */
    public String contentType;
    /* access modifiers changed from: private */
    public byte[] responseByte;

    public static final class Builder {
        /* access modifiers changed from: private */
        public long contentLength;
        /* access modifiers changed from: private */
        public String contentType;
        /* access modifiers changed from: private */
        public byte[] responseByte;

        public Builder() {
        }

        public Builder(ResponseBodyAdapter responseBodyAdapter) {
            this.contentType = responseBodyAdapter.contentType;
            this.contentLength = responseBodyAdapter.contentLength;
            this.responseByte = responseBodyAdapter.responseByte;
        }

        public ResponseBodyAdapter build() {
            return new ResponseBodyAdapter(this);
        }

        public Builder bytes(byte[] bArr) {
            this.responseByte = bArr;
            return this;
        }

        public Builder contentLength(long j11) {
            this.contentLength = j11;
            return this;
        }

        public Builder contentType(String str) {
            this.contentType = str;
            return this;
        }
    }

    private ResponseBodyAdapter(Builder builder) {
        this.contentType = builder.contentType;
        this.contentLength = builder.contentLength;
        this.responseByte = builder.responseByte;
    }

    public final byte[] bytes() {
        return this.responseByte;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }
}
