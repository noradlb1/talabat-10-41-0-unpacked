package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;

/* renamed from: com.huawei.hms.dtm.core.z  reason: case insensitive filesystem */
public class C0467z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B f48640a;

    public C0467z(B b11) {
        this.f48640a = b11;
    }

    public void run() {
        if (J.a() == null) {
            Logger.error("loadJson#Before application.onCreate");
            return;
        }
        Logger.info("DTM-Decode", "schedule loadJson");
        this.f48640a.a(false, true);
    }
}
