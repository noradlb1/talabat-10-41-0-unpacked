package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.request.HeadBuilder;

public class ResponseAdapter {
    /* access modifiers changed from: private */
    public ResponseBodyAdapter body;
    /* access modifiers changed from: private */
    public int code;
    /* access modifiers changed from: private */
    public HeadBuilder headers;
    /* access modifiers changed from: private */
    public String message;
    /* access modifiers changed from: private */
    public long receivedResponseAtMillis;
    /* access modifiers changed from: private */
    public long sentRequestAtMillis;
    /* access modifiers changed from: private */
    public String url;

    public static final class Builder {
        /* access modifiers changed from: private */
        public ResponseBodyAdapter body;
        /* access modifiers changed from: private */
        public int code;
        /* access modifiers changed from: private */
        public HeadBuilder headers;
        /* access modifiers changed from: private */
        public String message;
        /* access modifiers changed from: private */
        public long receivedResponseAtMillis;
        /* access modifiers changed from: private */
        public long sentRequestAtMillis;
        /* access modifiers changed from: private */
        public String url;

        public Builder() {
        }

        private Builder(ResponseAdapter responseAdapter) {
            this.body = responseAdapter.body;
            this.headers = responseAdapter.headers;
            this.code = responseAdapter.code;
            this.message = responseAdapter.message;
            this.sentRequestAtMillis = responseAdapter.sentRequestAtMillis;
            this.receivedResponseAtMillis = responseAdapter.receivedResponseAtMillis;
            this.url = responseAdapter.url;
        }

        public Builder body(ResponseBodyAdapter responseBodyAdapter) {
            this.body = responseBodyAdapter;
            return this;
        }

        public ResponseAdapter build() {
            return new ResponseAdapter(this);
        }

        public Builder code(int i11) {
            this.code = i11;
            return this;
        }

        public Builder headers(HeadBuilder headBuilder) {
            this.headers = headBuilder;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder receivedResponseAtMillis(long j11) {
            this.receivedResponseAtMillis = j11;
            return this;
        }

        public Builder sentRequestAtMillis(long j11) {
            this.sentRequestAtMillis = j11;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    private ResponseAdapter(Builder builder) {
        this.body = builder.body;
        this.headers = builder.headers;
        this.code = builder.code;
        this.message = builder.message;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
        this.url = builder.url;
    }

    public ResponseBodyAdapter getBody() {
        return this.body;
    }

    public int getCode() {
        return this.code;
    }

    public HeadBuilder getHeaders() {
        return this.headers;
    }

    public String getMessage() {
        return this.message;
    }

    public long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOK() {
        return this.code == 200;
    }

    public boolean isSuccessful() {
        int i11 = this.code;
        return i11 >= 200 && i11 < 300;
    }

    public Builder newBuilder() {
        return new Builder();
    }
}
