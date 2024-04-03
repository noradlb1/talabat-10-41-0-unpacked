package com.instabug.apm.fragment;

import androidx.annotation.VisibleForTesting;
import com.instabug.apm.configuration.c;
import com.instabug.apm.di.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class v implements u {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final v f45353a = new v();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final c f45354b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final s f45355c;

    static {
        c c11 = a.c();
        Intrinsics.checkNotNullExpressionValue(c11, "getApmConfigurationProvider()");
        f45354b = c11;
        s H = a.H();
        Intrinsics.checkNotNullExpressionValue(H, "getFragmentLifecycleEventListener()");
        f45355c = H;
    }

    private v() {
    }

    public void a() {
        s sVar = f45355c;
        sVar.a();
        FragmentEventDispatcher.f45306a.b(sVar);
    }

    public void b() {
        a();
        a.L().a();
    }

    public void c() {
        if (d()) {
            FragmentEventDispatcher.f45306a.a(f45355c);
        }
    }

    @VisibleForTesting
    public final boolean d() {
        c cVar = f45354b;
        return cVar.H() && cVar.b();
    }
}
