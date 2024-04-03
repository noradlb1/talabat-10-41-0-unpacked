package com.instabug.fatalhangs;

import android.content.Context;
import com.instabug.commons.configurations.a;
import com.instabug.commons.g;
import com.instabug.fatalhangs.di.c;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import ic.b;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Thread f46460a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f46461b = LazyKt__LazyJVMKt.lazy(a.f46452a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f46462c = LazyKt__LazyJVMKt.lazy(b.f46453a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1 f46463d = new c(this);

    private final void d() {
        ThreadPoolExecutor f11 = c.f46466a.f();
        if (f11 != null) {
            f11.execute(new b());
        }
    }

    /* access modifiers changed from: private */
    public static final void e() {
        c cVar = c.f46466a;
        cVar.b().b(cVar.a());
    }

    private final a f() {
        return (a) this.f46461b.getValue();
    }

    private final com.instabug.fatalhangs.configuration.d g() {
        return (com.instabug.fatalhangs.configuration.d) this.f46462c.getValue();
    }

    private final void h() {
        if (g().a()) {
            j();
            return;
        }
        k();
        d();
    }

    private final boolean i() {
        return InstabugCore.getStartedActivitiesCount() > 0;
    }

    private final void j() {
        if (g().a() && this.f46460a == null && i()) {
            Thread a11 = c.f46466a.a(this.f46463d);
            a11.start();
            this.f46460a = a11;
        }
    }

    private final void k() {
        Thread thread = this.f46460a;
        if (thread != null) {
            thread.interrupt();
        }
        this.f46460a = null;
    }

    /* access modifiers changed from: private */
    public final void l() {
        String name2 = d.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "this::class.java.name");
        synchronized (name2) {
            c.f46466a.e().a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        f().a();
    }

    public void c() {
    }

    public void a() {
        j();
    }

    public void b() {
        k();
    }

    /* access modifiers changed from: private */
    public static final void b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "this$0");
        dVar.l();
    }

    public void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        ThreadPoolExecutor f11;
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "sdkCoreEvent");
        String type = sDKCoreEvent.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -296668708) {
                if (hashCode != -290659267) {
                    if (hashCode == 1843485230 && type.equals(SDKCoreEvent.Network.TYPE_NETWORK) && Intrinsics.areEqual((Object) sDKCoreEvent.getValue(), (Object) SDKCoreEvent.Network.VALUE_ACTIVATED) && g().a() && (f11 = c.f46466a.f()) != null) {
                        f11.execute(new ic.a(this));
                    }
                } else if (type.equals("features")) {
                    h();
                }
            } else if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                f().a(sDKCoreEvent.getValue());
                h();
            }
        }
    }
}
