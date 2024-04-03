package com.instabug.apm.handler.experiment;

import com.instabug.apm.cache.handler.experiment.a;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.ReturnableSingleThreadExecutor;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nb.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a f45369a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final f f45370b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final com.instabug.apm.configuration.c f45371c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45372d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final ReturnableSingleThreadExecutor f45373e;

    static {
        new b((DefaultConstructorMarker) null);
    }

    public c(@NotNull a aVar, @NotNull f fVar, @NotNull com.instabug.apm.configuration.c cVar, @NotNull com.instabug.apm.logger.internal.a aVar2) {
        Intrinsics.checkNotNullParameter(aVar, "experimentsCacheHandler");
        Intrinsics.checkNotNullParameter(fVar, "metaDataCacheHandler");
        Intrinsics.checkNotNullParameter(cVar, "configurationProvider");
        Intrinsics.checkNotNullParameter(aVar2, "logger");
        this.f45369a = aVar;
        this.f45370b = fVar;
        this.f45371c = cVar;
        this.f45372d = aVar2;
        ReturnableSingleThreadExecutor returnableSingleThreadExecutor = PoolProvider.getReturnableSingleThreadExecutor("ApmExperiments");
        Intrinsics.checkNotNullExpressionValue(returnableSingleThreadExecutor, "getReturnableSingleThrea…imentsExecutorIdentifier)");
        this.f45373e = returnableSingleThreadExecutor;
    }

    /* access modifiers changed from: private */
    public static final List a(c cVar, String str) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sessionId");
        List a11 = cVar.f45369a.a(str);
        if (a11.isEmpty()) {
            return null;
        }
        return a11;
    }

    private final List a(List list) {
        int q11 = this.f45371c.q();
        if (list.size() <= q11) {
            return list;
        }
        int size = list.size();
        return list.subList(size - q11, size);
    }

    /* access modifiers changed from: private */
    public static final void a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        cVar.f45369a.a();
        cVar.f45370b.e();
    }

    /* access modifiers changed from: private */
    public static final void b(c cVar, String str) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sessionId");
        try {
            List<String> experiments = InstabugCore.getExperiments(1.0f);
            if (experiments != null) {
                if (experiments.isEmpty()) {
                    experiments = null;
                }
                if (experiments != null) {
                    if (cVar.f45371c.e0()) {
                        int size = experiments.size();
                        cVar.f45369a.a(cVar.a((List) experiments), str);
                        cVar.f45370b.i(str, size);
                        return;
                    }
                    cVar.f45372d.a("experiments weren't synced as Experiments seems to be disabled for your Instabug company account. Please contact support for more information.");
                }
            }
        } catch (Exception e11) {
            cVar.f45372d.a("Failed to store experiments", e11);
            IBGDiagnostics.reportNonFatal(e11, "Failed to store experiments");
        }
    }

    public void a() {
        this.f45373e.execute(new nb.a(this));
    }

    public void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.f45373e.execute(new nb.c(this, str));
    }

    @Nullable
    public List b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        return (List) this.f45373e.executeAndGet(new b(this, str));
    }
}
