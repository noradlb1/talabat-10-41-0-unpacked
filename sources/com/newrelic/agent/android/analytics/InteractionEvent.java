package com.newrelic.agent.android.analytics;

import java.util.Set;

public class InteractionEvent extends AnalyticsEvent {
    public InteractionEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.Interaction, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }
}
