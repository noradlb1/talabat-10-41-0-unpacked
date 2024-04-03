package com.huawei.location.lite.common.plug;

import android.os.Bundle;

public class PluginRespResult {
    private String body;
    private Bundle extraBundle;
    private StatusInfo statusInfo;
    private String transactionId;

    public static class StatusInfo {
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

    public PluginRespResult() {
    }

    public PluginRespResult(String str, StatusInfo statusInfo2) {
        this.body = str;
        this.statusInfo = statusInfo2;
    }

    public String getBody() {
        return this.body;
    }

    public Bundle getExtraInfo() {
        return this.extraBundle;
    }

    public StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setExtraData(Bundle bundle) {
        this.extraBundle = bundle;
    }

    public void setStatusInfo(StatusInfo statusInfo2) {
        this.statusInfo = statusInfo2;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }
}
