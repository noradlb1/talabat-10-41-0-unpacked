package com.huawei.hms.analytics;

import android.os.Build;
import android.text.TextUtils;

public final class ad {
    public static boolean ghi() {
        return "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) || !TextUtils.isEmpty(dp.lmn("ro.miui.ui.version.name", ""));
    }

    public static boolean hij() {
        return "VIVO".equalsIgnoreCase(Build.MANUFACTURER) || !TextUtils.isEmpty(dp.lmn("ro.vivo.os.version", ""));
    }

    public static boolean ijk() {
        return "BLACKSHARK".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean ikl() {
        String str = Build.MANUFACTURER;
        return "OPPO".equalsIgnoreCase(str) || "REALME".equalsIgnoreCase(str) || !TextUtils.isEmpty(dp.lmn("ro.build.version.opporom", ""));
    }

    public static boolean klm() {
        return !TextUtils.isEmpty(av.lmn().lmn.lmn);
    }

    public static boolean lmn() {
        String str = Build.MANUFACTURER;
        return "HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }
}
