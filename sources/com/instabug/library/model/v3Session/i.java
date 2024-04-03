package com.instabug.library.model.v3Session;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.sessionV3.configurations.c;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i {
    private i() {
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ j a(i iVar, long j11, c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = com.instabug.library.sessionV3.di.c.l();
        }
        return iVar.a(j11, cVar);
    }

    private final List b(boolean z11, List list, int i11) {
        return z11 ? CollectionsKt___CollectionsKt.takeLast(list, i11) : list;
    }

    @Nullable
    public final j a(long j11, @NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "configurations");
        if (!cVar.g()) {
            cVar = null;
        }
        if (cVar == null) {
            return null;
        }
        int j12 = cVar.j();
        List<String> experiments = InstabugCore.getExperiments(1.0f);
        if (experiments == null) {
            experiments = CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z11 = experiments.size() > j12;
        i iVar = j.f51611d;
        return new j(j11, iVar.b(z11, experiments, j12), iVar.a(z11, experiments, j12));
    }

    private final int a(boolean z11, List list, int i11) {
        if (z11) {
            return list.size() - i11;
        }
        return 0;
    }
}
