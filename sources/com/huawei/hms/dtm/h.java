package com.huawei.hms.dtm;

import android.os.Bundle;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f48650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f48651c;

    public h(l lVar, String str, Bundle bundle) {
        this.f48651c = lVar;
        this.f48649a = str;
        this.f48650b = bundle;
    }

    public void run() {
        this.f48651c.f48660b.logEvent(this.f48649a, this.f48650b);
    }
}
