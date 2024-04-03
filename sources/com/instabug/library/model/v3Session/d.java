package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.providers.a;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class d {
    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final e a(@NotNull s sVar) {
        Intrinsics.checkNotNullParameter(sVar, "event");
        a0 a11 = z.a(a0.f51588d, sVar, (a) null, 2, (Object) null);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return new e(a11, uuid);
    }
}
