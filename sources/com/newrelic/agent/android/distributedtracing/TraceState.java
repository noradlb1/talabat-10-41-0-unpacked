package com.newrelic.agent.android.distributedtracing;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class TraceState implements TraceHeader {
    public static final String TRACE_STATE_HEADER = "tracestate";
    static final int TRACE_STATE_PARENT_TYPE = 2;
    static final int TRACE_STATE_VERSION = 0;
    final Map<String, String> entries = new HashMap();
    final long timestampMs = DistributedTracing.generateNormalizedTimestamp();
    final TraceContext traceContext;

    public static class W3CTraceState extends TraceState {
        static final String TRACE_STATE_ENTRY_REGEX = "(\\d)-(\\d+)-(\\d+)?-(\\d+)?-(\\w*)?-(\\w+)?-(\\d{1,2})?-(\\w)?-(\\d+)$";
        static final String TRACE_STATE_HEADER_FMT = "%1d-%1d-%s-%s-%s-%s-%s-%s-%d";
        static final String TRACE_STATE_HEADER_REGEX = "^(\\d+)?@nr=(\\d)-(\\d)-(\\d+)?-(\\d+)?-(\\w+)?-(\\w)?-(\\d{1,2})?-(\\w)?-(\\d+)$";
        static final String TRACE_STATE_VENDOR_REGEX = "^(\\d+?)(@nr)(=.*)?";

        public W3CTraceState(TraceContext traceContext) {
            super(traceContext);
            this.entries.put(traceContext.getVendor(), getVendorState());
        }

        public String getHeaderValue() {
            StringBuilder sb2 = new StringBuilder();
            for (String next : this.entries.keySet()) {
                sb2.append(String.format("%s=%s,", new Object[]{next, this.entries.get(next)}));
            }
            sb2.deleteCharAt(sb2.length() - 1);
            return sb2.toString();
        }

        public String getVendorState() {
            return String.format(Locale.ROOT, TRACE_STATE_HEADER_FMT, new Object[]{0, 2, this.traceContext.getAccountId(), this.traceContext.getApplicationId(), this.traceContext.getParentId(), "", "", "", Long.valueOf(this.timestampMs)});
        }
    }

    public TraceState(TraceContext traceContext2) {
        this.traceContext = traceContext2;
    }

    public static TraceState createTraceState(TraceContext traceContext2) {
        return new W3CTraceState(traceContext2);
    }

    public String getHeaderName() {
        return TRACE_STATE_HEADER;
    }
}
