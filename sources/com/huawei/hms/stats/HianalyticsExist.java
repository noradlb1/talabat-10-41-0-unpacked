package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.wisesecurity.ucs.credential.outer.Selector;

public class HianalyticsExist {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f49801a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49802b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49803c = false;

    public static boolean isHianalyticsExist() {
        synchronized (f49801a) {
            if (!f49802b) {
                try {
                    Class.forName(Selector.HA_FEATURE_CLASS);
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                f49802b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f49803c);
            }
        }
        return f49803c;
    }
}
