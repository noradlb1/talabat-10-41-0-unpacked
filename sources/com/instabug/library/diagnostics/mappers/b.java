package com.instabug.library.diagnostics.mappers;

import com.instabug.library.networkv2.request.RequestParameter;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class b {
    @NotNull
    public static final RequestParameter a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return (RequestParameter) pair.getFirst();
    }

    public static final boolean b(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return ((Boolean) pair.getSecond()).booleanValue();
    }
}
