package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.AgentConfiguration;
import java.util.Collection;

public interface EventManager {
    boolean addEvent(AnalyticsEvent analyticsEvent);

    void empty();

    int getEventsDropped();

    int getEventsEjected();

    int getEventsRecorded();

    int getMaxEventBufferTime();

    int getMaxEventPoolSize();

    Collection<AnalyticsEvent> getQueuedEvents();

    void initialize(AgentConfiguration agentConfiguration);

    boolean isMaxEventBufferTimeExceeded();

    boolean isMaxEventPoolSizeExceeded();

    boolean isTransmitRequired();

    void setEventListener(EventListener eventListener);

    void setMaxEventBufferTime(int i11);

    void setMaxEventPoolSize(int i11);

    void setTransmitRequired();

    void shutdown();

    int size();
}
