package com.newrelic.agent.android.analytics;

import java.util.Set;

public class CustomEvent extends AnalyticsEvent {
    public CustomEvent(String str) {
        super(str, AnalyticsEventCategory.Custom);
    }

    public CustomEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Custom, (String) null, set);
    }

    public CustomEvent(String str, String str2, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Custom, str2, set);
    }
}
