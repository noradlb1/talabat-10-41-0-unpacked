package com.newrelic.agent.android.analytics;

import java.util.Set;

public class CrashEvent extends AnalyticsEvent {
    public CrashEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Crash, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }
}
