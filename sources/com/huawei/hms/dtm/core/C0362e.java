package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.util.Logger;

/* renamed from: com.huawei.hms.dtm.core.e  reason: case insensitive filesystem */
public class C0362e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0367f f48473a;

    public C0362e(C0367f fVar) {
        this.f48473a = fVar;
    }

    public void run() {
        try {
            if (C0402m.b().d()) {
                C0402m.b().a();
                C0392k.c().a((Activity) this.f48473a.f48479b.get()).a(C0402m.b().c()).b();
            }
        } catch (Throwable th2) {
            Logger.warn("DTM-AutoTrace", "Exception when update xpath#" + th2.getClass().getSimpleName());
            C0381hd.a().a(th2, "ViewTreeObserverListener");
        }
    }
}
