package com.instabug.anr.configuration;

import com.instabug.crash.a;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class d implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f45048c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "isAnrAvailable", "isAnrAvailable()Z", 0))};

    /* renamed from: a  reason: collision with root package name */
    private boolean f45049a = true;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PreferencesProperty f45050b = com.instabug.crash.di.d.f46399a.a(a.f46376a.a());

    public void a(boolean z11) {
        this.f45050b.setValue(this, f45048c[0], Boolean.valueOf(z11));
    }

    public boolean b() {
        return this.f45049a;
    }

    public boolean c() {
        return ((Boolean) this.f45050b.getValue(this, f45048c[0])).booleanValue();
    }

    public boolean a() {
        return CrashReportingUtility.isCrashReportingEnabled() & b() & c();
    }

    public void b(boolean z11) {
        this.f45049a = z11;
    }
}
