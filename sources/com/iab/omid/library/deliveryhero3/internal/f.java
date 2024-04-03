package com.iab.omid.library.deliveryhero3.internal;

import android.annotation.SuppressLint;
import android.content.Context;

public class f {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static f f44964b = new f();

    /* renamed from: a  reason: collision with root package name */
    private Context f44965a;

    private f() {
    }

    public static f b() {
        return f44964b;
    }

    public Context a() {
        return this.f44965a;
    }

    public void a(Context context) {
        this.f44965a = context != null ? context.getApplicationContext() : null;
    }
}
