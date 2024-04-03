package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "6.0.11.300";
    private static String sAppVersion = "";

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w(TAG, "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return sAppVersion;
        }
        try {
            sAppVersion = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w(TAG, "Failed to get Package managers Package Info");
        }
        return sAppVersion;
    }

    private static Bundle getBundleFromApp(Context context) {
        PackageManager packageManager;
        Bundle bundle;
        Bundle bundle2 = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return bundle2;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return bundle2;
            }
            return bundle;
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            Logger.w(TAG, "NameNotFoundException:", e11);
            return bundle2;
        }
    }

    private static Bundle getBundleFromKit(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.v(TAG, "the kitContext is null");
            return Bundle.EMPTY;
        } else if (context.getApplicationInfo() == null) {
            Logger.v(TAG, "the kit applicationInfo is null");
            return Bundle.EMPTY;
        } else {
            Logger.i(TAG, "kitContext: " + context.getPackageName());
            Bundle bundle = context.getApplicationInfo().metaData;
            if (bundle == null) {
                return Bundle.EMPTY;
            }
            return bundle;
        }
    }

    private static Bundle getBundleFromKitOrAPP(Context context) {
        Bundle bundleFromKit = getBundleFromKit(context);
        if (bundleFromKit == null || bundleFromKit.isEmpty()) {
            return getBundleFromApp(context);
        }
        return bundleFromKit;
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle bundleFromApp = getBundleFromApp(context);
        if (bundleFromApp != null) {
            return bundleFromApp.getString(str, str2);
        }
        return str2;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle bundleFromKit = getBundleFromKit(context);
            if (bundleFromKit == null) {
                return str2;
            }
            return bundleFromKit.getString(str, str2);
        } catch (RuntimeException unused) {
            Logger.v(TAG, "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        return getBundleFromKitOrAPP(context).getString(str, str2);
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
        for (String next : bundleFromKitOrAPP.keySet()) {
            if (next.startsWith(str)) {
                String string = bundleFromKitOrAPP.getString(next);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(next.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }
}
