package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {

    /* renamed from: a  reason: collision with root package name */
    private int f49828a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f49829b;

    public BundleResult(int i11, Bundle bundle) {
        this.f49828a = i11;
        this.f49829b = bundle;
    }

    public int getResultCode() {
        return this.f49828a;
    }

    public Bundle getRspBody() {
        return this.f49829b;
    }

    public void setResultCode(int i11) {
        this.f49828a = i11;
    }

    public void setRspBody(Bundle bundle) {
        this.f49829b = bundle;
    }
}
