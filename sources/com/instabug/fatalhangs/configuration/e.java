package com.instabug.fatalhangs.configuration;

import com.instabug.crash.a;
import com.instabug.crash.di.d;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class e implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f46457c;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PreferencesProperty f46458a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PreferencesProperty f46459b;

    static {
        Class<e> cls = e.class;
        f46457c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isFatalHangsAvailable", "isFatalHangsAvailable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "fatalHangsSensitivity", "getFatalHangsSensitivity()J", 0))};
    }

    public e() {
        d dVar = d.f46399a;
        a aVar = a.f46376a;
        this.f46458a = dVar.a(aVar.c());
        this.f46459b = dVar.a(aVar.d());
    }

    public void a(boolean z11) {
        this.f46458a.setValue(this, f46457c[0], Boolean.valueOf(z11));
    }

    public boolean b() {
        return ((Boolean) this.f46458a.getValue(this, f46457c[0])).booleanValue();
    }

    public void a(long j11) {
        this.f46459b.setValue(this, f46457c[1], Long.valueOf(j11));
    }

    public boolean a() {
        return CrashReportingUtility.isCrashReportingEnabled() && b();
    }
}
