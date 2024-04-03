package com.huawei.hms.locationSdk;

import android.os.Parcelable;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.location.router.entity.StatusInfo;

class k1 implements ResponseErrorCode {

    /* renamed from: a  reason: collision with root package name */
    private final int f49197a;

    /* renamed from: b  reason: collision with root package name */
    private final int f49198b;

    /* renamed from: c  reason: collision with root package name */
    private final String f49199c;

    /* renamed from: d  reason: collision with root package name */
    private final String f49200d;

    public k1(StatusInfo statusInfo, String str) {
        this.f49197a = statusInfo.getStatusCode();
        this.f49198b = statusInfo.getErrorCode();
        this.f49199c = statusInfo.getErrorMessage();
        this.f49200d = str;
    }

    public int getErrorCode() {
        return this.f49198b;
    }

    public String getErrorReason() {
        return this.f49199c;
    }

    public Parcelable getParcelable() {
        return null;
    }

    public String getResolution() {
        return null;
    }

    public int getStatusCode() {
        return this.f49197a;
    }

    public String getTransactionId() {
        return this.f49200d;
    }

    public boolean hasResolution() {
        return false;
    }
}
