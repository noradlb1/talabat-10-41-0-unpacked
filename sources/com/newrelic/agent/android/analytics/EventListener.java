package com.newrelic.agent.android.analytics;

public interface EventListener {
    boolean onEventAdded(AnalyticsEvent analyticsEvent);

    boolean onEventEvicted(AnalyticsEvent analyticsEvent);

    void onEventFlush();

    boolean onEventOverflow(AnalyticsEvent analyticsEvent);

    void onEventQueueSizeExceeded(int i11);

    void onEventQueueTimeExceeded(int i11);

    void onShutdown();

    void onStart(EventManager eventManager);
}
