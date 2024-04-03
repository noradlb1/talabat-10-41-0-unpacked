package com.huawei.hms.push.utils.ha;

public class PushAnalyticsCenter {

    /* renamed from: a  reason: collision with root package name */
    private PushBaseAnalytics f49798a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static PushAnalyticsCenter f49799a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f49799a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f49798a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f49798a = pushBaseAnalytics;
    }
}
