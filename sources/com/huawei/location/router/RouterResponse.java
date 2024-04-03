package com.huawei.location.router;

import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.StatusInfo;

public class RouterResponse implements IRouterResponse {
    private final String body;
    private final StatusInfo statusInfo;
    private String transactionId;

    public RouterResponse(String str, StatusInfo statusInfo2) {
        this.body = str;
        this.statusInfo = statusInfo2;
    }

    public String getBody() {
        return this.body;
    }

    public StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }
}
