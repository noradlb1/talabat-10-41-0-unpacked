package com.instabug.library.diagnostics.customtraces.utils;

import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.customtraces.settings.a;
import com.instabug.library.diagnostics.f;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f34240a = new b();

    private b() {
    }

    public final boolean a(long j11, long j12) {
        return (j11 == 0 || j12 == 0 || j12 <= j11) ? false : true;
    }

    public final boolean a(@Nullable StackTraceElement[] stackTraceElementArr) {
        if (!f.b(stackTraceElementArr)) {
            InstabugSDKLogger.w("IBG-Core", "Please refrain from using IBGDiagnostics.startTrace as it's a private api");
            return false;
        }
        com.instabug.library.diagnostics.customtraces.settings.b bVar = com.instabug.library.diagnostics.customtraces.settings.b.f34237a;
        a b11 = bVar.b();
        if (b11 != null && !b11.a()) {
            InstabugSDKLogger.v("IBG-Core", "Can't start custom trace, feature is disabled");
        }
        a b12 = bVar.b();
        if (!(b12 == null ? false : b12.a()) || !Instabug.isBuilt() || !Instabug.isEnabled()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String b(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        String obj = StringsKt__StringsKt.trim((CharSequence) str).toString();
        if (obj.length() > 30) {
            return null;
        }
        return obj;
    }

    @Nullable
    public final String c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String obj = StringsKt__StringsKt.trim((CharSequence) str).toString();
        if (obj.length() > 60) {
            return null;
        }
        return obj;
    }

    @Nullable
    public final String d(@Nullable String str) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(true ^ z11)) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        String obj = StringsKt__StringsKt.trim((CharSequence) str).toString();
        if (obj.length() <= 150) {
            return obj;
        }
        String substring = obj.substring(0, 150);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final boolean a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        com.instabug.library.diagnostics.a aVar = com.instabug.library.diagnostics.a.f34216a;
        if (ArraysKt___ArraysKt.contains((T[]) aVar.b(), str)) {
            a b11 = com.instabug.library.diagnostics.customtraces.settings.b.f34237a.b();
            if (b11 != null && b11.d()) {
                return true;
            }
        } else if (!ArraysKt___ArraysKt.contains((T[]) aVar.a(), str)) {
            return true;
        } else {
            a b12 = com.instabug.library.diagnostics.customtraces.settings.b.f34237a.b();
            if (b12 != null && b12.c()) {
                return true;
            }
        }
        return false;
    }
}
