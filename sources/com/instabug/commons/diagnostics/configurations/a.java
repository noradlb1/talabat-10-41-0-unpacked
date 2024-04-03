package com.instabug.commons.diagnostics.configurations;

import com.instabug.commons.preferences.b;
import com.instabug.commons.preferences.c;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.Instabug;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f46312b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isDiagnosticsAvailable", "isDiagnosticsAvailable()Z", 0))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final b f46313a = c.a(com.instabug.commons.diagnostics.a.f46307a.a());

    public void a(boolean z11) {
        this.f46313a.setValue(this, f46312b[0], Boolean.valueOf(z11));
    }

    public boolean b() {
        return ((Boolean) this.f46313a.getValue(this, f46312b[0])).booleanValue();
    }

    public boolean a() {
        return Instabug.isEnabled() && CrashReportingUtility.isCrashReportingEnabled() && b();
    }
}
