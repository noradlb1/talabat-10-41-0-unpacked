package com.instabug.library.internal.utils.memory;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
