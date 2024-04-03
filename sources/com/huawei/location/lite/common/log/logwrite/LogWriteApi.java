package com.huawei.location.lite.common.log.logwrite;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

public class LogWriteApi {
    private static final String TAG = "LogWriteApi";

    private static String compositeTag(String str, int i11, int i12) {
        return "(" + i11 + "|" + i12 + ")" + str;
    }

    public static void d(String str, String str2, Throwable th2) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("D", compositeTag(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog(ExifInterface.LONGITUDE_EAST, compositeTag(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("I", compositeTag(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    public static void init(LogWriteParam logWriteParam) {
        if (logWriteParam != null) {
            LogWriteManager.getInstance().init(logWriteParam);
        } else {
            Log.e(TAG, "logWriteParam is null stop init LogWriteManager");
        }
    }

    public static void printLocationInfo(String str, boolean z11) {
        if (LogWrite.isEnableWriteLog() && z11) {
            LogWriteManager.getInstance().appendLog(new AppLog(str, "location"));
        }
    }

    public static void v(String str, String str2, Throwable th2) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, compositeTag(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog(ExifInterface.LONGITUDE_WEST, compositeTag(str, Process.myPid(), Process.myTid()), str2, th2));
        }
    }
}
