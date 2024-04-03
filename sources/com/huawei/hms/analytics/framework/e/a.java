package com.huawei.hms.analytics.framework.e;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f47989a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f47990b = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (f47989a == null) {
            b();
        }
        return f47989a;
    }

    private static synchronized void b() {
        synchronized (a.class) {
            if (f47989a == null) {
                f47989a = new a();
            }
        }
    }

    public final b a(String str) {
        if (this.f47990b.containsKey(str)) {
            return this.f47990b.get(str);
        }
        b bVar = new b();
        this.f47990b.put(str, bVar);
        return bVar;
    }

    public final b a(String str, long j11) {
        b a11 = a(str);
        a11.a(str, j11);
        return a11;
    }
}
