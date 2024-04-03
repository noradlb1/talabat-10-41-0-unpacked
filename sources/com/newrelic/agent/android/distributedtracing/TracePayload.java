package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class TracePayload implements TraceHeader {
    static final String ACCOUNT_ID_KEY = "ac";
    static final String APP_ID_KEY = "ap";
    static final String CALLER_TYPE = "Mobile";
    static final String DATA_KEY = "d";
    static final String GUID_KEY = "id";
    static final int MAJOR_VERSION = 0;
    static final int MINOR_VERSION = 2;
    static final String PAYLOAD_TYPE_KEY = "ty";
    static final String TIMESTAMP_KEY = "ti";
    static final String TRACE_ID_KEY = "tr";
    public static final String TRACE_PAYLOAD_HEADER = "newrelic";
    static final String TRUST_ACCOUNT_KEY = "tk";
    static final String VERSION_KEY = "v";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    final String spanId;
    final long timestampMs = DistributedTracing.generateNormalizedTimestamp();
    final TraceContext traceContext;

    public TracePayload(TraceContext traceContext2) {
        String str;
        this.traceContext = traceContext2;
        TracePayload tracePayload = traceContext2.tracePayload;
        if (tracePayload == null) {
            str = traceContext2.getParentId();
        } else {
            str = tracePayload.spanId;
        }
        this.spanId = str;
    }

    public String asBase64Json() {
        try {
            return Agent.getEncoder().encodeNoWrap(asJson().toString().getBytes());
        } catch (Exception e11) {
            AgentLog agentLog = log;
            String localizedMessage = e11.getLocalizedMessage();
            agentLog.error("asBase64Json: " + localizedMessage);
            return "";
        }
    }

    public JsonObject asJson() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2 = new JsonObject();
        try {
            jsonArray.add((JsonElement) new JsonPrimitive((Number) 0));
            jsonArray.add((JsonElement) new JsonPrimitive((Number) 2));
            jsonObject2.add(PAYLOAD_TYPE_KEY, new JsonPrimitive("Mobile"));
            jsonObject2.add("ac", new JsonPrimitive(this.traceContext.traceConfiguration.accountId));
            jsonObject2.add(APP_ID_KEY, new JsonPrimitive(this.traceContext.traceConfiguration.applicationId));
            jsonObject2.add(TRACE_ID_KEY, new JsonPrimitive(this.traceContext.traceId));
            jsonObject2.add("id", new JsonPrimitive(this.spanId));
            jsonObject2.add(TIMESTAMP_KEY, new JsonPrimitive((Number) Long.valueOf(this.timestampMs)));
            jsonObject2.add(TRUST_ACCOUNT_KEY, new JsonPrimitive(this.traceContext.traceConfiguration.trustedAccountId));
            jsonObject.add("v", jsonArray);
            jsonObject.add("d", jsonObject2);
        } catch (Exception e11) {
            log.error("Unable to create payload asJSON", e11);
        }
        return jsonObject;
    }

    public String getHeaderName() {
        return TRACE_PAYLOAD_HEADER;
    }

    public String getHeaderValue() {
        return asBase64Json();
    }

    public String getSpanId() {
        return this.spanId;
    }

    public String getTraceId() {
        return this.traceContext.getTraceId();
    }
}
