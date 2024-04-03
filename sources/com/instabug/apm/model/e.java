package com.instabug.apm.model;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f45491a;

    /* renamed from: b  reason: collision with root package name */
    private final long f45492b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45493c;

    /* renamed from: d  reason: collision with root package name */
    private final long f45494d;

    public e() {
        long nanoTime = System.nanoTime();
        this.f45491a = nanoTime;
        long currentTimeMillis = System.currentTimeMillis();
        this.f45493c = currentTimeMillis;
        long j11 = (long) 1000;
        this.f45492b = nanoTime / j11;
        this.f45494d = currentTimeMillis * j11;
    }

    public long a() {
        return this.f45492b;
    }

    public long b() {
        return this.f45491a;
    }

    public long c() {
        return this.f45494d;
    }

    public long d() {
        return this.f45493c;
    }
}
