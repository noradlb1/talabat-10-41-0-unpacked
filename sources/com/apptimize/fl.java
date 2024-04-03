package com.apptimize;

import java.util.concurrent.atomic.AtomicLong;

public class fl {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42433a = "fl";

    /* renamed from: b  reason: collision with root package name */
    private static long f42434b = ((long) (Math.random() * 300000.0d));

    /* renamed from: c  reason: collision with root package name */
    private long f42435c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f42436d = new AtomicLong(1);

    public void a(long j11) {
        this.f42435c = j11;
    }

    public long b(long j11) {
        long j12 = this.f42436d.get();
        String str = f42433a;
        bo.k(str, "getAdjustedDelay multiplier:" + this.f42436d.get());
        if (j12 > 1) {
            j11 = (j11 + f42434b) * j12;
        }
        return Math.min(j11, this.f42435c);
    }

    public void a() {
        AtomicLong atomicLong = this.f42436d;
        atomicLong.set(atomicLong.get() * 2);
        String str = f42433a;
        bo.k(str, "connection failed multiplier:" + this.f42436d.get());
    }

    public void b() {
        this.f42436d.set(1);
        String str = f42433a;
        bo.k(str, "connection succeeded multiplier:" + this.f42436d.get());
    }
}
