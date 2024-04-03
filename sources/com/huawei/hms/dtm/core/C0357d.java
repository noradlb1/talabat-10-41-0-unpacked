package com.huawei.hms.dtm.core;

import android.app.Activity;
import com.huawei.hms.dtm.core.C0352c;
import com.huawei.hms.dtm.core.util.Logger;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.dtm.core.d  reason: case insensitive filesystem */
public class C0357d implements C0397l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0352c.b f48459a;

    public C0357d(C0352c.b bVar) {
        this.f48459a = bVar;
    }

    public void a(WeakReference<Activity> weakReference) {
        if (!this.f48459a.f48454a.get()) {
            Logger.debug("DTM-AutoTrace", "onXPathCompleted start reportEnter");
            this.f48459a.f48454a.set(true);
            this.f48459a.a(weakReference);
        }
    }
}
