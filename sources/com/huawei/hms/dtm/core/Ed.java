package com.huawei.hms.dtm.core;

import android.app.Activity;

public class Ed {

    /* renamed from: a  reason: collision with root package name */
    private Dd f48289a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f48290b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f48291c = true;

    /* renamed from: d  reason: collision with root package name */
    public C0436sd f48292d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Ed f48293a = new Ed();
    }

    public static Ed d() {
        return a.f48293a;
    }

    public void a() {
        C0436sd sdVar = this.f48292d;
        if (sdVar != null) {
            sdVar.a();
        }
        this.f48292d = null;
    }

    public void a(int i11) {
        C0436sd sdVar = this.f48292d;
        if (sdVar != null) {
            sdVar.a(i11);
        }
    }

    public void a(Activity activity) {
        C0471zd zdVar = new C0471zd(activity);
        this.f48292d = zdVar;
        zdVar.b();
    }

    public void a(Dd dd2) {
        this.f48289a = dd2;
    }

    public void a(boolean z11) {
        this.f48291c = z11;
    }

    public void b() {
        Dd dd2 = this.f48289a;
        if (dd2 != null) {
            dd2.a();
        }
    }

    public void b(Activity activity) {
        Dd dd2 = this.f48289a;
        if (dd2 != null) {
            dd2.onActivityPaused(activity);
        }
    }

    public void b(boolean z11) {
        this.f48290b = z11;
    }

    public void c() {
        Dd dd2 = this.f48289a;
        if (dd2 != null) {
            dd2.b();
        }
    }

    public void c(Activity activity) {
        Dd dd2 = this.f48289a;
        if (dd2 != null) {
            dd2.onActivityResumed(activity);
        }
    }

    public boolean e() {
        return this.f48291c;
    }

    public boolean f() {
        return this.f48290b;
    }
}
