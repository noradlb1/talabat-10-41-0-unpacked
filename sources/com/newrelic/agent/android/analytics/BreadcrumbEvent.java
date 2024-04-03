package com.newrelic.agent.android.analytics;

import java.util.Set;

public class BreadcrumbEvent extends AnalyticsEvent {
    public BreadcrumbEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Breadcrumb, AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB, set);
    }
}
