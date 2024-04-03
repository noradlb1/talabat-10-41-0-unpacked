package com.huawei.hms.analytics.core.transport.net;

public class Response {
    private String content;
    private int httpCode;

    public Response(int i11, String str) {
        this.httpCode = i11;
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHttpCode(int i11) {
        this.httpCode = i11;
    }
}
