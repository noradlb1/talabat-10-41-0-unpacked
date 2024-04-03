package com.newrelic.agent.android.analytics;

import java.util.Set;

public class SessionEvent extends AnalyticsEvent {
    public SessionEvent() {
        super((String) null, AnalyticsEventCategory.Session);
    }

    public SessionEvent(Set<AnalyticsAttribute> set) {
        super((String) null, AnalyticsEventCategory.Session, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }
}
