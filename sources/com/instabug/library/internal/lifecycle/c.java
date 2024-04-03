package com.instabug.library.internal.lifecycle;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class c {
    public static void a(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "this");
    }

    public static void a(@NotNull d dVar, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(dVar, "this");
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
    }
}
