package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.HttpUrl;

public class Utils {
    private static Boolean isDebugLoggingEnabled;

    public static int bufferToInt(@NonNull byte[] bArr) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < 4 && i11 < bArr.length) {
            i12 |= (bArr[i11] & 255) << (i11 * 8);
            i11++;
        }
        return i12;
    }

    public static void checkArgument(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean isDebugLoggingEnabled(@NonNull Context context) {
        Boolean bool = isDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            isDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e11) {
            AndroidLogger instance = AndroidLogger.getInstance();
            instance.debug("No perf logcat meta data found " + e11.getMessage());
            return false;
        }
    }

    public static int saturatedIntCast(long j11) {
        if (j11 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }

    public static String stripSensitiveInfo(@NonNull String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse != null) {
            return parse.newBuilder().username("").password("").query((String) null).fragment((String) null).toString();
        }
        return str;
    }

    public static String truncateURL(String str, int i11) {
        int lastIndexOf;
        if (str.length() <= i11) {
            return str;
        }
        if (str.charAt(i11) == '/') {
            return str.substring(0, i11);
        }
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            return str.substring(0, i11);
        }
        if (parse.encodedPath().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, i11 - 1)) < 0) {
            return str.substring(0, i11);
        }
        return str.substring(0, lastIndexOf);
    }
}
