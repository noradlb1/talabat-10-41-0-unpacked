package com.huawei.hms.support.api.location.common;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;

public class HMSLocationLog {
    private static String compositeMessage(String str, String str2) {
        return "|" + str + "|" + str2;
    }

    private static String compositeTag(String str) {
        return "HMSSDK_HwLocation_" + str;
    }

    private static String compositeTagForHMSLog(String str) {
        return "HwLocation_" + str;
    }

    public static void d(String str, String str2, String str3) {
        HMSLog.d(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.d(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void e(String str, String str2, long j11, String str3) {
        HMSLog.e(compositeTagForHMSLog(str), j11, compositeMessage(str2, str3));
        LogWriteApi.e(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void e(String str, String str2, long j11, String str3, Throwable th2) {
        HMSLog.e(compositeTagForHMSLog(str), j11, compositeMessage(str2, str3), th2);
        LogWriteApi.e(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void e(String str, String str2, String str3) {
        HMSLog.e(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.e(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void e(String str, String str2, String str3, Throwable th2) {
        HMSLog.e(compositeTagForHMSLog(str), compositeMessage(str2, str3), th2);
        LogWriteApi.e(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void i(String str, String str2, String str3) {
        HMSLog.i(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.i(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }

    public static void w(String str, String str2, String str3) {
        HMSLog.w(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.w(compositeTag(str), compositeMessage(str2, str3), (Throwable) null);
    }
}
