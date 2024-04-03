package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Keep;

@Keep
public class L {
    public static final String TAG = "Vision";

    public static int d(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return Log.d(TAG, String.format(str, objArr));
        }
        return 0;
    }

    public static int e(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 6)) {
            return Log.e(TAG, String.format(str, objArr));
        }
        return 0;
    }

    public static int i(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 4)) {
            return Log.i(TAG, String.format(str, objArr));
        }
        return 0;
    }

    public static int v(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 2)) {
            return Log.v(TAG, String.format(str, objArr));
        }
        return 0;
    }

    public static int w(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 5)) {
            return Log.w(TAG, String.format(str, objArr));
        }
        return 0;
    }

    public static int d(Throwable th2, String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return Log.d(TAG, String.format(str, objArr), th2);
        }
        return 0;
    }

    @SuppressLint({"LogTagMismatch"})
    public static int e(Throwable th2, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 6)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return Log.e(TAG, String.format(str, objArr), th2);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(format).length() + 2 + valueOf.length());
        sb2.append(format);
        sb2.append(": ");
        sb2.append(valueOf);
        return Log.e(TAG, sb2.toString());
    }

    @SuppressLint({"LogTagMismatch"})
    public static int w(Throwable th2, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 5)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return Log.w(TAG, String.format(str, objArr), th2);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(format).length() + 2 + valueOf.length());
        sb2.append(format);
        sb2.append(": ");
        sb2.append(valueOf);
        return Log.w(TAG, sb2.toString());
    }
}
