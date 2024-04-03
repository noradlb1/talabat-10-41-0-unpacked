package com.instabug.crash.settings;

import android.annotation.SuppressLint;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f46446b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f46447a = false;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f46446b == null) {
                b();
            }
            gVar = f46446b;
        }
        return gVar;
    }

    private static void b() {
        f46446b = new g();
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void d() {
        synchronized (g.class) {
            f46446b = null;
        }
    }

    public synchronized boolean c() {
        return this.f46447a;
    }

    public synchronized void a(boolean z11) {
        this.f46447a = z11;
    }
}
