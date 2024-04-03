package com.instabug.crash.settings;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class f {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Context f46443a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f46444b = LazyKt__LazyJVMKt.lazy(new e(this));
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f46445c = LazyKt__LazyJVMKt.lazy(new d(this));

    static {
        new c((DefaultConstructorMarker) null);
    }

    public f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f46443a = context;
    }

    public final boolean c() {
        return b().getBoolean("an_crash_early_capture", false);
    }

    private final SharedPreferences.Editor a() {
        Object value = this.f46445c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-editor>(...)");
        return (SharedPreferences.Editor) value;
    }

    /* access modifiers changed from: private */
    public final SharedPreferences b() {
        Object value = this.f46444b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    public final void a(boolean z11) {
        a().putBoolean("an_crash_early_capture", z11).apply();
    }
}
