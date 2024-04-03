package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;

public class HiAnalyticsTools {
    public static void enableLog() {
        enableLog(3);
    }

    public static void enableLog(int i11) {
        HiLog.init(i11, "HiAnalyticsSDK");
    }
}
