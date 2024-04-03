package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class Checker {
    private Checker() {
    }

    public static void assertHandlerThread(Handler handler) {
        assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertNonEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Given String is empty or null");
        }
    }

    public static <T> T assertNonNull(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Null reference");
    }

    public static void assertNotUiThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void assertUiThread(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static String checkNonEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static <T> T checkNonNull(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Null reference");
    }

    public static int checkNonZero(int i11) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static long checkNotZero(long j11) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static void assertHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T assertNonNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static <T> T checkNonNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static int checkNonZero(int i11, String str) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static long checkNotZero(long j11, String str) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static void assertNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException(String.valueOf(str2));
        }
    }

    public static String checkNonEmpty(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2));
    }
}
