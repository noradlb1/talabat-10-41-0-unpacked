package com.huawei.hms.activity.internal;

import android.content.Intent;

public class BusResponseResult {

    /* renamed from: a  reason: collision with root package name */
    private Intent f47753a;

    /* renamed from: b  reason: collision with root package name */
    private int f47754b;

    public int getCode() {
        return this.f47754b;
    }

    public Intent getIntent() {
        return this.f47753a;
    }

    public void setCode(int i11) {
        this.f47754b = i11;
    }

    public void setIntent(Intent intent) {
        this.f47753a = intent;
    }
}
