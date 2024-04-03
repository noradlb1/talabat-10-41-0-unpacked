package com.instabug.library.diagnostics.network;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class b {
    @NotNull
    public static String a(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "this");
        return "https://monitoring.instabug.com/api/sdk/v3/diagnostics";
    }
}
