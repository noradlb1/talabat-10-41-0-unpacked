package com.huawei.location.router.entity;

public class StatusInfo {
    private final int errorCode;
    private final String errorMessage;
    private final int statusCode;

    public StatusInfo(int i11, int i12, String str) {
        this.statusCode = i11;
        this.errorCode = i12;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
