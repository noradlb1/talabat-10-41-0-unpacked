package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nc implements Mc {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Qc<?>> f48368a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List<Oc> f48369b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f48370c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final List<C0361dd> f48371d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f48372e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<Qc<Wc<?>>> f48373f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private String f48374g = "";

    public void a() {
        this.f48374g = "";
        this.f48368a.clear();
        this.f48369b.clear();
        this.f48370c.clear();
        this.f48371d.clear();
        this.f48372e.clear();
        this.f48373f.clear();
    }

    public void a(Qc<?> qc2) {
        this.f48368a.put(qc2.getName(), qc2);
    }

    public boolean a(String str) {
        return this.f48370c.contains(str);
    }

    public List<Oc> b() {
        return this.f48369b;
    }

    public void b(String str) {
        this.f48374g = str;
    }

    public List<Qc<Wc<?>>> c() {
        return this.f48373f;
    }

    public Map<String, Qc<?>> d() {
        return this.f48368a;
    }

    public String e() {
        return this.f48374g;
    }

    public List<String> f() {
        return this.f48370c;
    }

    public List<C0361dd> g() {
        return this.f48371d;
    }

    public List<String> h() {
        return this.f48372e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i() {
        /*
            r3 = this;
            java.util.List<com.huawei.hms.dtm.core.Oc> r0 = r3.f48369b
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0028
            java.lang.Object r1 = r0.next()
            com.huawei.hms.dtm.core.Oc r1 = (com.huawei.hms.dtm.core.Oc) r1
            java.util.List r2 = r1.a()
            int r2 = r2.size()
            if (r2 > 0) goto L_0x0026
            java.util.List r1 = r1.b()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0006
        L_0x0026:
            r0 = 1
            return r0
        L_0x0028:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Nc.i():boolean");
    }
}
