package com.instabug.bug.di;

import com.instabug.bug.cache.b;
import com.instabug.bug.cache.c;
import com.instabug.bug.cache.d;
import com.instabug.bug.configurations.e;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static com.instabug.bug.cache.a f45635a;

    /* renamed from: b  reason: collision with root package name */
    private static com.instabug.bug.cache.a f45636b;

    /* renamed from: c  reason: collision with root package name */
    private static c f45637c;

    public static com.instabug.bug.cache.a a() {
        if (f45635a == null) {
            f45635a = new b();
        }
        return f45635a;
    }

    public static c b() {
        if (f45637c == null) {
            f45637c = new c();
        }
        return f45637c;
    }

    public static com.instabug.bug.cache.a c() {
        if (f45636b == null) {
            f45636b = new d();
        }
        return f45636b;
    }

    public static com.instabug.bug.configurations.a d() {
        return com.instabug.bug.configurations.c.f45629a;
    }

    public static com.instabug.bug.configurations.d e() {
        return e.f45631a;
    }
}
