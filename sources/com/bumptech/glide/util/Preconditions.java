package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z11, @NonNull String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String checkNotEmpty(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t11) {
        return checkNotNull(t11, "Argument must not be null");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t11, @NonNull String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T checkNotEmpty(@NonNull T t11) {
        if (!t11.isEmpty()) {
            return t11;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }
}
