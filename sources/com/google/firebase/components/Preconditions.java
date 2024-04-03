package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class Preconditions {
    public static void checkArgument(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    public static void checkState(boolean z11, String str) {
        if (!z11) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }
}
