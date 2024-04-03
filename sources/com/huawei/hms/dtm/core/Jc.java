package com.huawei.hms.dtm.core;

import android.app.Activity;

public class Jc {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48325a = true;

    /* renamed from: b  reason: collision with root package name */
    public C0436sd f48326b;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Jc f48327a = new Jc();
    }

    public static Jc b() {
        return a.f48327a;
    }

    public void a() {
        C0436sd sdVar = this.f48326b;
        if (sdVar != null) {
            sdVar.a();
        }
        this.f48326b = null;
    }

    public void a(Activity activity) {
        C0451vd vdVar = new C0451vd(activity);
        this.f48326b = vdVar;
        vdVar.b();
    }

    public void a(boolean z11) {
        this.f48325a = z11;
    }

    public boolean c() {
        return this.f48325a;
    }
}
