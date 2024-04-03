package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f48058c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f48059d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f48060a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final List<Activity> f48061b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f48059d) {
            for (Activity next : this.f48061b) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f48061b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f48059d) {
            this.f48061b.remove(activity);
        }
    }

    public void a(boolean z11) {
        this.f48060a.set(z11);
    }

    public AtomicBoolean a() {
        return this.f48060a;
    }
}
