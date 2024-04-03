package com.instabug.library.sessionV3.manager;

import com.instabug.library.sessionV3.di.c;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class n implements m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final n f51816a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f51817b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final ReadWriteProperty f51818c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final ReadWriteProperty f51819d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final ReadWriteProperty f51820e;

    static {
        Class<n> cls = n.class;
        f51817b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isStitchingEnabled", "isStitchingEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "lastForegroundMicroTime", "getLastForegroundMicroTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sessionTimeoutInSeconds", "getSessionTimeoutInSeconds()I", 0))};
        c cVar = c.f51790a;
        f51818c = cVar.a("v3_stitching_enabled", Boolean.TRUE);
        f51819d = cVar.a("v3_last_foreground_time", -1L);
        f51820e = cVar.a("v3_stitching_session_timeout", 1800);
    }

    private n() {
    }

    public void a(boolean z11) {
        f51818c.setValue(this, f51817b[0], Boolean.valueOf(z11));
    }

    public void b(long j11) {
        f51819d.setValue(this, f51817b[1], Long.valueOf(j11));
    }

    public boolean c() {
        return ((Boolean) f51818c.getValue(this, f51817b[0])).booleanValue();
    }

    private final long c(long j11) {
        if (a() != -1) {
            return TimeUnit.MICROSECONDS.toSeconds(j11 - a());
        }
        return a();
    }

    public long a() {
        return ((Number) f51819d.getValue(this, f51817b[1])).longValue();
    }

    public int b() {
        return ((Number) f51820e.getValue(this, f51817b[2])).intValue();
    }

    public void a(int i11) {
        f51820e.setValue(this, f51817b[2], Integer.valueOf(i11));
    }

    public boolean a(long j11) {
        if (!c()) {
            return false;
        }
        long c11 = c(j11);
        if (c11 == -1 || c11 > ((long) b())) {
            InstabugSDKLogger.v("IBG-Core", "started new billable session");
            return true;
        }
        InstabugSDKLogger.v("IBG-Core", "session stitched");
        return false;
    }
}
