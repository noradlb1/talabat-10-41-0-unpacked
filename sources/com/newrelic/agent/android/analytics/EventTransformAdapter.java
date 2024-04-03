package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.agentdata.AgentDataController;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventTransformAdapter implements EventListener {
    final String REPLACEMENT = "*";
    final Map<String, Map<Pattern, String>> attributeTransforms = new HashMap();

    /* renamed from: em  reason: collision with root package name */
    EventManagerImpl f52779em = null;

    public String onAttributeTransform(String str, String str2) {
        Map map = this.attributeTransforms.get(str);
        if (map != null) {
            for (Pattern pattern : map.keySet()) {
                str2 = onPatternTransform(pattern, (String) map.get(pattern), str2);
            }
        }
        return str2;
    }

    public boolean onEventAdded(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventAdded(analyticsEvent);
        }
        return true;
    }

    public boolean onEventEvicted(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventEvicted(analyticsEvent);
        }
        return true;
    }

    public void onEventFlush() {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventFlush();
        }
    }

    public boolean onEventOverflow(AnalyticsEvent analyticsEvent) {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            return eventManagerImpl.onEventOverflow(analyticsEvent);
        }
        return false;
    }

    public void onEventQueueSizeExceeded(int i11) {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventQueueSizeExceeded(i11);
        }
    }

    public void onEventQueueTimeExceeded(int i11) {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onEventQueueTimeExceeded(i11);
        }
    }

    public void onEventTransform(AnalyticsEvent analyticsEvent) {
        for (AnalyticsAttribute next : analyticsEvent.getAttributeSet()) {
            if (this.attributeTransforms.containsKey(next.getName())) {
                next.setStringValue(onAttributeTransform(next.getName(), next.getStringValue()));
            }
        }
    }

    public String onPatternTransform(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str2);
        if (!matcher.find()) {
            return str2;
        }
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            sb2.append(str2);
            for (int i11 = 1; i11 <= matcher.groupCount(); i11++) {
                int start = matcher.start(i11);
                while (start < matcher.end(i11)) {
                    int i12 = start + 1;
                    sb2.replace(start, i12, "*");
                    start = i12;
                }
            }
        } else {
            sb2.append(matcher.replaceAll(str));
        }
        return sb2.toString();
    }

    public void onShutdown() {
        EventManagerImpl eventManagerImpl = this.f52779em;
        if (eventManagerImpl != null) {
            eventManagerImpl.onShutdown();
            this.f52779em = null;
        }
    }

    public void onStart(EventManager eventManager) {
        EventManagerImpl eventManagerImpl = (EventManagerImpl) eventManager;
        this.f52779em = eventManagerImpl;
        if (eventManagerImpl != null) {
            eventManagerImpl.onStart(eventManager);
        }
    }

    public EventTransformAdapter withAttributeTransform(String str, Map<String, String> map) {
        Map map2 = this.attributeTransforms.get(str);
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    map2.put(Pattern.compile((String) next.getKey()), (String) next.getValue());
                } catch (Exception e11) {
                    AgentDataController.sendAgentData(e11, new HashMap<String, Object>(next) {
                        final /* synthetic */ Map.Entry val$entry;

                        {
                            this.val$entry = r3;
                            put("transform", ((String) r3.getKey()) + "/" + ((String) r3.getValue()));
                        }
                    });
                }
            }
        }
        if (!map2.isEmpty()) {
            this.attributeTransforms.put(str, map2);
        }
        return this;
    }
}
