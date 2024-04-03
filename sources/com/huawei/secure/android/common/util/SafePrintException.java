package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

public abstract class SafePrintException {
    private static boolean a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i11 = 0; i11 < 10; i11++) {
            if (str.contains(strArr[i11])) {
                return true;
            }
        }
        return false;
    }

    public static String getStackTrace(String str, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        sb2.append("Exception: ");
        sb2.append(th2.getClass().getName());
        sb2.append(10);
        if (!a(th2.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace == null) {
                sb2.append("Stack trace is NULL!");
                sb2.append(10);
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append(stackTraceElement.toString());
                    sb2.append(10);
                }
            }
        }
        return sb2.toString();
    }

    public static void print(String str, String str2, Throwable th2) {
        if (th2 != null) {
            Log.w(str, getStackTrace(str2, th2));
        }
    }
}
