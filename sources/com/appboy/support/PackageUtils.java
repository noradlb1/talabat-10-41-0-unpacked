package com.appboy.support;

import android.content.Context;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;

public class PackageUtils {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) PackageUtils.class);
    private static String sPackageName;

    public static String getResourcePackageName(Context context) {
        String str = sPackageName;
        if (str != null) {
            return str;
        }
        String packageName = context.getPackageName();
        sPackageName = packageName;
        return packageName;
    }

    public static void setResourcePackageName(String str) {
        if (!StringUtils.isNullOrBlank(str)) {
            sPackageName = str;
        } else {
            BrazeLogger.w(TAG, "Package name may not be null or blank");
        }
    }
}
