package com.instabug.library.sessionV3.cache;

import com.instabug.library.model.v3Session.c0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class c {
    @NotNull
    public static final String a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return (String) pair.getFirst();
    }

    @NotNull
    public static final c0 b(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return (c0) pair.getSecond();
    }
}
