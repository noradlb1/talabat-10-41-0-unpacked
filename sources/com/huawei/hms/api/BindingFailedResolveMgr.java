package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

class BindingFailedResolveMgr {

    /* renamed from: b  reason: collision with root package name */
    static final BindingFailedResolveMgr f48007b = new BindingFailedResolveMgr();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f48008c = new Object();

    /* renamed from: a  reason: collision with root package name */
    List<Activity> f48009a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f48008c) {
            for (Activity next : this.f48009a) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f48009a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f48008c) {
            this.f48009a.remove(activity);
        }
    }
}
