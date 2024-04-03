package com.instabug.library.internal.device;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.Instabug;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.instabug.library.util.InstabugSDKLogger;

public class InstabugDeviceProperties {

    public class a implements ReturnableExecutable {
        /* renamed from: a */
        public Integer execute() throws Exception {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null) {
                return Integer.valueOf(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode);
            }
            return -1;
        }
    }

    public static boolean checkRingerIsOn(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null || audioManager.getRingerMode() == 2) {
            return true;
        }
        return false;
    }

    public static String getAppVersion(@NonNull Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return String.format("%s (%s)", new Object[]{packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)});
    }

    public static String getAppVersionName(@NonNull Context context) {
        return getPackageInfo(context).versionName;
    }

    public static int getCurrentOSLevel() {
        return Build.VERSION.SDK_INT;
    }

    @NonNull
    public static String getDeviceType() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    private static PackageInfo getPackageInfo(@NonNull Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e11) {
            InstabugSDKLogger.d("IBG-Core", "Failed to get package info" + e11);
            return new PackageInfo();
        }
    }

    public static String getPackageName(@NonNull Context context) {
        try {
            return context.getApplicationInfo().packageName;
        } catch (Exception e11) {
            InstabugSDKLogger.d("IBG-Core", "failed to get package name" + e11);
            return "Could not get information";
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static Integer getVersionCode() {
        return (Integer) new ExceptionHandler().withPenaltyLog("IBG-Core").executeAndGet(new a(), -1);
    }

    public static boolean isFirstInstall(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo(getPackageName(context), 0).firstInstallTime == context.getPackageManager().getPackageInfo(getPackageName(context), 0).lastUpdateTime) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return true;
        }
    }

    public static boolean isProbablyAnEmulator() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.BOARD.equals("QC_Reference_Phone")) {
                String str3 = Build.MANUFACTURER;
                if (str3.contains("Genymotion") || str3.contains("unknown") || Build.HOST.startsWith("Build") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isTablet(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
