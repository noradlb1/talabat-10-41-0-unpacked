package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.providers.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class f {
    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ g a(f fVar, e eVar, c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = com.instabug.library.sessionV3.di.c.f51790a.o();
        }
        return fVar.a(eVar, cVar);
    }

    @NotNull
    public final g a(@NotNull e eVar, @NotNull c cVar) {
        c cVar2 = cVar;
        Intrinsics.checkNotNullParameter(eVar, "inMemorySession");
        Intrinsics.checkNotNullParameter(cVar2, "dataProvider");
        return new g(0, eVar.a(), y.f51634g.a(cVar2), q.f51619f.a(cVar2), cVar2.a(eVar.b()), true, eVar.b(), w.f51627g.a(cVar2), 0, (c0) null, 769, (DefaultConstructorMarker) null);
    }
}
