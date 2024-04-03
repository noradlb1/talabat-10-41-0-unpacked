package com.instabug.crash.configurations;

import com.instabug.crash.a;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class d implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f46391c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "isCrashReportingAvailable", "isCrashReportingAvailable()Z", 0))};

    /* renamed from: a  reason: collision with root package name */
    private boolean f46392a = true;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PreferencesProperty f46393b = com.instabug.crash.di.d.f46399a.a(a.f46376a.b());

    public void a(boolean z11) {
        this.f46392a = z11;
    }

    public void b(boolean z11) {
        this.f46393b.setValue(this, f46391c[0], Boolean.valueOf(z11));
    }

    public boolean c() {
        return this.f46392a;
    }

    public boolean a() {
        return ((Boolean) this.f46393b.getValue(this, f46391c[0])).booleanValue();
    }

    public boolean b() {
        return c() & a();
    }
}
