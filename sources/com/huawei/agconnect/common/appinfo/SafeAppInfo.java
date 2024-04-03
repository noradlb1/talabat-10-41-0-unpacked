package com.huawei.agconnect.common.appinfo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.agconnect.common.api.Logger;

public class SafeAppInfo {
    private static final String TAG = "SafeAppInfo";

    public static ApplicationInfo safeGetApplicationInfo(PackageManager packageManager, String str, int i11) {
        try {
            return packageManager.getApplicationInfo(str, i11);
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.e(TAG, "not found", e11);
            return null;
        } catch (RuntimeException unused) {
            Logger.e(TAG, "get ApplicationInfo Exception: " + str);
            return null;
        }
    }

    public static PackageInfo safeGetPackageInfo(PackageManager packageManager, String str, int i11) {
        try {
            return packageManager.getPackageInfo(str, i11);
        } catch (PackageManager.NameNotFoundException e11) {
            Logger.e(TAG, "not found", e11);
            return null;
        } catch (RuntimeException unused) {
            Logger.e(TAG, "get PackageInfo Exception: " + str);
            return null;
        }
    }
}
