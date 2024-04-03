package com.newrelic.agent.android.distributedtracing;

public interface TraceHeader {
    String getHeaderName();

    String getHeaderValue();
}
