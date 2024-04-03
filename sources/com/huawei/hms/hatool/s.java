package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class s {

    /* renamed from: b  reason: collision with root package name */
    static Map<String, l1> f49109b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static s f49110c;

    /* renamed from: a  reason: collision with root package name */
    private g1 f49111a = new g1();

    private s() {
    }

    public static s c() {
        if (f49110c == null) {
            d();
        }
        return f49110c;
    }

    private static synchronized void d() {
        synchronized (s.class) {
            if (f49110c == null) {
                f49110c = new s();
            }
        }
    }

    public l1 a(String str) {
        return f49109b.get(str);
    }

    public Set<String> a() {
        return f49109b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f49109b.put(str, l1Var);
    }

    public g1 b() {
        return this.f49111a;
    }
}
