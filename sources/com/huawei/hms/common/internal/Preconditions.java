package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;

public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Cannot use constructor to make a new instance");
    }

    private static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void checkArgument(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        checkHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void checkMainThread(String str) {
        if (!a()) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotMainThread() {
        if (a()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
    }

    public static <O> O checkNotNull(O o11) {
        if (o11 != null) {
            return o11;
        }
        throw new NullPointerException("must not refer to a null object");
    }

    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <O> O checkNotNull(O o11, Object obj) {
        if (o11 != null) {
            return o11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
