package com.instabug.library.diagnostics.sdkEvents;

import com.instabug.library.diagnostics.sdkEvents.cache.a;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zc.b;
import zc.c;
import zc.d;
import zc.e;
import zc.f;

public final class g implements f {
    private final a b() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.e();
    }

    private final ThreadPoolExecutor c() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.h();
    }

    public void a(@NotNull com.instabug.library.diagnostics.sdkEvents.models.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "event");
        c().execute(new d(this, aVar));
    }

    public void clearCache() {
        c().execute(new c(this));
    }

    /* access modifiers changed from: private */
    public static final void a(g gVar, com.instabug.library.diagnostics.sdkEvents.models.a aVar) {
        Intrinsics.checkNotNullParameter(gVar, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "$event");
        synchronized ("sdk_events_lock") {
            gVar.b().a(aVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void b(@NotNull com.instabug.library.diagnostics.sdkEvents.models.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "event");
        synchronized ("sdk_events_lock") {
            b().a(aVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void b(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "this$0");
        synchronized ("sdk_events_lock") {
            gVar.b().a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a(@Nullable Collection collection) {
        c().execute(new b(this, collection));
    }

    /* access modifiers changed from: private */
    public static final void a(g gVar, Collection collection) {
        Intrinsics.checkNotNullParameter(gVar, "this$0");
        synchronized ("sdk_events_lock") {
            gVar.b().a(collection);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "this$0");
        synchronized ("sdk_events_lock") {
            gVar.b().clearCache();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "syncedRecords");
        c().execute(new e(this, list));
    }

    /* access modifiers changed from: private */
    public static final void a(g gVar, List list) {
        Intrinsics.checkNotNullParameter(gVar, "this$0");
        Intrinsics.checkNotNullParameter(list, "$syncedRecords");
        synchronized ("sdk_events_lock") {
            gVar.b().a(list);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a() {
        c().execute(new f(this));
    }
}
