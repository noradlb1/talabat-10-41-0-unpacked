package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HarvestData extends HarvestableArray {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ActivityTraces activityTraces = new ActivityTraces();
    private AgentHealth agentHealth = new AgentHealth();
    private boolean analyticsEnabled = false;
    private Collection<AnalyticsEvent> analyticsEvents = new ArrayList();
    private DataToken dataToken = new DataToken();
    private DeviceInformation deviceInformation = Agent.getDeviceInformation();
    private double harvestTimeDelta;
    private HttpTransactions httpTransactions = new HttpTransactions();
    private MachineMeasurements machineMeasurements = new MachineMeasurements();
    private Set<AnalyticsAttribute> sessionAttributes = new HashSet();

    /* renamed from: com.newrelic.agent.android.harvest.HarvestData$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType[] r0 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType = r0
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.harvest.HarvestData.AnonymousClass1.<clinit>():void");
        }
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(this.dataToken.asJson());
        jsonArray.add(this.deviceInformation.asJson());
        jsonArray.add((JsonElement) new JsonPrimitive((Number) Double.valueOf(this.harvestTimeDelta)));
        jsonArray.add(this.httpTransactions.asJson());
        jsonArray.add(this.machineMeasurements.asJson());
        jsonArray.add((JsonElement) new JsonArray());
        JsonElement asJson = this.activityTraces.asJson();
        String jsonElement = asJson.toString();
        if (jsonElement.length() < Harvest.getHarvestConfiguration().getActivity_trace_max_size()) {
            jsonArray.add(asJson);
        } else {
            StatsEngine.get().sample(MetricNames.SUPPORTABILITY_TRACES_DROPPED, (float) jsonElement.length());
            jsonArray.add((JsonElement) new JsonArray());
        }
        jsonArray.add(this.agentHealth.asJson());
        if (this.analyticsEnabled) {
            JsonObject jsonObject = new JsonObject();
            for (AnalyticsAttribute next : this.sessionAttributes) {
                int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[next.getAttributeDataType().ordinal()];
                if (i11 == 1) {
                    jsonObject.addProperty(next.getName(), next.getStringValue());
                } else if (i11 == 2) {
                    jsonObject.addProperty(next.getName(), (Number) Double.valueOf(next.getDoubleValue()));
                } else if (i11 == 3) {
                    jsonObject.addProperty(next.getName(), Boolean.valueOf(next.getBooleanValue()));
                }
            }
            jsonArray.add((JsonElement) jsonObject);
            JsonArray jsonArray2 = new JsonArray();
            for (AnalyticsEvent asJsonObject : this.analyticsEvents) {
                jsonArray2.add((JsonElement) asJsonObject.asJsonObject());
            }
            jsonArray.add((JsonElement) jsonArray2);
        }
        return jsonArray;
    }

    public ActivityTraces getActivityTraces() {
        return this.activityTraces;
    }

    public AgentHealth getAgentHealth() {
        return this.agentHealth;
    }

    public Collection<AnalyticsEvent> getAnalyticsEvents() {
        return this.analyticsEvents;
    }

    public DataToken getDataToken() {
        return this.dataToken;
    }

    public DeviceInformation getDeviceInformation() {
        return this.deviceInformation;
    }

    public HttpTransactions getHttpTransactions() {
        return this.httpTransactions;
    }

    public MachineMeasurements getMetrics() {
        return this.machineMeasurements;
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        return this.sessionAttributes;
    }

    public boolean isAnalyticsEnabled() {
        return this.analyticsEnabled;
    }

    public boolean isValid() {
        return this.dataToken.isValid();
    }

    public void reset() {
        this.httpTransactions.clear();
        this.activityTraces.clear();
        this.machineMeasurements.clear();
        this.agentHealth.clear();
        this.sessionAttributes.clear();
        this.analyticsEvents.clear();
    }

    public void setActivityTraces(ActivityTraces activityTraces2) {
        this.activityTraces = activityTraces2;
    }

    public void setAnalyticsEnabled(boolean z11) {
        this.analyticsEnabled = z11;
    }

    public void setAnalyticsEvents(Collection<AnalyticsEvent> collection) {
        this.analyticsEvents = new ArrayList(collection);
    }

    public void setDataToken(DataToken dataToken2) {
        if (dataToken2 != null) {
            this.dataToken = dataToken2;
        }
    }

    public void setDeviceInformation(DeviceInformation deviceInformation2) {
        this.deviceInformation = deviceInformation2;
    }

    public void setHarvestTimeDelta(double d11) {
        this.harvestTimeDelta = d11;
    }

    public void setHttpTransactions(HttpTransactions httpTransactions2) {
        this.httpTransactions = httpTransactions2;
    }

    public void setMachineMeasurements(MachineMeasurements machineMeasurements2) {
        this.machineMeasurements = machineMeasurements2;
    }

    public void setSessionAttributes(Set<AnalyticsAttribute> set) {
        AgentLog agentLog = log;
        agentLog.debug("HarvestData.setSessionAttributes invoked with attribute set " + set);
        this.sessionAttributes = new HashSet(set);
    }

    public String toString() {
        DataToken dataToken2 = this.dataToken;
        DeviceInformation deviceInformation2 = this.deviceInformation;
        double d11 = this.harvestTimeDelta;
        HttpTransactions httpTransactions2 = this.httpTransactions;
        MachineMeasurements machineMeasurements2 = this.machineMeasurements;
        ActivityTraces activityTraces2 = this.activityTraces;
        Set<AnalyticsAttribute> set = this.sessionAttributes;
        Collection<AnalyticsEvent> collection = this.analyticsEvents;
        return "HarvestData{\n\tdataToken=" + dataToken2 + ", \n\tdeviceInformation=" + deviceInformation2 + ", \n\tharvestTimeDelta=" + d11 + ", \n\thttpTransactions=" + httpTransactions2 + ", \n\tmachineMeasurements=" + machineMeasurements2 + ", \n\tactivityTraces=" + activityTraces2 + ", \n\tsessionAttributes=" + set + ", \n\tanalyticsAttributes=" + collection + "}";
    }
}
