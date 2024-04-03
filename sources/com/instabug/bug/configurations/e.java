package com.instabug.bug.configurations;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

public final class e implements d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f45631a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f45632b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f45633c;

    private e() {
    }

    private final long d() {
        SharedPreferences g11 = g();
        if (g11 == null) {
            return 0;
        }
        return g11.getLong("bug_reporting_rate_limited_until", 0);
    }

    private final SharedPreferences.Editor e() {
        SharedPreferences g11 = g();
        if (g11 == null) {
            return null;
        }
        return g11.edit();
    }

    private final long f() {
        SharedPreferences g11 = g();
        if (g11 == null) {
            return 0;
        }
        return g11.getLong("last_bug_reporting_request_started_at", 0);
    }

    private final SharedPreferences g() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getInstabugSharedPreferences(applicationContext, "instabug_bug_reporting");
    }

    private final void h() {
        synchronized (this) {
            SharedPreferences g11 = f45631a.g();
            boolean z11 = false;
            if (g11 != null) {
                z11 = g11.getBoolean("bug_reporting_usage_exceeded", false);
            }
            f45633c = true;
            f45632b = z11;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a() {
        h();
    }

    public void a(int i11) {
        SharedPreferences.Editor putLong;
        long f11 = (((long) i11) * ((long) 1000)) + f();
        SharedPreferences.Editor e11 = f45631a.e();
        if (e11 != null && (putLong = e11.putLong("bug_reporting_rate_limited_until", f11)) != null) {
            putLong.apply();
        }
    }

    public void a(long j11) {
        SharedPreferences.Editor putLong;
        SharedPreferences.Editor e11 = e();
        if (e11 != null && (putLong = e11.putLong("last_bug_reporting_request_started_at", j11)) != null) {
            putLong.apply();
        }
    }

    public void a(boolean z11) {
        SharedPreferences.Editor putBoolean;
        f45632b = z11;
        f45633c = true;
        SharedPreferences.Editor e11 = e();
        if (e11 != null && (putBoolean = e11.putBoolean("bug_reporting_usage_exceeded", z11)) != null) {
            putBoolean.apply();
        }
    }

    public boolean b() {
        if (!f45633c) {
            h();
        }
        return f45632b;
    }

    public boolean c() {
        long f11 = f();
        long d11 = d();
        long currentTimeMillis = System.currentTimeMillis();
        return f11 != 0 && d11 != 0 && currentTimeMillis > f11 && currentTimeMillis < d11;
    }
}
