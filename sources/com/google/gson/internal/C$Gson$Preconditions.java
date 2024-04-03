package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions  reason: invalid class name */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }
}
