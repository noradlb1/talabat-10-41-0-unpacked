package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfigurationDeserializer;
import com.newrelic.agent.android.harvest.HarvestResponse;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Collection;

public class Harvester {
    private AgentConfiguration agentConfiguration;
    private HarvestConfiguration configuration = HarvestConfiguration.getDefaultHarvestConfiguration();
    private HarvestConnection harvestConnection;
    private HarvestData harvestData;
    private final Collection<HarvestLifecycleAware> harvestListeners = new ArrayList();
    private final AgentLog log = AgentLogManager.getAgentLog();
    private State state = State.UNINITIALIZED;
    protected boolean stateChanged;

    /* renamed from: com.newrelic.agent.android.harvest.Harvester$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code;
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.newrelic.agent.android.harvest.Harvester$State[] r0 = com.newrelic.agent.android.harvest.Harvester.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State = r0
                r1 = 1
                com.newrelic.agent.android.harvest.Harvester$State r2 = com.newrelic.agent.android.harvest.Harvester.State.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.harvest.Harvester$State r3 = com.newrelic.agent.android.harvest.Harvester.State.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.harvest.Harvester$State r4 = com.newrelic.agent.android.harvest.Harvester.State.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$newrelic$agent$android$harvest$Harvester$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.newrelic.agent.android.harvest.Harvester$State r5 = com.newrelic.agent.android.harvest.Harvester.State.DISABLED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.newrelic.agent.android.harvest.HarvestResponse$Code[] r4 = com.newrelic.agent.android.harvest.HarvestResponse.Code.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code = r4
                com.newrelic.agent.android.harvest.HarvestResponse$Code r5 = com.newrelic.agent.android.harvest.HarvestResponse.Code.UNAUTHORIZED     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x004e }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r4 = com.newrelic.agent.android.harvest.HarvestResponse.Code.INVALID_AGENT_ID     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.FORBIDDEN     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.UNSUPPORTED_MEDIA_TYPE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x006d }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.ENTITY_TOO_LARGE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.REQUEST_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.newrelic.agent.android.harvest.HarvestResponse$Code r1 = com.newrelic.agent.android.harvest.HarvestResponse.Code.TOO_MANY_REQUESTS     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.harvest.Harvester.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        UNINITIALIZED,
        DISCONNECTED,
        CONNECTED,
        DISABLED
    }

    private void changeState(State state2) {
        AgentLog agentLog = this.log;
        State state3 = this.state;
        agentLog.debug("Harvester changing state: " + state3 + " -> " + state2);
        if (this.state == State.CONNECTED) {
            if (state2 == State.DISCONNECTED) {
                fireOnHarvestDisconnected();
            } else if (state2 == State.DISABLED) {
                fireOnHarvestDisabled();
            }
        }
        this.state = state2;
        this.stateChanged = true;
    }

    private void configureHarvester(HarvestConfiguration harvestConfiguration) {
        this.configuration.reconfigure(harvestConfiguration);
        this.harvestData.setDataToken(this.configuration.getDataToken());
        Harvest.setHarvestConfiguration(this.configuration);
    }

    private void fireOnHarvest() {
        try {
            for (HarvestLifecycleAware onHarvest : getHarvestListeners()) {
                onHarvest.onHarvest();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvest", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestBefore() {
        try {
            for (HarvestLifecycleAware onHarvestBefore : getHarvestListeners()) {
                onHarvestBefore.onHarvestBefore();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestBefore", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestComplete() {
        try {
            for (HarvestLifecycleAware onHarvestComplete : getHarvestListeners()) {
                onHarvestComplete.onHarvestComplete();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestComplete", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestConnected() {
        try {
            for (HarvestLifecycleAware onHarvestConnected : getHarvestListeners()) {
                onHarvestConnected.onHarvestConnected();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestConnected", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestDisabled() {
        try {
            for (HarvestLifecycleAware onHarvestDisabled : getHarvestListeners()) {
                onHarvestDisabled.onHarvestDisabled();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestDisabled", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestDisconnected() {
        try {
            for (HarvestLifecycleAware onHarvestDisconnected : getHarvestListeners()) {
                onHarvestDisconnected.onHarvestDisconnected();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestDisconnected", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestError() {
        try {
            for (HarvestLifecycleAware onHarvestError : getHarvestListeners()) {
                onHarvestError.onHarvestError();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestError", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestFinalize() {
        try {
            for (HarvestLifecycleAware onHarvestFinalize : getHarvestListeners()) {
                onHarvestFinalize.onHarvestFinalize();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestFinalize", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestSendFailed() {
        try {
            for (HarvestLifecycleAware onHarvestSendFailed : getHarvestListeners()) {
                onHarvestSendFailed.onHarvestSendFailed();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestSendFailed", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestStart() {
        try {
            for (HarvestLifecycleAware onHarvestStart : getHarvestListeners()) {
                onHarvestStart.onHarvestStart();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestStart", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private void fireOnHarvestStop() {
        try {
            for (HarvestLifecycleAware onHarvestStop : getHarvestListeners()) {
                onHarvestStop.onHarvestStop();
            }
        } catch (Exception e11) {
            this.log.error("Error in fireOnHarvestStop", e11);
            AgentHealth.noticeException(e11);
        }
    }

    private Collection<HarvestLifecycleAware> getHarvestListeners() {
        return new ArrayList(this.harvestListeners);
    }

    private HarvestConfiguration parseHarvesterConfiguration(HarvestResponse harvestResponse) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ActivityTraceConfiguration.class, new ActivityTraceConfigurationDeserializer());
        try {
            return (HarvestConfiguration) gsonBuilder.create().fromJson(harvestResponse.getResponseBody(), HarvestConfiguration.class);
        } catch (JsonSyntaxException e11) {
            AgentLog agentLog = this.log;
            String message = e11.getMessage();
            agentLog.error("Unable to parse collector configuration: " + message);
            AgentHealth.noticeException((Exception) e11);
            return null;
        }
    }

    private boolean stateIn(State state2, State... stateArr) {
        for (State state3 : stateArr) {
            if (state2 == state3) {
                return true;
            }
        }
        return false;
    }

    public void addHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            this.log.error("Can't add null harvest listener");
            new Exception().printStackTrace();
            return;
        }
        synchronized (this.harvestListeners) {
            if (!this.harvestListeners.contains(harvestLifecycleAware)) {
                this.harvestListeners.add(harvestLifecycleAware);
            }
        }
    }

    public void connected() {
        if (!this.harvestData.isValid()) {
            this.log.error("Harvester: invalid data token! Agent must reconnect prior to upload.");
            StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_INVALID_DATA_TOKEN);
            this.harvestData.getDataToken().clear();
            fireOnHarvestSendFailed();
            transition(State.DISCONNECTED);
            return;
        }
        this.log.info("Harvester: connected");
        AgentLog agentLog = this.log;
        int count = this.harvestData.getHttpTransactions().count();
        agentLog.info("Harvester: Sending [" + count + "] HTTP transactions.");
        AgentLog agentLog2 = this.log;
        int count2 = this.harvestData.getActivityTraces().count();
        agentLog2.info("Harvester: Sending [" + count2 + "] activity traces.");
        AgentLog agentLog3 = this.log;
        int size = this.harvestData.getSessionAttributes().size();
        agentLog3.info("Harvester: Sending [" + size + "] session attributes.");
        AgentLog agentLog4 = this.log;
        int size2 = this.harvestData.getAnalyticsEvents().size();
        agentLog4.info("Harvester: Sending [" + size2 + "] analytics events.");
        HarvestResponse sendData = this.harvestConnection.sendData(this.harvestData);
        if (sendData == null || sendData.isUnknown()) {
            AgentLog agentLog5 = this.log;
            HarvestResponse.Code responseCode = sendData.getResponseCode();
            agentLog5.debug("Harvest data response: " + responseCode);
            fireOnHarvestSendFailed();
            return;
        }
        StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", sendData.getResponseTime());
        AgentLog agentLog6 = this.log;
        HarvestResponse.Code responseCode2 = sendData.getResponseCode();
        agentLog6.debug("Harvest data response: " + responseCode2);
        AgentLog agentLog7 = this.log;
        int statusCode = sendData.getStatusCode();
        agentLog7.debug("Harvest data response status code: " + statusCode);
        AgentLog agentLog8 = this.log;
        String responseBody = sendData.getResponseBody();
        agentLog8.audit("Harvest data response BODY: " + responseBody);
        if (sendData.isError()) {
            fireOnHarvestError();
            StatsEngine statsEngine = StatsEngine.get();
            HarvestResponse.Code responseCode3 = sendData.getResponseCode();
            statsEngine.inc("Supportability/AgentHealth/Collector/Harvest/Error/" + responseCode3);
            switch (AnonymousClass1.$SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[sendData.getResponseCode().ordinal()]) {
                case 1:
                case 2:
                    this.harvestData.reset();
                    this.harvestData.getDataToken().clear();
                    transition(State.DISCONNECTED);
                    return;
                case 3:
                    this.harvestData.reset();
                    if (sendData.isDisableCommand()) {
                        this.log.error("Collector has commanded Agent to disable.");
                        transition(State.DISABLED);
                        return;
                    }
                    this.log.error("Unexpected Collector response: FORBIDDEN");
                    transition(State.DISCONNECTED);
                    return;
                case 4:
                case 5:
                    this.harvestData.reset();
                    this.log.error("An invalid harvest payload was sent to the Collector.");
                    return;
                case 6:
                    this.log.warn("Harvest request has timed-out, and will retry during next harvest cycle.");
                    return;
                case 7:
                    this.log.warn("Harvest request has been throttled, and will retry during next harvest cycle.");
                    return;
                default:
                    this.log.error("An unknown error occurred when connecting to the Collector.");
                    return;
            }
        } else {
            fireOnHarvestComplete();
            this.harvestData.reset();
        }
    }

    public void disabled() {
        Harvest.stop();
        fireOnHarvestDisabled();
    }

    public void disconnected() {
        if (this.configuration == null) {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
        }
        if (this.harvestData.isValid()) {
            AgentLog agentLog = this.log;
            DataToken dataToken = this.harvestData.getDataToken();
            agentLog.verbose("Skipping connect call, saved state is available: " + dataToken);
            StatsEngine.get().sample(MetricNames.SESSION_START, 1.0f);
            fireOnHarvestConnected();
            transition(State.CONNECTED);
            execute();
            return;
        }
        AgentLog agentLog2 = this.log;
        DataToken dataToken2 = this.harvestData.getDataToken();
        agentLog2.info("Connecting, saved state is not available: " + dataToken2);
        HarvestResponse sendConnect = this.harvestConnection.sendConnect();
        if (sendConnect == null) {
            this.log.error("Unable to connect to the Collector.");
        } else if (sendConnect.isOK()) {
            HarvestConfiguration parseHarvesterConfiguration = parseHarvesterConfiguration(sendConnect);
            if (parseHarvesterConfiguration == null) {
                this.log.error("Unable to configure Harvester using Collector configuration.");
                return;
            }
            configureHarvester(parseHarvesterConfiguration);
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", sendConnect.getResponseTime());
            fireOnHarvestConnected();
            transition(State.CONNECTED);
            execute();
        } else {
            AgentLog agentLog3 = this.log;
            HarvestResponse.Code responseCode = sendConnect.getResponseCode();
            agentLog3.debug("Harvest connect response: " + responseCode);
            StatsEngine statsEngine = StatsEngine.get();
            HarvestResponse.Code responseCode2 = sendConnect.getResponseCode();
            statsEngine.inc("Supportability/AgentHealth/Collector/Harvest/Connect/Error/" + responseCode2);
            switch (AnonymousClass1.$SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[sendConnect.getResponseCode().ordinal()]) {
                case 1:
                case 2:
                    this.harvestData.getDataToken().clear();
                    fireOnHarvestDisconnected();
                    return;
                case 3:
                    if (!sendConnect.isDisableCommand()) {
                        this.log.error("Unexpected Collector response: FORBIDDEN");
                        break;
                    } else {
                        this.log.error("Collector has commanded Agent to disable.");
                        fireOnHarvestDisabled();
                        transition(State.DISABLED);
                        return;
                    }
                case 4:
                case 5:
                    this.log.error("Invalid ConnectionInformation was sent to the Collector.");
                    break;
                case 6:
                    this.log.warn("Harvest request has timed-out, and will retry during next harvest cycle.");
                    break;
                case 7:
                    this.log.warn("Harvest request has been throttled, and will retry during next harvest cycle.");
                    break;
                default:
                    this.log.error("An unknown error occurred when connecting to the Collector.");
                    break;
            }
            fireOnHarvestError();
        }
    }

    public void execute() {
        AgentLog agentLog = this.log;
        State state2 = this.state;
        agentLog.debug("Harvester state: " + state2);
        this.stateChanged = false;
        try {
            expireHarvestData();
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[this.state.ordinal()];
            if (i11 == 1) {
                uninitialized();
            } else if (i11 == 2) {
                fireOnHarvestBefore();
                disconnected();
            } else if (i11 == 3) {
                TaskQueue.synchronousDequeue();
                fireOnHarvestBefore();
                fireOnHarvest();
                fireOnHarvestFinalize();
                connected();
            } else if (i11 == 4) {
                disabled();
            } else {
                throw new IllegalStateException();
            }
        } catch (Exception e11) {
            this.log.error("Exception encountered while attempting to harvest", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public void expireActivityTraces() {
        ActivityTraces activityTraces = this.harvestData.getActivityTraces();
        synchronized (activityTraces) {
            ArrayList<ActivityTrace> arrayList = new ArrayList<>();
            long activity_trace_max_report_attempts = (long) this.configuration.getActivity_trace_max_report_attempts();
            for (ActivityTrace next : activityTraces.getActivityTraces()) {
                if (next.getReportAttemptCount() >= activity_trace_max_report_attempts) {
                    AgentLog agentLog = this.log;
                    long reportAttemptCount = next.getReportAttemptCount();
                    agentLog.audit("ActivityTrace has had " + reportAttemptCount + " report attempts, purging: " + next);
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                AgentLog agentLog2 = this.log;
                int size = arrayList.size();
                agentLog2.debug("Purging [" + size + "] expired ActivityTraces from HarvestData");
                for (ActivityTrace remove : arrayList) {
                    activityTraces.remove(remove);
                }
            }
        }
    }

    public void expireAnalyticsEvents() {
    }

    public void expireHarvestData() {
        if (this.harvestData != null) {
            expireHttpTransactions();
            expireActivityTraces();
            expireAnalyticsEvents();
        }
    }

    public void expireHttpTransactions() {
        HttpTransactions httpTransactions = this.harvestData.getHttpTransactions();
        synchronized (httpTransactions) {
            ArrayList<HttpTransaction> arrayList = new ArrayList<>();
            long currentTimeMillis = System.currentTimeMillis();
            long reportMaxTransactionAgeMilliseconds = this.configuration.getReportMaxTransactionAgeMilliseconds();
            for (HttpTransaction next : httpTransactions.getHttpTransactions()) {
                if (next.getTimestamp().longValue() < currentTimeMillis - reportMaxTransactionAgeMilliseconds) {
                    AgentLog agentLog = this.log;
                    agentLog.audit("HttpTransaction too old, purging: " + next);
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                AgentLog agentLog2 = this.log;
                int size = arrayList.size();
                agentLog2.debug("Purging [" + size + "] expired HttpTransactions from HarvestData");
                for (HttpTransaction remove : arrayList) {
                    httpTransactions.remove(remove);
                }
            }
        }
    }

    public State getCurrentState() {
        return this.state;
    }

    public HarvestConnection getHarvestConnection() {
        return this.harvestConnection;
    }

    public HarvestData getHarvestData() {
        return this.harvestData;
    }

    public boolean isDisabled() {
        return State.DISABLED == this.state;
    }

    public void removeHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        synchronized (this.harvestListeners) {
            if (this.harvestListeners.contains(harvestLifecycleAware)) {
                this.harvestListeners.remove(harvestLifecycleAware);
            }
        }
    }

    public void setAgentConfiguration(AgentConfiguration agentConfiguration2) {
        this.agentConfiguration = agentConfiguration2;
    }

    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        this.configuration = harvestConfiguration;
    }

    public void setHarvestConnection(HarvestConnection harvestConnection2) {
        this.harvestConnection = harvestConnection2;
    }

    public void setHarvestData(HarvestData harvestData2) {
        this.harvestData = harvestData2;
    }

    public void start() {
        fireOnHarvestStart();
    }

    public void stop() {
        fireOnHarvestStop();
    }

    public void transition(State state2) {
        if (this.stateChanged) {
            AgentLog agentLog = this.log;
            agentLog.debug("Ignoring multiple transition: " + state2);
            return;
        }
        State state3 = this.state;
        if (state3 != state2) {
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[state3.ordinal()];
            if (i11 == 1) {
                if (!stateIn(state2, State.DISCONNECTED, state2, State.CONNECTED, State.DISABLED)) {
                    throw new IllegalStateException();
                }
            } else if (i11 == 2) {
                if (!stateIn(state2, State.UNINITIALIZED, State.CONNECTED, State.DISABLED)) {
                    throw new IllegalStateException();
                }
            } else if (i11 == 3) {
                if (!stateIn(state2, State.DISCONNECTED, State.DISABLED)) {
                    throw new IllegalStateException();
                }
            } else {
                throw new IllegalStateException();
            }
            changeState(state2);
        }
    }

    public void uninitialized() {
        if (this.agentConfiguration == null) {
            this.log.error("Agent configuration unavailable.");
            return;
        }
        if (Agent.getImpl().updateSavedConnectInformation()) {
            configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
            this.harvestData.getDataToken().clear();
        }
        Harvest.setHarvestConnectInformation(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()));
        this.harvestConnection.setApplicationToken(this.agentConfiguration.getApplicationToken());
        this.harvestConnection.setCollectorHost(this.agentConfiguration.getCollectorHost());
        this.harvestConnection.useSsl(this.agentConfiguration.useSsl());
        transition(State.DISCONNECTED);
        execute();
    }
}
