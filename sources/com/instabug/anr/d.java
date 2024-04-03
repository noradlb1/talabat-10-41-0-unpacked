package com.instabug.anr;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.instabug.anr.configuration.c;
import com.instabug.anr.network.i;
import com.instabug.commons.configurations.a;
import com.instabug.commons.g;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.util.threading.PoolProvider;
import kb.b;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements g, a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private e f45051a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f45052b = LazyKt__LazyJVMKt.lazy(b.f45046a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f45053c = LazyKt__LazyJVMKt.lazy(c.f45047a);

    private final boolean d() {
        return this.f45051a == null && i() && h();
    }

    private final a e() {
        return (a) this.f45052b.getValue();
    }

    private final c f() {
        return (c) this.f45053c.getValue();
    }

    private final void g() {
        if (i()) {
            k();
            return;
        }
        e eVar = this.f45051a;
        if (eVar != null) {
            eVar.interrupt();
        }
        this.f45051a = null;
    }

    private final boolean h() {
        return InstabugCore.getStartedActivitiesCount() > 0;
    }

    private final boolean i() {
        return f().a();
    }

    private final void j() {
        if (Instabug.isEnabled()) {
            e eVar = new e(this, new com.instabug.anr.model.a(), new f());
            this.f45051a = eVar;
            eVar.start();
        }
    }

    private final void k() {
        if (d()) {
            j();
        }
    }

    private final void l() {
        if (f().a()) {
            PoolProvider.postIOTask(new b());
        }
    }

    /* access modifiers changed from: private */
    public static final void m() {
        com.instabug.crash.utils.a.a();
        if (com.instabug.anr.cache.a.b() > 0) {
            i.a().start();
        }
    }

    @WorkerThread
    private final void n() {
        if (i() && com.instabug.anr.cache.a.b() > 0) {
            i.a().start();
        }
    }

    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PoolProvider.postIOTask(new kb.a(this));
    }

    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        e().a();
    }

    public void c() {
        this.f45051a = null;
    }

    /* access modifiers changed from: private */
    public static final void a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "this$0");
        dVar.n();
    }

    public void b() {
        e eVar = this.f45051a;
        if (eVar != null) {
            eVar.interrupt();
        }
        this.f45051a = null;
    }

    public void a() {
        k();
    }

    public void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "sdkCoreEvent");
        String type = sDKCoreEvent.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -296668708) {
                if (hashCode != -290659267) {
                    if (hashCode == 1843485230 && type.equals(SDKCoreEvent.Network.TYPE_NETWORK) && Intrinsics.areEqual((Object) sDKCoreEvent.getValue(), (Object) SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                        l();
                    }
                } else if (type.equals("features")) {
                    g();
                }
            } else if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                PoolProvider.postIOTask(new kb.c(this, sDKCoreEvent));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d dVar, SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(dVar, "this$0");
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "$sdkCoreEvent");
        dVar.e().a(sDKCoreEvent.getValue());
        dVar.g();
    }

    @WorkerThread
    public void a(@NotNull com.instabug.anr.model.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "anr");
        bVar.a(1);
        com.instabug.anr.cache.a.a(bVar);
        i.a().start();
    }
}
