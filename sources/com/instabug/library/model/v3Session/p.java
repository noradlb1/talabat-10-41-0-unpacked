package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.providers.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class p {
    private p() {
    }

    public /* synthetic */ p(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final q a(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "dataProvider");
        String os2 = dVar.getOs();
        String appVersion = dVar.getAppVersion();
        return new q(dVar.h(), os2, dVar.k(), appVersion, dVar.g());
    }
}
