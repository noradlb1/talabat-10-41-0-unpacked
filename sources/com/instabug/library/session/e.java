package com.instabug.library.session;

import com.instabug.library.internal.utils.PreferencesUtils;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;

public final class e implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f51745a = new e();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51746b = LazyKt__LazyJVMKt.lazy(d.f51744a);

    private e() {
    }

    private final long b() {
        PreferencesUtils d11 = d();
        if (d11 == null) {
            return 0;
        }
        return d11.getLong("last_sessions_request_started_at", 0);
    }

    private final long c() {
        PreferencesUtils d11 = d();
        if (d11 == null) {
            return 0;
        }
        return d11.getLong("sessions_rate_limited_until", 0);
    }

    private final PreferencesUtils d() {
        return (PreferencesUtils) f51746b.getValue();
    }

    public void a(long j11) {
        b(j11);
    }

    private final void b(long j11) {
        PreferencesUtils d11 = d();
        if (d11 != null) {
            d11.saveOrUpdateLong("last_sessions_request_started_at", j11);
        }
    }

    private final void c(long j11) {
        PreferencesUtils d11 = d();
        if (d11 != null) {
            d11.saveOrUpdateLong("sessions_rate_limited_until", j11);
        }
    }

    public void a(int i11) {
        c((((long) i11) * ((long) 1000)) + b());
    }

    public boolean a() {
        long b11 = b();
        long c11 = c();
        long currentTimeMillis = System.currentTimeMillis();
        return b11 != 0 && c11 != 0 && currentTimeMillis > b11 && currentTimeMillis < c11;
    }
}
