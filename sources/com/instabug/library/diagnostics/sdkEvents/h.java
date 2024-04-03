package com.instabug.library.diagnostics.sdkEvents;

import com.instabug.library.diagnostics.sdkEvents.configurations.a;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a f34337a;

    public h(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "configs");
        this.f34337a = aVar;
    }

    public final boolean a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Set a11 = this.f34337a.a();
        if (a11 == null) {
            return false;
        }
        return a11.contains(str);
    }

    public final boolean a(@NotNull com.instabug.library.diagnostics.sdkEvents.models.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "sdkEvent");
        return (StringsKt__StringsJVMKt.isBlank(aVar.b()) ^ true) && aVar.a() > 0;
    }
}
