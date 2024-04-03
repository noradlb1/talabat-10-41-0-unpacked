package com.huawei.hms.location.api.request;

import com.huawei.hms.core.aidl.annotation.Packed;

public class RequestActivityIdentificationReq extends BaseLocationReq {
    @Packed
    private long detectionIntervalMillis;

    public long getDetectionIntervalMillis() {
        return this.detectionIntervalMillis;
    }

    public void setDetectionIntervalMillis(long j11) {
        this.detectionIntervalMillis = j11;
    }
}
