package com.instabug.library.diagnostics;

import com.instabug.library.diagnostics.network.c;
import com.instabug.library.diagnostics.nonfatals.di.a;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.settings.SettingsManager;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i implements g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f34289a = new h(this);

    /* access modifiers changed from: private */
    public final e d() {
        return a.g();
    }

    /* access modifiers changed from: private */
    public final SettingsManager e() {
        SettingsManager instance = SettingsManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    private final c f() {
        return com.instabug.library.diagnostics.di.a.f34243a.c();
    }

    /* access modifiers changed from: private */
    public final com.instabug.library.diagnostics.customtraces.a b() {
        return com.instabug.library.diagnostics.customtraces.di.a.d();
    }

    private final Executor c() {
        return com.instabug.library.diagnostics.di.a.f34243a.a();
    }

    /* access modifiers changed from: private */
    public static final void d(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        iVar.f().a(iVar.f34289a);
    }

    public void a() {
        c().execute(new vc.a(this));
    }
}
