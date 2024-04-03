package com.huawei.hms.dtm.core;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.dtm.core.m  reason: case insensitive filesystem */
public class C0402m {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f48515a = new AtomicBoolean(true);

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f48516b = new AtomicInteger(4);

    /* renamed from: com.huawei.hms.dtm.core.m$a */
    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final C0402m f48517a = new C0402m();
    }

    public static C0402m b() {
        return a.f48517a;
    }

    public void a() {
        this.f48515a.set(false);
    }

    public int c() {
        return this.f48516b.get();
    }

    public boolean d() {
        return this.f48515a.get();
    }

    public void e() {
        this.f48515a.set(true);
        this.f48516b.set(4);
    }
}
