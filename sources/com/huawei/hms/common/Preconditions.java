package com.huawei.hms.common;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Locale;

public class Preconditions {
    private Preconditions() {
        throw new AssertionError("illegal Argument");
    }

    public static void checkArgument(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("The given thread is not the current thread.");
        }
    }

    public static void checkMainThread(String str) {
        if (!isMainThread()) {
            throw new IllegalStateException(str);
        }
    }

    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("The input parameter is empty.");
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void checkNotMainThread() {
        checkNotMainThread("The given thread is main thread.");
    }

    public static void checkNotMainThread(String str) {
        if (isMainThread()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("The input parameter is null.");
    }

    public static <T> T checkNotNull(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkNotZero(int i11) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException("The input parameter is 0.");
    }

    public static int checkNotZero(int i11, Object obj) {
        if (i11 != 0) {
            return i11;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static long checkNotZero(long j11) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException("The input parameter is 0.");
    }

    public static long checkNotZero(long j11, Object obj) {
        if (j11 != 0) {
            return j11;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void checkState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(String.format(Locale.ROOT, str, objArr));
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
