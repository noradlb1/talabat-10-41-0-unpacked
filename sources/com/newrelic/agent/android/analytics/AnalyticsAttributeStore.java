package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.payload.PayloadStore;
import java.util.List;

public interface AnalyticsAttributeStore extends PayloadStore<AnalyticsAttribute> {
    void clear();

    int count();

    void delete(AnalyticsAttribute analyticsAttribute);

    /* bridge */ /* synthetic */ void delete(Object obj);

    List<AnalyticsAttribute> fetchAll();

    boolean store(AnalyticsAttribute analyticsAttribute);

    /* bridge */ /* synthetic */ boolean store(Object obj);
}
