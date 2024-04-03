package com.instabug.library.internal.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class a {
    public static void a(@NotNull b bVar, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(bVar, "this");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static void a(@NotNull b bVar, @NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(bVar, "this");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static void b(@NotNull b bVar, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(bVar, "this");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static void b(@NotNull b bVar, @NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bVar, "this");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }
}
