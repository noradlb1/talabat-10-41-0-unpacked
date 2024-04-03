package com.newrelic.agent.android.analytics;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

public enum AnalyticsEventCategory {
    Session,
    Interaction,
    Crash,
    Custom,
    NetworkRequest,
    RequestError,
    Breadcrumb,
    UserAction;

    public static AnalyticsEventCategory fromString(String str) {
        AnalyticsEventCategory analyticsEventCategory = Custom;
        if (str == null) {
            return analyticsEventCategory;
        }
        if (str.equalsIgnoreCase(SDKCoreEvent.Session.TYPE_SESSION)) {
            return Session;
        }
        if (str.equalsIgnoreCase("interaction")) {
            return Interaction;
        }
        if (str.equalsIgnoreCase("crash")) {
            return Crash;
        }
        if (str.equalsIgnoreCase("requesterror")) {
            return RequestError;
        }
        if (str.equalsIgnoreCase("breadcrumb")) {
            return Breadcrumb;
        }
        if (str.equalsIgnoreCase("networkrequest")) {
            return NetworkRequest;
        }
        if (str.equalsIgnoreCase("useraction")) {
            return UserAction;
        }
        return analyticsEventCategory;
    }
}
