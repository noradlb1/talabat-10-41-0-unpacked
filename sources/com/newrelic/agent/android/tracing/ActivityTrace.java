package com.newrelic.agent.android.tracing;

import com.facebook.internal.security.CertificateUtil;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ActivityTrace extends HarvestableArray {
    private static final HashMap<String, String> ACTIVITY_HISTORY_TYPE = new HashMap<String, String>() {
        {
            put("type", "ACTIVITY_HISTORY");
        }
    };
    private static final HashMap<String, String> ENVIRONMENT_TYPE = new HashMap<String, String>() {
        {
            put("type", "ENVIRONMENT");
        }
    };
    public static final int MAX_TRACES = 2000;
    private static final String SIZE_NORMAL = "NORMAL";
    public static final String TRACE_VERSION = "1.0";
    private static final HashMap<String, String> VITALS_TYPE = new HashMap<String, String>() {
        {
            put("type", "VITALS");
        }
    };
    private boolean complete;
    public long lastUpdatedAt;
    private final AgentLog log;
    private NamedActivity measuredActivity;
    private final Set<UUID> missingChildren;
    public final Metric networkCountMetric;
    public final Metric networkTimeMetric;
    private final HashMap<String, String> params;
    public ActivitySighting previousActivity;
    private long reportAttemptCount;
    public Trace rootTrace;
    public long startedAt;
    private int traceCount;
    private final ConcurrentHashMap<UUID, Trace> traces;
    private Map<Sample.SampleType, Collection<Sample>> vitals;

    public ActivityTrace() {
        this.traces = new ConcurrentHashMap<>();
        this.traceCount = 0;
        this.missingChildren = Collections.synchronizedSet(new HashSet());
        this.reportAttemptCount = 0;
        this.complete = false;
        this.params = new HashMap<>();
        this.log = AgentLogManager.getAgentLog();
        this.networkCountMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_COUNT_FORMAT);
        this.networkTimeMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_TIME_FORMAT);
    }

    private JsonArray getEnvironment() {
        JsonArray jsonArray = new JsonArray();
        Gson gson = new Gson();
        HashMap<String, String> hashMap = ENVIRONMENT_TYPE;
        Type type = BaseHarvestable.GSON_STRING_MAP_TYPE;
        jsonArray.add(gson.toJsonTree(hashMap, type));
        jsonArray.addAll(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()).asJsonArray());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(BindingAdaptersKt.QUERY_SIZE, SIZE_NORMAL);
        jsonArray.add(new Gson().toJsonTree(hashMap2, type));
        return jsonArray;
    }

    private JsonArray getPreviousActivityAsJson() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().toJsonTree(ACTIVITY_HISTORY_TYPE, BaseHarvestable.GSON_STRING_MAP_TYPE));
        jsonArray.addAll(this.previousActivity.asJsonArray());
        return jsonArray;
    }

    private JsonArray getVitalsAsJson() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().toJsonTree(VITALS_TYPE, BaseHarvestable.GSON_STRING_MAP_TYPE));
        JsonObject jsonObject = new JsonObject();
        Map<Sample.SampleType, Collection<Sample>> map = this.vitals;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                JsonArray jsonArray2 = new JsonArray();
                for (Sample sample : (Collection) next.getValue()) {
                    if (sample.getTimestamp() <= this.lastUpdatedAt) {
                        jsonArray2.add((JsonElement) sample.asJsonArray());
                    }
                }
                jsonObject.add(((Sample.SampleType) next.getKey()).toString(), jsonArray2);
            }
        }
        jsonArray.add((JsonElement) jsonObject);
        return jsonArray;
    }

    private JsonArray traceToTree(Trace trace) {
        JsonArray jsonArray = new JsonArray();
        trace.prepareForSerialization();
        jsonArray.add(new Gson().toJsonTree(trace.getParams(), BaseHarvestable.GSON_STRING_MAP_TYPE));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(trace.entryTimestamp)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(trace.exitTimestamp)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(trace.displayName));
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(trace.threadId)));
        jsonArray2.add((JsonElement) SafeJsonPrimitive.factory(trace.threadName));
        jsonArray.add((JsonElement) jsonArray2);
        if (trace.getChildren().isEmpty()) {
            jsonArray.add((JsonElement) new JsonArray());
        } else {
            JsonArray jsonArray3 = new JsonArray();
            for (UUID uuid : trace.getChildren()) {
                Trace trace2 = this.traces.get(uuid);
                if (trace2 != null) {
                    jsonArray3.add((JsonElement) traceToTree(trace2));
                }
            }
            jsonArray.add((JsonElement) jsonArray3);
        }
        return jsonArray;
    }

    public void addCompletedTrace(Trace trace) {
        if (trace.getType() == TraceType.NETWORK) {
            this.networkCountMetric.sample(1.0d);
            this.networkTimeMetric.sample((double) trace.getDurationAsSeconds());
            Trace trace2 = this.rootTrace;
            if (trace2 != null) {
                trace2.childExclusiveTime += trace.getDurationAsMilliseconds();
            }
        }
        trace.traceMachine = null;
        this.missingChildren.remove(trace.myUUID);
        if (this.traceCount > 2000) {
            this.log.verbose("Maximum trace limit reached, discarding trace " + trace.myUUID);
            return;
        }
        this.traces.put(trace.myUUID, trace);
        this.traceCount++;
        long j11 = trace.exitTimestamp;
        Trace trace3 = this.rootTrace;
        if (j11 > trace3.exitTimestamp) {
            trace3.exitTimestamp = j11;
        }
        this.log.verbose("Added trace " + trace.myUUID.toString() + " missing children: " + this.missingChildren.size());
        this.lastUpdatedAt = System.currentTimeMillis();
    }

    public void addTrace(Trace trace) {
        this.missingChildren.add(trace.myUUID);
        this.lastUpdatedAt = System.currentTimeMillis();
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        if (!this.complete) {
            AgentLog agentLog = this.log;
            String uuid = this.rootTrace.myUUID.toString();
            agentLog.verbose("Attempted to serialize trace " + uuid + " but it has yet to be finalized");
            return null;
        }
        jsonArray.add(new Gson().toJsonTree(this.params, BaseHarvestable.GSON_STRING_MAP_TYPE));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.rootTrace.entryTimestamp)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.rootTrace.exitTimestamp)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.rootTrace.displayName));
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add((JsonElement) getEnvironment());
        jsonArray2.add((JsonElement) traceToTree(this.rootTrace));
        jsonArray2.add((JsonElement) getVitalsAsJson());
        if (this.previousActivity != null) {
            jsonArray2.add((JsonElement) getPreviousActivityAsJson());
        }
        jsonArray.add((JsonElement) jsonArray2);
        return jsonArray;
    }

    public void complete() {
        AgentLog agentLog = this.log;
        Trace trace = this.rootTrace;
        String str = trace.displayName;
        String uuid = trace.myUUID.toString();
        int size = this.traces.size();
        agentLog.debug("Completing trace of " + str + CertificateUtil.DELIMITER + uuid + "(" + size + " traces)");
        Trace trace2 = this.rootTrace;
        if (trace2.exitTimestamp == 0) {
            trace2.exitTimestamp = System.currentTimeMillis();
        }
        if (this.traces.isEmpty()) {
            this.rootTrace.traceMachine = null;
            this.complete = true;
            Measurements.endActivityWithoutMeasurement(this.measuredActivity);
            return;
        }
        this.measuredActivity.setEndTime(this.rootTrace.exitTimestamp);
        Measurements.endActivity((MeasuredActivity) this.measuredActivity);
        this.rootTrace.traceMachine = null;
        this.complete = true;
        TaskQueue.queue(this);
    }

    public void discard() {
        AgentLog agentLog = this.log;
        Trace trace = this.rootTrace;
        String str = trace.displayName;
        String uuid = trace.myUUID.toString();
        int size = this.traces.size();
        agentLog.debug("Discarding trace of " + str + CertificateUtil.DELIMITER + uuid + "(" + size + " traces)");
        this.rootTrace.traceMachine = null;
        this.complete = true;
        Measurements.endActivityWithoutMeasurement(this.measuredActivity);
    }

    public String getActivityName() {
        int indexOf;
        Trace trace = this.rootTrace;
        if (trace == null) {
            return "<activity>";
        }
        String str = trace.displayName;
        if (str == null || (indexOf = str.indexOf("#")) <= 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public String getId() {
        Trace trace = this.rootTrace;
        if (trace == null) {
            return null;
        }
        return trace.myUUID.toString();
    }

    public long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public long getReportAttemptCount() {
        return this.reportAttemptCount;
    }

    public Map<UUID, Trace> getTraces() {
        return this.traces;
    }

    public boolean hasMissingChildren() {
        return !this.missingChildren.isEmpty();
    }

    public void incrementReportAttemptCount() {
        this.reportAttemptCount++;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setLastUpdatedAt(long j11) {
        this.lastUpdatedAt = j11;
    }

    public void setVitals(Map<Sample.SampleType, Collection<Sample>> map) {
        this.vitals = map;
    }

    public ActivityTrace(Trace trace) {
        this.traces = new ConcurrentHashMap<>();
        this.traceCount = 0;
        this.missingChildren = Collections.synchronizedSet(new HashSet());
        this.reportAttemptCount = 0;
        this.complete = false;
        HashMap<String, String> hashMap = new HashMap<>();
        this.params = hashMap;
        this.log = AgentLogManager.getAgentLog();
        this.networkCountMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_COUNT_FORMAT);
        this.networkTimeMetric = new Metric(MetricNames.ACTIVITY_NETWORK_METRIC_TIME_FORMAT);
        this.rootTrace = trace;
        long j11 = trace.entryTimestamp;
        this.lastUpdatedAt = j11;
        this.startedAt = j11;
        hashMap.put("traceVersion", "1.0");
        hashMap.put("type", "ACTIVITY");
        NamedActivity namedActivity = (NamedActivity) Measurements.startActivity(trace.displayName);
        this.measuredActivity = namedActivity;
        namedActivity.setStartTime(trace.entryTimestamp);
    }
}
