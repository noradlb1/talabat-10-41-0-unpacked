package com.huawei.hms.dtm.core;

import android.view.ViewGroup;

/* renamed from: com.huawei.hms.dtm.core.rd  reason: case insensitive filesystem */
public class C0431rd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f48554a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0436sd f48555b;

    public C0431rd(C0436sd sdVar, ViewGroup viewGroup) {
        this.f48555b = sdVar;
        this.f48554a = viewGroup;
    }

    public void run() {
        this.f48555b.a(this.f48554a);
    }
}
