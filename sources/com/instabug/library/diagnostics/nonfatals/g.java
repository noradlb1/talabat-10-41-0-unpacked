package com.instabug.library.diagnostics.nonfatals;

import com.instabug.library.settings.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final g f34302a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static int f34303b;

    private g() {
    }

    public final int a() {
        return f34303b;
    }

    @JvmStatic
    public static final void a(@Nullable String str) {
        e j11;
        g gVar = f34302a;
        if (Intrinsics.areEqual((Object) str, (Object) "DiagnosticsDbManager.kt")) {
            f34303b++;
            if (!(gVar.a() >= 5)) {
                gVar = null;
            }
            if (gVar != null && (j11 = e.j()) != null) {
                j11.g(true);
            }
        }
    }
}
