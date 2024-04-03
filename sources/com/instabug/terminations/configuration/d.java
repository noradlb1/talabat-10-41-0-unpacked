package com.instabug.terminations.configuration;

import com.instabug.crash.a;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class d implements c {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f52603d;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PreferencesProperty f52604a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PreferencesProperty f52605b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final PreferencesProperty f52606c;

    static {
        Class<d> cls = d.class;
        f52603d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isAvailable", "isAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "threshold", "getThreshold()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "stateRatio", "getStateRatio()F", 0))};
    }

    public d() {
        com.instabug.crash.di.d dVar = com.instabug.crash.di.d.f46399a;
        a aVar = a.f46376a;
        this.f52604a = dVar.a(aVar.i());
        this.f52605b = dVar.a(aVar.k());
        this.f52606c = dVar.a(aVar.j());
    }

    public void a(boolean z11) {
        this.f52604a.setValue(this, f52603d[0], Boolean.valueOf(z11));
    }

    public boolean b() {
        return ((Boolean) this.f52604a.getValue(this, f52603d[0])).booleanValue();
    }

    public boolean isEnabled() {
        return CrashReportingUtility.isCrashReportingEnabled() && b();
    }

    public long a() {
        return ((Number) this.f52605b.getValue(this, f52603d[1])).longValue();
    }

    public void a(long j11) {
        this.f52605b.setValue(this, f52603d[1], Long.valueOf(j11));
    }

    public void a(float f11) {
        this.f52606c.setValue(this, f52603d[2], Float.valueOf(f11));
    }
}
