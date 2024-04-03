package com.instabug.library.util.extenstions;

import android.database.Cursor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class b {
    public static final boolean a(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return c.a(cursor.getInt(cursor.getColumnIndexOrThrow(str)));
    }

    public static final int b(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return cursor.getInt(cursor.getColumnIndexOrThrow(str));
    }

    public static final long c(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return cursor.getLong(cursor.getColumnIndexOrThrow(str));
    }

    @Nullable
    public static final String d(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return cursor.getString(cursor.getColumnIndexOrThrow(str));
    }

    @NotNull
    public static final String e(@NotNull Cursor cursor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        String string = cursor.getString(cursor.getColumnIndexOrThrow(str));
        Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndexOrThrow(key))");
        return string;
    }
}
