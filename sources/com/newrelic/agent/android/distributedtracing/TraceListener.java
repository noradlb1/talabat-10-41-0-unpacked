package com.newrelic.agent.android.distributedtracing;

import java.util.Map;

public interface TraceListener {
    void onSpanCreated(Map<String, String> map);

    void onTraceCreated(Map<String, String> map);
}
