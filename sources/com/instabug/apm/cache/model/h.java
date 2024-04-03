package com.instabug.apm.cache.model;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private long f45241a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f45242b = 0;

    public long a() {
        return this.f45241a;
    }

    public void a(long j11) {
        this.f45241a += j11;
    }

    public void a(Long l11) {
        this.f45242b += l11.longValue();
    }

    public long b() {
        return this.f45242b;
    }
}
