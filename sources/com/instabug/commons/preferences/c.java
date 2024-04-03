package com.instabug.commons.preferences;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class c {
    @NotNull
    public static final b a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "keyValue");
        return new b((String) pair.getFirst(), pair.getSecond());
    }
}
