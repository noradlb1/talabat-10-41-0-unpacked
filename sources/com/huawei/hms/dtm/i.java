package com.huawei.hms.dtm;

import android.os.Bundle;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48652a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f48653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f48654c;

    public i(l lVar, String str, Bundle bundle) {
        this.f48654c = lVar;
        this.f48652a = str;
        this.f48653b = bundle;
    }

    public void run() {
        this.f48654c.f48660b.logAutoEvent(this.f48652a, this.f48653b);
    }
}
