package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.SessionEvent;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Harvest {
    private static final boolean DISABLE_ACTIVITY_TRACE_LIMITS_FOR_DEBUGGING = false;
    public static final long INVALID_SESSION_DURATION = 0;
    private static final HarvestableCache activityTraceCache = new HarvestableCache();
    protected static Harvest instance = new Harvest();
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final Collection<HarvestLifecycleAware> unregisteredLifecycleListeners = new ArrayList();
    private HarvestConfiguration configuration = HarvestConfiguration.getDefaultHarvestConfiguration();
    private HarvestConnection harvestConnection;
    protected HarvestData harvestData;
    private HarvestDataValidator harvestDataValidator;
    private HarvestTimer harvestTimer;
    private Harvester harvester;

    public static void addActivityTrace(ActivityTrace activityTrace) {
        boolean z11;
        if (!isDisabled()) {
            if (!isInitialized()) {
                activityTraceCache.add(activityTrace);
                return;
            }
            Trace trace = activityTrace.rootTrace;
            if (trace == null) {
                log.error("Activity trace is lacking a root trace!");
                return;
            }
            long j11 = trace.childExclusiveTime;
            if (j11 == 0) {
                AgentLog agentLog = log;
                String str = trace.displayName;
                agentLog.error("Total trace exclusive time is zero. Ignoring trace " + str);
                return;
            }
            if (((double) j11) / ((double) trace.getDurationAsMilliseconds()) < instance.getConfiguration().getActivity_trace_min_utilization()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRACES_IGNORED);
                AgentLog agentLog2 = log;
                Trace trace2 = activityTrace.rootTrace;
                long j12 = trace2.childExclusiveTime;
                long durationAsMilliseconds = trace2.getDurationAsMilliseconds();
                String str2 = activityTrace.rootTrace.displayName;
                agentLog2.debug("Exclusive trace time is too low (" + j12 + "/" + durationAsMilliseconds + "). Ignoring trace " + str2);
                return;
            }
            ActivityTraces activityTraces = instance.getHarvestData().getActivityTraces();
            ActivityTraceConfiguration activityTraceConfiguration = instance.getActivityTraceConfiguration();
            instance.getHarvester().expireActivityTraces();
            if (activityTraces.count() >= activityTraceConfiguration.getMaxTotalTraceCount()) {
                AgentLog agentLog3 = log;
                int maxTotalTraceCount = activityTraceConfiguration.getMaxTotalTraceCount();
                String jsonString = activityTrace.toJsonString();
                agentLog3.debug("Activity trace limit of " + maxTotalTraceCount + " exceeded. Ignoring trace: " + jsonString);
                return;
            }
            AgentLog agentLog4 = log;
            String jsonString2 = activityTrace.toJsonString();
            agentLog4.debug("Adding activity trace: " + jsonString2);
            activityTraces.add(activityTrace);
        }
    }

    public static void addAgentHealthException(AgentHealthException agentHealthException) {
        if (!isDisabled() && isInitialized()) {
            instance.getHarvestData().getAgentHealth().addException(agentHealthException);
        }
    }

    public static void addHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            log.error("Harvest: Argument to addHarvestListener cannot be null.");
        } else if (isInitialized()) {
            instance.getHarvester().addHarvestListener(harvestLifecycleAware);
        } else if (!isUnregisteredListener(harvestLifecycleAware)) {
            addUnregisteredListener(harvestLifecycleAware);
        }
    }

    public static void addHttpTransaction(HttpTransaction httpTransaction) {
        if (!isDisabled()) {
            HttpTransactions httpTransactions = instance.getHarvestData().getHttpTransactions();
            instance.getHarvester().expireHttpTransactions();
            int report_max_transaction_count = instance.getConfiguration().getReport_max_transaction_count();
            if (httpTransactions.count() >= report_max_transaction_count) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRANS_DROPPED);
                AgentLog agentLog = log;
                agentLog.debug("Maximum number of transactions (" + report_max_transaction_count + ") reached. HTTP Transaction dropped.");
                return;
            }
            httpTransactions.add(httpTransaction);
            AnalyticsControllerImpl.getInstance().createNetworkRequestEvents(httpTransaction);
        }
    }

    public static void addMetric(Metric metric) {
        if (!isDisabled() && isInitialized()) {
            instance.getHarvestData().getMetrics().addMetric(metric);
        }
    }

    private static void addUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware != null) {
            Collection<HarvestLifecycleAware> collection = unregisteredLifecycleListeners;
            synchronized (collection) {
                collection.add(harvestLifecycleAware);
            }
        }
    }

    private void flushActivityTraceCache() {
        Iterator<Harvestable> it = activityTraceCache.flush().iterator();
        while (it.hasNext()) {
            addActivityTrace((ActivityTrace) it.next());
        }
    }

    private void flushHarvestableCaches() {
        try {
            flushActivityTraceCache();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static int getActivityTraceCacheSize() {
        return activityTraceCache.getSize();
    }

    public static HarvestConfiguration getHarvestConfiguration() {
        if (!isInitialized()) {
            return HarvestConfiguration.getDefaultHarvestConfiguration();
        }
        return instance.getConfiguration();
    }

    public static Harvest getInstance() {
        return instance;
    }

    public static long getMillisSinceStart() {
        Harvest instance2 = getInstance();
        if (instance2 == null || instance2.getHarvestTimer() == null) {
            return 0;
        }
        long timeSinceStart = instance2.getHarvestTimer().timeSinceStart();
        if (timeSinceStart < 0) {
            return 0;
        }
        return timeSinceStart;
    }

    public static void harvestNow(boolean z11) {
        if (isInitialized()) {
            if (z11) {
                instance.finalizeSession();
                AnalyticsControllerImpl.getInstance().getEventManager().setTransmitRequired();
            }
            HarvestTimer harvestTimer2 = instance.getHarvestTimer();
            if (harvestTimer2 != null) {
                harvestTimer2.tickNow();
            }
        }
    }

    public static void initialize(AgentConfiguration agentConfiguration) {
        instance.initializeHarvester(agentConfiguration);
        registerUnregisteredListeners();
        addHarvestListener(StatsEngine.get());
    }

    public static boolean isDisabled() {
        if (!isInitialized()) {
            return false;
        }
        return instance.getHarvester().isDisabled();
    }

    public static boolean isInitialized() {
        Harvest harvest = instance;
        return (harvest == null || harvest.getHarvester() == null) ? false : true;
    }

    private static boolean isUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            return false;
        }
        return unregisteredLifecycleListeners.contains(harvestLifecycleAware);
    }

    private static void registerUnregisteredListeners() {
        for (HarvestLifecycleAware addHarvestListener : unregisteredLifecycleListeners) {
            addHarvestListener(addHarvestListener);
        }
        unregisteredLifecycleListeners.clear();
    }

    public static void removeHarvestListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware == null) {
            log.error("Harvest: Argument to removeHarvestListener cannot be null.");
        } else if (isInitialized()) {
            instance.getHarvester().removeHarvestListener(harvestLifecycleAware);
        } else if (isUnregisteredListener(harvestLifecycleAware)) {
            removeUnregisteredListener(harvestLifecycleAware);
        }
    }

    private static void removeUnregisteredListener(HarvestLifecycleAware harvestLifecycleAware) {
        if (harvestLifecycleAware != null) {
            Collection<HarvestLifecycleAware> collection = unregisteredLifecycleListeners;
            synchronized (collection) {
                collection.remove(harvestLifecycleAware);
            }
        }
    }

    public static void setHarvestConfiguration(HarvestConfiguration harvestConfiguration) {
        if (!isInitialized()) {
            log.error("Cannot configure Harvester before initialization.");
            new Exception().printStackTrace();
            return;
        }
        AgentLog agentLog = log;
        agentLog.debug("Harvest Configuration: " + harvestConfiguration);
        instance.setConfiguration(harvestConfiguration);
    }

    public static void setHarvestConnectInformation(ConnectInformation connectInformation) {
        if (!isInitialized()) {
            log.error("Cannot configure Harvester before initialization.");
            new Exception().printStackTrace();
            return;
        }
        AgentLog agentLog = log;
        agentLog.debug("Setting Harvest connect information: " + connectInformation);
        instance.setConnectInformation(connectInformation);
    }

    public static void setInstance(Harvest harvest) {
        if (harvest == null) {
            log.error("Attempt to set Harvest instance to null value!");
        } else {
            instance = harvest;
        }
    }

    public static boolean shouldCollectActivityTraces() {
        ActivityTraceConfiguration activityTraceConfiguration;
        if (isDisabled()) {
            return false;
        }
        if (!isInitialized() || (activityTraceConfiguration = instance.getActivityTraceConfiguration()) == null) {
            return true;
        }
        if (activityTraceConfiguration.getMaxTotalTraceCount() > 0) {
            return true;
        }
        return false;
    }

    public static void shutdown() {
        if (isInitialized()) {
            stop();
            instance.shutdownHarvester();
        }
    }

    public static void start() {
        if (instance.getHarvestTimer() != null) {
            instance.getHarvestTimer().start();
        } else {
            log.error("Harvest timer is null");
        }
    }

    public static void stop() {
        if (instance.getHarvestTimer() != null) {
            instance.getHarvestTimer().stop();
        } else {
            log.error("Harvest timer is null");
        }
    }

    public void createHarvester() {
        this.harvestConnection = new HarvestConnection();
        this.harvestData = new HarvestData();
        Harvester harvester2 = new Harvester();
        this.harvester = harvester2;
        harvester2.setHarvestConnection(this.harvestConnection);
        this.harvester.setHarvestData(this.harvestData);
        this.harvestTimer = new HarvestTimer(this.harvester);
        HarvestDataValidator harvestDataValidator2 = new HarvestDataValidator();
        this.harvestDataValidator = harvestDataValidator2;
        addHarvestListener(harvestDataValidator2);
    }

    public void finalizeSession() {
        long millisSinceStart = getMillisSinceStart();
        if (millisSinceStart == 0) {
            log.error("Session duration is invalid!");
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_SESSION_INVALID_DURATION);
        }
        float f11 = ((float) millisSinceStart) / 1000.0f;
        StatsEngine.get().sample(MetricNames.SESSION_DURATION, f11);
        AgentLog agentLog = log;
        agentLog.debug("Harvest: Generating sessionDuration attribute with value " + f11);
        AnalyticsControllerImpl instance2 = AnalyticsControllerImpl.getInstance();
        instance2.setAttribute(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE, (double) f11, false);
        agentLog.debug("Harvest: Generating session event.");
        instance2.addEvent(new SessionEvent());
    }

    public ActivityTraceConfiguration getActivityTraceConfiguration() {
        return this.configuration.getAt_capture();
    }

    public HarvestConfiguration getConfiguration() {
        return this.configuration;
    }

    public HarvestConnection getHarvestConnection() {
        return this.harvestConnection;
    }

    public HarvestData getHarvestData() {
        return this.harvestData;
    }

    public HarvestTimer getHarvestTimer() {
        return this.harvestTimer;
    }

    public Harvester getHarvester() {
        return this.harvester;
    }

    public void initializeHarvester(AgentConfiguration agentConfiguration) {
        createHarvester();
        this.harvester.setAgentConfiguration(agentConfiguration);
        this.harvester.setConfiguration(instance.getConfiguration());
        flushHarvestableCaches();
    }

    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        this.configuration.reconfigure(harvestConfiguration);
        this.harvestTimer.setPeriod(TimeUnit.MILLISECONDS.convert((long) this.configuration.getData_report_period(), TimeUnit.SECONDS));
        this.harvestConnection.setServerTimestamp(this.configuration.getServer_timestamp());
        this.harvestData.setDataToken(this.configuration.getDataToken());
        this.harvester.setConfiguration(this.configuration);
    }

    public void setConnectInformation(ConnectInformation connectInformation) {
        this.harvestConnection.setConnectInformation(connectInformation);
        this.harvestData.setDeviceInformation(connectInformation.getDeviceInformation());
    }

    public void setHarvestConnection(HarvestConnection harvestConnection2) {
        this.harvestConnection = harvestConnection2;
    }

    public boolean shouldCollectNetworkErrors() {
        return this.configuration.isCollect_network_errors();
    }

    public void shutdownHarvester() {
        this.harvestTimer.shutdown();
        this.harvestTimer = null;
        this.harvester = null;
        this.harvestConnection = null;
        this.harvestData = null;
    }
}
