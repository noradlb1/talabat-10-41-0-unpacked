package com.apptimize;

import android.os.SystemClock;
import com.facebook.AuthenticationTokenClaims;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.time.DateUtils;

public class eu {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f42347a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private long f42348b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f42349c = 0;

    public long a() {
        return e() + c();
    }

    public long b() {
        long j11 = this.f42348b;
        if (j11 == 0) {
            return System.currentTimeMillis();
        }
        this.f42348b = 1 + j11;
        return j11;
    }

    public long c() {
        long j11 = this.f42349c;
        if (j11 == 0) {
            return SystemClock.elapsedRealtime();
        }
        this.f42349c = 1 + j11;
        return j11;
    }

    public long d() {
        return c();
    }

    public long e() {
        AtomicLong atomicLong = f42347a;
        long j11 = atomicLong.get();
        if (j11 != 0) {
            return j11;
        }
        atomicLong.compareAndSet(0, b() - c());
        return atomicLong.get();
    }

    public long f() {
        return e() - DateUtils.MILLIS_PER_HOUR;
    }

    public long a(long j11) {
        return c() - j11;
    }

    public long b(long j11) {
        return Math.min(j11 - e(), c());
    }

    public long a(long j11, long j12) {
        long e11 = e();
        long j13 = j11 - j12;
        long min = Math.min(j13, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
        if (j13 > a() - e11 || j12 < e11 - min || j12 > min + e11) {
            return f();
        }
        return e11 + j13;
    }
}
