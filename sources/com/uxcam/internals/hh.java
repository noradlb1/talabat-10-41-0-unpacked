package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

@TargetApi(14)
public class hh implements Application.ActivityLifecycleCallbacks {

    /* renamed from: f  reason: collision with root package name */
    public static final String f13547f = "com.uxcam.internals.hh";

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13548g = false;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f13549a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    public boolean f13550b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13551c = true;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f13552d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f13553e;

    public class aa implements Runnable {

        /* renamed from: com.uxcam.internals.hh$aa$aa  reason: collision with other inner class name */
        public class C0002aa implements Runnable {
            public C0002aa() {
            }

            public void run() {
                hh.a(hh.this);
                fn.f13379j = false;
                gu.a("UXCam").getClass();
            }
        }

        public aa() {
        }

        public void run() {
            fm.f13365d = false;
            if (fn.f13380k > 0) {
                fn.f13379j = true;
                gu.a("UXCam").getClass();
                hh hhVar = hh.this;
                Handler handler = hhVar.f13549a;
                C0002aa aaVar = new C0002aa();
                hhVar.f13553e = aaVar;
                handler.postDelayed(aaVar, fn.f13380k);
                return;
            }
            fn.f13379j = false;
            hh.a(hh.this);
        }
    }

    public static void a(hh hhVar) {
        hhVar.getClass();
        f13548g = false;
        if (!hhVar.f13550b || !hhVar.f13551c) {
            gu.a("UXCam").getClass();
            return;
        }
        hhVar.f13550b = false;
        gu.a("UXCam").getClass();
        hm.h();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        gu.a(f13547f).getClass();
        this.f13551c = true;
        a();
        if (ee.c(hb.f13528k)) {
            f13548g = true;
        }
        fm.f13365d = true;
        Handler handler = this.f13549a;
        aa aaVar = new aa();
        this.f13552d = aaVar;
        handler.postDelayed(aaVar, (long) gm.f13452a);
    }

    public void onActivityResumed(Activity activity) {
        this.f13551c = false;
        boolean z11 = !this.f13550b;
        this.f13550b = true;
        a();
        if (!z11) {
            gu.a(f13547f).getClass();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        ia.a(activity);
        hm.a(false, activity);
    }

    public void onActivityStopped(Activity activity) {
        fn.f13384o.remove(activity);
    }

    public final void a() {
        Runnable runnable = this.f13552d;
        if (runnable != null) {
            this.f13549a.removeCallbacks(runnable);
            fm.f13365d = false;
            f13548g = false;
        }
        Runnable runnable2 = this.f13553e;
        if (runnable2 != null) {
            this.f13549a.removeCallbacks(runnable2);
            f13548g = false;
        }
    }
}
