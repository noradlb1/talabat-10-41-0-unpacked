package com.huawei.wisesecurity.ucs.credential.outer;

import java.util.List;
import java.util.Map;

public class NetworkResponse {
    public static final int HTTP_CODE_OK = 200;
    public String body;
    public int code;
    public Map<String, List<String>> headers;

    public String getBody() {
        return this.body;
    }

    public int getCode() {
        return this.code;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public boolean isSuccessful() {
        return this.code == 200;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }
}
