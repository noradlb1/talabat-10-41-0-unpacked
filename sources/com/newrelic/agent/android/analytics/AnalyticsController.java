package com.newrelic.agent.android.analytics;

import java.util.Map;
import java.util.Set;

public interface AnalyticsController {
    boolean addEvent(AnalyticsEvent analyticsEvent);

    boolean addEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set);

    boolean addEvent(String str, Set<AnalyticsAttribute> set);

    AnalyticsAttribute getAttribute(String str);

    EventManager getEventManager();

    int getMaxEventBufferTime();

    int getMaxEventPoolSize();

    int getSessionAttributeCount();

    Set<AnalyticsAttribute> getSessionAttributes();

    int getSystemAttributeCount();

    Set<AnalyticsAttribute> getSystemAttributes();

    int getUserAttributeCount();

    Set<AnalyticsAttribute> getUserAttributes();

    boolean incrementAttribute(String str, double d11);

    boolean incrementAttribute(String str, double d11, boolean z11);

    boolean recordCustomEvent(String str, Map<String, Object> map);

    boolean recordEvent(String str, Map<String, Object> map);

    boolean removeAllAttributes();

    boolean removeAttribute(String str);

    boolean setAttribute(String str, double d11);

    boolean setAttribute(String str, double d11, boolean z11);

    boolean setAttribute(String str, String str2);

    boolean setAttribute(String str, String str2, boolean z11);

    boolean setAttribute(String str, boolean z11);

    boolean setAttribute(String str, boolean z11, boolean z12);

    void setMaxEventBufferTime(int i11);

    void setMaxEventPoolSize(int i11);
}
