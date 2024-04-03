package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

public final class y {

    /* renamed from: b  reason: collision with root package name */
    private static y f49145b;

    /* renamed from: a  reason: collision with root package name */
    private volatile Map<String, p0> f49146a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f49146a.containsKey(str)) {
            this.f49146a.put(str, new p0());
        }
        return this.f49146a.get(str);
    }

    public static y a() {
        if (f49145b == null) {
            b();
        }
        return f49145b;
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (f49145b == null) {
                f49145b = new y();
            }
        }
    }

    public p0 a(String str, long j11) {
        p0 a11 = a(str);
        a11.a(j11);
        return a11;
    }
}
