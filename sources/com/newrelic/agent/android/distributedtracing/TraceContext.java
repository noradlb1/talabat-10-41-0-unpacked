package com.newrelic.agent.android.distributedtracing;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class TraceContext {
    public static final String INVALID_SPAN_ID = "0000000000000000";
    public static final String INVALID_TRACE_ID = "00000000000000000000000000000000";
    static final String SPAN_ID_REGEX = "^([A-Fa-f0-9]{16})?";
    public static final String SUPPORTABILITY_TRACE_CONTEXT_CREATED = "Supportability/TraceContext/Create/Success";
    public static final String SUPPORTABILITY_TRACE_CONTEXT_EXCEPTION = "Supportability/TraceContext/Create/Exception/%s";
    static final String TRACE_FIELD_UNUSED = "";
    static final String TRACE_ID_REGEX = "^[A-Fa-f0-9]{32}";
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    boolean legacyHeadersEnabled = true;
    final Map<String, String> requestContext;
    final TraceConfiguration traceConfiguration = TraceConfiguration.getInstance();
    final String traceId;
    final TraceParent traceParent;
    final TracePayload tracePayload;
    final TraceState traceState;

    public static class W3CTraceContext extends TraceContext {
        public W3CTraceContext(Map<String, String> map) {
            super(map);
        }

        public Set<TraceHeader> getHeaders() {
            Set<TraceHeader> headers = TraceContext.super.getHeaders();
            headers.add(this.traceParent);
            headers.add(this.traceState);
            return headers;
        }

        public String getParentId() {
            return this.traceParent.getParentId();
        }
    }

    public TraceContext(Map<String, String> map) {
        map = map == null ? new HashMap<>() : map;
        this.requestContext = map;
        this.traceId = DistributedTracing.generateTraceId();
        this.traceParent = TraceParent.createTraceParent(this);
        this.traceState = TraceState.createTraceState(this);
        this.tracePayload = new TracePayload(this);
        map.put("thread.id", String.valueOf(Thread.currentThread().getId()));
    }

    public static TraceContext createTraceContext(Map<String, String> map) {
        return new W3CTraceContext(map);
    }

    public static void reportSupportabilityExceptionMetric(Exception exc) {
        log.error("setDistributedTraceHeaders: Unable to add trace headers. ", exc);
        StatsEngine.get().inc(String.format(Locale.ROOT, SUPPORTABILITY_TRACE_CONTEXT_EXCEPTION, new Object[]{exc.getClass().getSimpleName()}));
    }

    public static void reportSupportabilityMetrics() {
        StatsEngine.get().inc(SUPPORTABILITY_TRACE_CONTEXT_CREATED);
    }

    public Map<String, Object> asTraceAttributes() {
        return new HashMap<String, Object>() {
            {
                put("id", TraceContext.this.tracePayload.spanId);
                put(DistributedTracing.NR_GUID_ATTRIBUTE, TraceContext.this.tracePayload.spanId);
                put(DistributedTracing.NR_TRACE_ID_ATTRIBUTE, TraceContext.this.traceId);
            }
        };
    }

    public String getAccountId() {
        return String.format(Locale.ROOT, LogWriteConstants.LOCATION_MSG_FORMAT, new Object[]{this.traceConfiguration.accountId});
    }

    public String getApplicationId() {
        return String.format(Locale.ROOT, LogWriteConstants.LOCATION_MSG_FORMAT, new Object[]{this.traceConfiguration.applicationId});
    }

    public Set<TraceHeader> getHeaders() {
        return new HashSet<TraceHeader>() {
            {
                if (TraceContext.this.legacyHeadersEnabled) {
                    add(TraceContext.this.tracePayload);
                }
            }
        };
    }

    public String getParentId() {
        return this.traceParent.getParentId();
    }

    public Map<String, String> getRequestContext() {
        return this.requestContext;
    }

    public String getSampled() {
        return String.format(Locale.ROOT, "%02x", new Object[]{Integer.valueOf(this.traceConfiguration.isSampled() ? 1 : 0)});
    }

    public String getTraceId() {
        return this.traceId;
    }

    public TracePayload getTracePayload() {
        return this.tracePayload;
    }

    public String getVendor() {
        return String.format(Locale.ROOT, "%s@nr", new Object[]{this.traceConfiguration.trustedAccountId});
    }

    public void putRequestContext(Map<String, String> map) {
        if (map != null) {
            this.requestContext.putAll(map);
        }
    }
}
