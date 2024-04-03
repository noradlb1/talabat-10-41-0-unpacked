package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.providers.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class v {
    private v() {
    }

    public /* synthetic */ v(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final w a(@NotNull f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "productionUsageProvider");
        return new w(fVar.i(), fVar.b(), fVar.c(), fVar.d(), fVar.a(), fVar.e());
    }
}
