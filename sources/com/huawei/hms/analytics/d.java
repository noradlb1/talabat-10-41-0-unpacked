package com.huawei.hms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;

public class d implements Application.ActivityLifecycleCallbacks {
    private static d lmn;
    private Context ijk;
    private boolean ikl = false;
    private boolean klm = false;

    public static d lmn() {
        synchronized (d.class) {
            if (lmn == null) {
                lmn = new d();
            }
        }
        return lmn;
    }

    public final void lmn(Application application) {
        if (application == null || this.ikl) {
            HiLog.d("InitializeCallback", "application is null or has registered.");
            return;
        }
        try {
            this.ijk = application.getApplicationContext();
            application.registerActivityLifecycleCallbacks(lmn);
            this.ikl = true;
        } catch (Exception unused) {
            HiLog.e("InitializeCallback", "register lifecycle callback failed");
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity != null) {
            try {
                if (dv.klm(this.ijk, "global_v2", "is_analytics_enabled", true)) {
                    cb lmn2 = di.lmn(activity);
                    if (!this.klm && TextUtils.isEmpty(av.lmn().lmn.f47857d)) {
                        di.lmn(activity, lmn2);
                        this.klm = true;
                    }
                    j.lmn(this.ijk, lmn2);
                }
            } catch (Throwable th2) {
                HiLog.w("InitializeCallback", th2.getMessage());
                dr.lmn(this.ijk, th2);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
