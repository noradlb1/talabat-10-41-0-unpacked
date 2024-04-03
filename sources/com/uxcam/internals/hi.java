package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import mz.e0;

@TargetApi(14)
public class hi implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d  reason: collision with root package name */
    public static int f13556d;

    /* renamed from: a  reason: collision with root package name */
    public int f13557a = 0;

    /* renamed from: b  reason: collision with root package name */
    public aa f13558b;

    /* renamed from: c  reason: collision with root package name */
    public Future<?> f13559c;

    public interface aa {
        void a(Activity activity);
    }

    public void a(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (f13556d == 0 || ia.c() == null || (canonicalName != null && !canonicalName.equals(ia.c().getClass().getCanonicalName()))) {
            ia.a(activity);
            f13556d++;
            aa aaVar = this.f13558b;
            if (aaVar != null && this.f13557a == 0) {
                aaVar.a(activity);
            }
            this.f13557a++;
            hm.a(false, activity);
        }
    }

    public void b() {
        if (f13556d == 0) {
            gu.a("UXCam").b("UXCam 3.4.4[561](Warning): Error in integration, see integration docs for instruction.", new Object[0]);
            gu.a("UXCamActivityData -> onStopTaskForLollipop").getClass();
            hm.h();
        }
        f13556d--;
        gu.a("ctest").getClass();
        if (f13556d == 0) {
            if (ee.c(hb.f13528k)) {
                hh.f13548g = true;
            }
            Future<?> future = this.f13559c;
            if (future != null) {
                future.cancel(true);
            }
            this.f13559c = Executors.newSingleThreadExecutor().submit(new e0());
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        fn.f13384o.remove(activity);
        b();
    }

    public void onActivityResumed(Activity activity) {
        a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static /* synthetic */ void a() {
        try {
            fm.f13365d = true;
            Thread.sleep((long) gm.f13452a);
            fm.f13365d = false;
            if (fn.f13380k > 0) {
                fn.f13379j = true;
                Thread.sleep(fn.f13380k);
            }
            fn.f13379j = false;
            hh.f13548g = false;
            if (f13556d == 0) {
                hm.h();
            }
        } catch (InterruptedException unused) {
            gu.a("UXCam").getClass();
        }
    }
}
