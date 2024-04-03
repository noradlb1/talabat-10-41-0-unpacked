package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.harvest.crash.DeviceInfo;
import com.newrelic.agent.android.harvest.crash.ExceptionInfo;
import com.newrelic.agent.android.harvest.crash.ThreadInfo;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonParser;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Crash extends HarvestableObject {
    public static final int MAX_UPLOAD_COUNT = 3;
    public static final int PROTOCOL_VERSION = 1;
    private ActivityHistory activityHistory;
    private boolean analyticsEnabled;
    private final String appToken;
    private ApplicationInfo applicationInfo;
    protected String buildId;
    private DeviceInfo deviceInfo;
    private Collection<AnalyticsEvent> events;
    private ExceptionInfo exceptionInfo;
    private Set<AnalyticsAttribute> sessionAttributes;
    private List<ThreadInfo> threads;
    protected long timestamp;
    private int uploadCount;
    private final UUID uuid;

    public Crash(UUID uuid2, String str, long j11) {
        AgentImpl impl = Agent.getImpl();
        this.uuid = uuid2;
        this.buildId = str;
        this.timestamp = j11;
        this.appToken = getAppToken();
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.exceptionInfo = new ExceptionInfo();
        this.threads = new ArrayList();
        this.activityHistory = new ActivityHistory(new ArrayList());
        this.sessionAttributes = new HashSet();
        this.events = new HashSet();
        this.analyticsEnabled = true;
        this.uploadCount = 0;
    }

    public static Crash crashFromJsonString(String str) {
        boolean z11;
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        String asString = asJsonObject.get("uuid").getAsString();
        Crash crash = new Crash(UUID.fromString(asString), asJsonObject.get(HexAttribute.HEX_ATTR_JSERROR_BUILDID).getAsString(), asJsonObject.get("timestamp").getAsLong());
        crash.deviceInfo = DeviceInfo.newFromJson(asJsonObject.get("deviceInfo").getAsJsonObject());
        crash.applicationInfo = ApplicationInfo.newFromJson(asJsonObject.get("appInfo").getAsJsonObject());
        crash.exceptionInfo = ExceptionInfo.newFromJson(asJsonObject.get("exception").getAsJsonObject());
        crash.threads = crash.newListFromJson(asJsonObject.get("threads").getAsJsonArray());
        crash.activityHistory = ActivityHistory.newFromJson(asJsonObject.get("activityHistory").getAsJsonArray());
        if (asJsonObject.has("sessionAttributes") || asJsonObject.has("analyticsEvents")) {
            z11 = true;
        } else {
            z11 = false;
        }
        crash.analyticsEnabled = z11;
        if (asJsonObject.has("sessionAttributes")) {
            crash.setSessionAttributes(AnalyticsAttribute.newFromJson(asJsonObject.get("sessionAttributes").getAsJsonObject()));
        }
        if (asJsonObject.has("analyticsEvents")) {
            crash.setAnalyticsEvents(AnalyticsEvent.newFromJson(asJsonObject.get("analyticsEvents").getAsJsonArray()));
        }
        if (asJsonObject.has("uploadCount")) {
            crash.uploadCount = asJsonObject.get("uploadCount").getAsInt();
        }
        return crash;
    }

    public static String getBuildId() {
        return Agent.getBuildId();
    }

    public static String getSafeBuildId() {
        String buildId2 = getBuildId();
        if (buildId2 == null || buildId2.isEmpty()) {
            buildId2 = Agent.getBuildId();
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_INVALID_BUILDID);
            if (buildId2 == null || buildId2.isEmpty()) {
                AgentLogManager.getAgentLog().error("Invalid (null or empty) build ID detected! Crash will be ignored by collector.");
            }
        }
        return buildId2;
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("protocolVersion", new JsonPrimitive((Number) 1));
        jsonObject.add("platform", new JsonPrimitive("Android"));
        jsonObject.add("uuid", SafeJsonPrimitive.factory(this.uuid.toString()));
        jsonObject.add(HexAttribute.HEX_ATTR_JSERROR_BUILDID, SafeJsonPrimitive.factory(this.buildId));
        jsonObject.add("timestamp", SafeJsonPrimitive.factory((Number) Long.valueOf(this.timestamp)));
        jsonObject.add("appToken", SafeJsonPrimitive.factory(this.appToken));
        jsonObject.add("deviceInfo", this.deviceInfo.asJsonObject());
        jsonObject.add("appInfo", this.applicationInfo.asJsonObject());
        jsonObject.add("exception", this.exceptionInfo.asJsonObject());
        jsonObject.add("threads", getThreadsAsJson());
        jsonObject.add("activityHistory", this.activityHistory.asJsonArrayWithoutDuration());
        JsonObject jsonObject2 = new JsonObject();
        Set<AnalyticsAttribute> set = this.sessionAttributes;
        if (set != null) {
            for (AnalyticsAttribute next : set) {
                jsonObject2.add(next.getName(), next.asJsonElement());
            }
        }
        jsonObject.add("sessionAttributes", jsonObject2);
        JsonArray jsonArray = new JsonArray();
        Collection<AnalyticsEvent> collection = this.events;
        if (collection != null) {
            for (AnalyticsEvent asJsonObject : collection) {
                jsonArray.add((JsonElement) asJsonObject.asJsonObject());
            }
        }
        jsonObject.add("analyticsEvents", jsonArray);
        DataToken dataToken = Harvest.getHarvestConfiguration().getDataToken();
        if (dataToken != null && dataToken.isValid()) {
            jsonObject.add("dataToken", dataToken.asJsonArray());
        }
        return jsonObject;
    }

    public List<ThreadInfo> extractThreads(Throwable th2) {
        return new ThreadInfo(th2).allThreads();
    }

    public String getAppToken() {
        if (CrashReporter.getInstance() != null) {
            return CrashReporter.getInstance().getAgentConfiguration().getApplicationToken();
        }
        return "<missing app token>";
    }

    public Set<AnalyticsAttribute> getCrashSessionAttributes(Set<AnalyticsAttribute> set) {
        if (set == null) {
            return null;
        }
        HashSet hashSet = new HashSet(set);
        hashSet.add(new AnalyticsAttribute("obfuscated", getIsObfuscated()));
        return Collections.unmodifiableSet(hashSet);
    }

    public ExceptionInfo getExceptionInfo() {
        return this.exceptionInfo;
    }

    public boolean getIsObfuscated() {
        return Agent.getIsObfuscated();
    }

    public Throwable getRootCause(Throwable th2) {
        if (th2 == null) {
            return new Throwable("Unknown cause");
        }
        try {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            return getRootCause(cause);
        } catch (Exception unused) {
            return th2;
        }
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        return this.sessionAttributes;
    }

    public JsonArray getThreadsAsJson() {
        JsonArray jsonArray = new JsonArray();
        List<ThreadInfo> list = this.threads;
        if (list != null) {
            for (ThreadInfo asJsonObject : list) {
                jsonArray.add((JsonElement) asJsonObject.asJsonObject());
            }
        }
        return jsonArray;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getUploadCount() {
        return this.uploadCount;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void incrementUploadCount() {
        this.uploadCount++;
    }

    public boolean isStale() {
        return this.uploadCount >= 3;
    }

    public List<ThreadInfo> newListFromJson(JsonArray jsonArray) {
        return new ThreadInfo().newListFromJson(jsonArray);
    }

    public void setAnalyticsEvents(Collection<AnalyticsEvent> collection) {
        this.events = collection;
    }

    public void setSessionAttributes(Set<AnalyticsAttribute> set) {
        this.sessionAttributes = getCrashSessionAttributes(set);
    }

    public Crash(Throwable th2) {
        this(th2, new HashSet(), new HashSet(), false);
    }

    public Crash(Throwable th2, Set<AnalyticsAttribute> set, Collection<AnalyticsEvent> collection, boolean z11) {
        AgentImpl impl = Agent.getImpl();
        Throwable rootCause = getRootCause(th2);
        this.uuid = UUID.randomUUID();
        this.buildId = getSafeBuildId();
        this.timestamp = System.currentTimeMillis();
        this.appToken = getAppToken();
        this.deviceInfo = new DeviceInfo(impl.getDeviceInformation(), impl.getEnvironmentInformation());
        this.applicationInfo = new ApplicationInfo(impl.getApplicationInformation());
        this.exceptionInfo = new ExceptionInfo(rootCause);
        this.threads = extractThreads(rootCause);
        this.activityHistory = TraceMachine.getActivityHistory();
        this.sessionAttributes = getCrashSessionAttributes(set);
        this.events = collection;
        this.analyticsEnabled = z11;
        this.uploadCount = 0;
    }
}
