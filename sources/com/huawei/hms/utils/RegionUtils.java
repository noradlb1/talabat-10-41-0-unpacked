package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.visa.checkout.Profile;

public class RegionUtils {
    private static String a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return "";
        }
        return GrsApp.getInstance().getIssueCountryCode(context);
    }

    public static boolean isChinaROM(Context context) {
        return Profile.Country.CN.equalsIgnoreCase(a(context));
    }
}
