package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

public class HiAnalyticsOfCpUtils {

    /* renamed from: a  reason: collision with root package name */
    private static HiAnalyticsInstance f49800a;

    private static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f49800a = analyticsInstance;
        return analyticsInstance;
    }

    public static void onEvent(Context context, String str, String str2) {
        if (a(context) != null) {
            f49800a.onEvent(context, str, str2);
        }
    }

    public static void onReport(Context context, int i11) {
        if (a(context) != null) {
            f49800a.onReport(i11);
        }
    }

    public static void onStreamEvent(Context context, int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f49800a.onStreamEvent(i11, str, linkedHashMap);
        }
    }

    public static void onEvent(Context context, int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f49800a.onEvent(i11, str, linkedHashMap);
        }
    }
}
