package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final c f48065b = new c();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f48066a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a11 = a();
        if (a11 == null || a11.isFinishing()) {
            this.f48066a = new WeakReference<>(activity);
            return true;
        }
        activity.finish();
        HMSLog.i("UpdateAdapterMgr", "finish one");
        return false;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a11 = a();
        if (activity != null && activity.equals(a11)) {
            HMSLog.i("UpdateAdapterMgr", "reset");
            this.f48066a = null;
        }
    }

    private Activity a() {
        WeakReference<Activity> weakReference = this.f48066a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
