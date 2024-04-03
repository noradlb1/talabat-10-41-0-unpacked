package com.huawei.wisesecurity.ucs.common.log;

import android.util.Log;
import java.text.MessageFormat;

public class LogUcs {
    public static final String TAG_PREFIX = "UCS";
    public static ILogUcs ucsLog = new LogUcsDefault();

    public static void d(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = ucsLog;
        if (iLogUcs != null) {
            iLogUcs.d(genTag(str), format(str, str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = ucsLog;
        if (iLogUcs != null) {
            iLogUcs.e(genTag(str), format(str, str2, objArr));
        }
    }

    public static String format(String str, String str2, Object... objArr) {
        try {
            return MessageFormat.format(str2, objArr);
        } catch (Throwable th2) {
            Log.e(str, "log error : " + th2.getMessage());
            return "return default";
        }
    }

    public static String genTag(String str) {
        return "UCS-" + str;
    }

    public static void i(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = ucsLog;
        if (iLogUcs != null) {
            iLogUcs.i(genTag(str), format(str, str2, objArr));
        }
    }

    public static void init(ILogUcs iLogUcs) {
        if (iLogUcs != null) {
            ucsLog = iLogUcs;
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = ucsLog;
        if (iLogUcs != null) {
            iLogUcs.w(genTag(str), format(str, str2, objArr));
        }
    }
}
