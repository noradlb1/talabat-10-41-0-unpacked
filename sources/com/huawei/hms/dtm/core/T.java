package com.huawei.hms.dtm.core;

import android.os.Bundle;

public class T implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f48413a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f48414b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f48415c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ U f48416d;

    public T(U u11, String str, Bundle bundle, boolean z11) {
        this.f48416d = u11;
        this.f48413a = str;
        this.f48414b = bundle;
        this.f48415c = z11;
    }

    public void run() {
        this.f48416d.b(this.f48413a, this.f48414b, this.f48415c);
    }
}
