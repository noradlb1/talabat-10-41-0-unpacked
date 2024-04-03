package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.ConfigurationCompat;
import com.instabug.library.Instabug;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.device.a;
import com.instabug.library.r0;
import java.io.File;

public class DeviceStateProvider {
    private static long calculateTotalMemory(Context context) {
        return calculateTotalMemoryApi16(context);
    }

    @TargetApi(16)
    private static long calculateTotalMemoryApi16(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f A[SYNTHETIC, Splitter:B:20:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[SYNTHETIC, Splitter:B:25:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long calculateTotalMemoryPreApi16() {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
            java.lang.String r2 = "/proc/meminfo"
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
            java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x003f }
            java.lang.String r2 = ":"
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ IOException -> 0x003f }
            r2 = 1
            r0 = r0[r2]     // Catch:{ IOException -> 0x003f }
            java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x003f }
            int r2 = r0.length()     // Catch:{ IOException -> 0x003f }
            int r2 = r2 + -3
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)     // Catch:{ IOException -> 0x003f }
            java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x003f }
            r1.close()     // Catch:{ IOException -> 0x003f }
            long r2 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x003f }
            r4 = 1024(0x400, double:5.06E-321)
            long r2 = r2 * r4
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003c:
            return r2
        L_0x003d:
            r0 = move-exception
            goto L_0x005a
        L_0x003f:
            r0 = move-exception
            goto L_0x004a
        L_0x0041:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x005a
        L_0x0046:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x004a:
            r0.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0057:
            r0 = 0
            return r0
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.DeviceStateProvider.calculateTotalMemoryPreApi16():long");
    }

    private static boolean externalMemoryAvailable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception | OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Couldn't get external Memory Available", e11);
            return false;
        }
    }

    public static long getActiveSessionDuration() {
        return r0.e().d();
    }

    public static String getAppPackageName(Context context) {
        return InstabugDeviceProperties.getPackageName(context);
    }

    public static String getAppVersion(Context context) {
        return InstabugDeviceProperties.getAppVersion(context);
    }

    @Nullable
    private static Context getApplicationContext() {
        return Instabug.getApplicationContext();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static int getBatteryLevel(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return (int) ((((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f);
            }
            InstabugSDKLogger.d("IBG-Core", "Could't obtain battery level");
            return -1;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Got error while get battery level", e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052 A[Catch:{ Exception -> 0x005b }, ORIG_RETURN, RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBatteryState(android.content.Context r7) {
        /*
            java.lang.String r0 = "IBG-Core"
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = "android.intent.action.BATTERY_CHANGED"
            r1.<init>(r2)     // Catch:{ Exception -> 0x005b }
            r2 = 0
            android.content.Intent r7 = r7.registerReceiver(r2, r1)     // Catch:{ Exception -> 0x005b }
            if (r7 == 0) goto L_0x0055
            java.lang.String r1 = "status"
            r2 = -1
            int r1 = r7.getIntExtra(r1, r2)     // Catch:{ Exception -> 0x005b }
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 != r6) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r1 = r4
            goto L_0x0024
        L_0x0023:
            r1 = r5
        L_0x0024:
            java.lang.String r6 = "plugged"
            int r7 = r7.getIntExtra(r6, r2)     // Catch:{ Exception -> 0x005b }
            if (r7 != r3) goto L_0x002e
            r2 = r5
            goto L_0x002f
        L_0x002e:
            r2 = r4
        L_0x002f:
            if (r7 != r5) goto L_0x0032
            r4 = r5
        L_0x0032:
            if (r1 == 0) goto L_0x0052
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r7.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r1 = "Charging"
            r7.append(r1)     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x0043
            java.lang.String r1 = " through AC Charger"
            goto L_0x004a
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            java.lang.String r1 = " through USB cable"
            goto L_0x004a
        L_0x0048:
            java.lang.String r1 = ""
        L_0x004a:
            r7.append(r1)     // Catch:{ Exception -> 0x005b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x005b }
            goto L_0x0054
        L_0x0052:
            java.lang.String r7 = "Unplugged"
        L_0x0054:
            return r7
        L_0x0055:
            java.lang.String r7 = "Could't obtain battery state"
            com.instabug.library.util.InstabugSDKLogger.d(r0, r7)     // Catch:{ Exception -> 0x005b }
            goto L_0x0061
        L_0x005b:
            r7 = move-exception
            java.lang.String r1 = "Got error while get battery state"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1, r7)
        L_0x0061:
            java.lang.String r7 = "Unknown"
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.DeviceStateProvider.getBatteryState(android.content.Context):java.lang.String");
    }

    public static String getCarrier(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Got error while get Carrier", e11);
            return "Unknown";
        }
    }

    public static String getDevice() {
        return InstabugDeviceProperties.getDeviceType();
    }

    public static String getDeviceArchitecture() {
        return Build.CPU_ABI;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((DisplayManager) context.getSystemService("display")).getDisplay(0).getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    @Nullable
    private static File getExternalCacheDir() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            return applicationContext.getExternalCacheDir();
        }
        return null;
    }

    public static long getFreeMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static long getFreeStorage() {
        try {
            File externalCacheDir = getExternalCacheDir();
            if (externalMemoryAvailable() && externalCacheDir != null) {
                return externalCacheDir.getUsableSpace() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate free storage");
            return -1;
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate free storage");
            return -1;
        }
    }

    public static String getLocale(Context context) {
        if (ConfigurationCompat.getLocales(context.getResources().getConfiguration()).size() > 0) {
            return ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0).toString();
        }
        return context.getResources().getConfiguration().locale.toString();
    }

    @NonNull
    public static String getOS() {
        return "OS Level " + Build.VERSION.SDK_INT;
    }

    public static String getScreenDensity(Context context) {
        int i11 = getDisplayMetrics(context).densityDpi;
        if (i11 < 160) {
            return "ldpi";
        }
        if (i11 < 240) {
            return "mdpi";
        }
        if (i11 < 320) {
            return "hdpi";
        }
        if (i11 < 480) {
            return "xhdpi";
        }
        if (i11 < 640) {
            return "xxhdpi";
        }
        return "xxxhdpi";
    }

    public static String getScreenOrientation(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
    }

    public static String getScreenSize(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return String.format("%sx%s", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
    }

    public static String getSdkVersion() {
        return "11.7.0";
    }

    public static long getTotalMemory(Context context) {
        long calculateTotalMemory = calculateTotalMemory(context);
        if (calculateTotalMemory != 0) {
            return calculateTotalMemory / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        InstabugSDKLogger.e("IBG-Core", "Got error while calculating total memory");
        return -1;
    }

    public static long getTotalStorage() {
        try {
            File externalCacheDir = getExternalCacheDir();
            if (externalMemoryAvailable() && externalCacheDir != null) {
                return (long) ((int) (externalCacheDir.getTotalSpace() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
            }
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate total storage");
            return -1;
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate total storage");
            return -1;
        }
    }

    public static long getUsedMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (calculateTotalMemory(context) - memoryInfo.availMem) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static long getUsedStorage() {
        try {
            File externalCacheDir = getExternalCacheDir();
            if (externalMemoryAvailable() && externalCacheDir != null) {
                return (externalCacheDir.getTotalSpace() - externalCacheDir.getFreeSpace()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate used storage");
            return -1;
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Got error while calculate used storage");
            return -1;
        }
    }

    public static boolean getWifiState(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Got error while get wifi state", e11);
            return false;
        }
    }

    public static boolean isDeviceRooted() {
        try {
            if (a.d()) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while checking if device is rooted or not " + e11.getMessage());
            return false;
        }
    }
}
