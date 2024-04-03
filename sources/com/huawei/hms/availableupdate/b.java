package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f48062b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f48063c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final List<Activity> f48064a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f48063c) {
            for (Activity next : this.f48064a) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f48064a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f48063c) {
            this.f48064a.remove(activity);
        }
    }
}
