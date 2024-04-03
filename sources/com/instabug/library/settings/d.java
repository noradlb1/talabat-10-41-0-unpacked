package com.instabug.library.settings;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class d {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Context f51882a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51883b = LazyKt__LazyJVMKt.lazy(new c(this));
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f51884c = LazyKt__LazyJVMKt.lazy(new b(this));

    static {
        new a((DefaultConstructorMarker) null);
    }

    public d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f51882a = context;
    }

    public final boolean c() {
        return b().getBoolean("sdk_last_state_enabled", false);
    }

    private final SharedPreferences.Editor a() {
        Object value = this.f51884c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-editor>(...)");
        return (SharedPreferences.Editor) value;
    }

    /* access modifiers changed from: private */
    public final SharedPreferences b() {
        Object value = this.f51883b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    public final void a(boolean z11) {
        a().putBoolean("sdk_last_state_enabled", z11).apply();
    }
}
