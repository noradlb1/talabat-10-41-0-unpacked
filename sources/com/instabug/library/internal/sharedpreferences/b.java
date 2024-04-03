package com.instabug.library.internal.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {
    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final c a(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences == null) {
            return null;
        }
        return new c(sharedPreferences);
    }
}
