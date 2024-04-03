package com.newrelic.agent.android.analytics;

import java.util.Set;

public class UserActionEvent extends AnalyticsEvent {
    public UserActionEvent(String str, Set<AnalyticsAttribute> set) {
        super(str, AnalyticsEventCategory.UserAction, AnalyticsEvent.EVENT_TYPE_MOBILE_USER_ACTION, set);
    }
}
