package com.newrelic.agent.android.distributedtracing;

import java.util.Locale;

public abstract class TraceParent implements TraceHeader {
    public static final String TRACE_PARENT_HEADER = "traceparent";
    static final String TRACE_PARENT_HEADER_FMT = "%s-%s-%s-%s";
    static final int TRACE_PARENT_VERSION = 0;
    final String parentId = DistributedTracing.generateSpanId();
    final TraceContext traceContext;

    public static class W3CTraceParent extends TraceParent {
        static final String TRACE_PARENT_HEADER_REGEX = "^(\\d+)-([A-Fa-f0-9]{32})-([A-Fa-f0-9]{16})?-(\\d+)$";

        public W3CTraceParent(TraceContext traceContext) {
            super(traceContext);
        }

        public String getHeaderValue() {
            Locale locale = Locale.ROOT;
            TraceContext traceContext = this.traceContext;
            return String.format(locale, TraceParent.TRACE_PARENT_HEADER_FMT, new Object[]{getVersion(), traceContext.traceId, this.parentId, traceContext.getSampled()});
        }
    }

    public TraceParent(TraceContext traceContext2) {
        this.traceContext = traceContext2;
    }

    public static TraceParent createTraceParent(TraceContext traceContext2) {
        return new W3CTraceParent(traceContext2);
    }

    public String getHeaderName() {
        return TRACE_PARENT_HEADER;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getVersion() {
        return String.format(Locale.ROOT, "%02x", new Object[]{0});
    }
}
