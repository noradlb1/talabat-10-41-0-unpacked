package com.newrelic.agent.android.stats;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class StatsEngine extends HarvestAdapter {
    public static final StatsEngine INSTANCE = new StatsEngine();
    public static final StatsEngine SUPPORTABILITY = new SupportabilityDecorator();
    public boolean enabled;
    private final ConcurrentHashMap<String, Metric> statsMap;

    /* renamed from: com.newrelic.agent.android.stats.StatsEngine$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$ApplicationFramework;

        static {
            int[] iArr = new int[ApplicationFramework.values().length];
            $SwitchMap$com$newrelic$agent$android$ApplicationFramework = iArr;
            try {
                iArr[ApplicationFramework.Native.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class SupportabilityDecorator extends StatsEngine {
        public SupportabilityDecorator() {
            super();
        }

        public String emptyIfNull(String str) {
            return str == null ? "" : str;
        }

        public Metric lazyGet(String str) {
            DeviceInformation deviceInformation = Agent.getDeviceInformation();
            String emptyIfNull = emptyIfNull((String) null);
            String emptyIfNull2 = emptyIfNull((String) null);
            String emptyIfNull3 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
            String emptyIfNull4 = emptyIfNull(deviceInformation.getAgentVersion());
            if (deviceInformation.getApplicationFramework() != null) {
                if (AnonymousClass1.$SwitchMap$com$newrelic$agent$android$ApplicationFramework[deviceInformation.getApplicationFramework().ordinal()] != 1) {
                    emptyIfNull = emptyIfNull(deviceInformation.getApplicationFramework().name());
                    if (!emptyIfNull3.equals(emptyIfNull4)) {
                        emptyIfNull2 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
                    }
                } else if (!emptyIfNull3.isEmpty() && !emptyIfNull3.equals(emptyIfNull4)) {
                    emptyIfNull = emptyIfNull(deviceInformation.getApplicationFramework().name());
                    emptyIfNull2 = emptyIfNull(deviceInformation.getApplicationFrameworkVersion());
                }
            }
            String replaceAll = str.replaceAll(MetricNames.TAG_FRAMEWORK, emptyIfNull(emptyIfNull)).replaceAll(MetricNames.TAG_FRAMEWORK_VERSION, emptyIfNull(emptyIfNull2));
            while (replaceAll.contains("//")) {
                replaceAll = replaceAll.replaceAll("//", "/");
            }
            AgentLog agentLog = AgentLogManager.getAgentLog();
            agentLog.debug("Metric normalized to [" + replaceAll + "]");
            return StatsEngine.super.lazyGet(replaceAll);
        }
    }

    private StatsEngine() {
        this.enabled = true;
        this.statsMap = new ConcurrentHashMap<>();
    }

    public static void calculateMetricsDataUseage() {
        String replace = MetricNames.SUPPORTABILITY_DESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR);
        long j11 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (Map.Entry<String, Metric> value : INSTANCE.getStatsMap().entrySet()) {
            Metric metric = (Metric) value.getValue();
            String name2 = metric.getName();
            if (name2.contains("Collector/connect") || name2.contains("Collector/data") || name2.contains("Collector/f") || name2.contains("Collector/mobile_crash")) {
                j11 += metric.getCount();
                f11 = (float) (((double) f11) + metric.getTotal());
                f12 = (float) (((double) f12) + metric.getExclusive());
            }
        }
        for (Map.Entry<String, Metric> value2 : SUPPORTABILITY.getStatsMap().entrySet()) {
            Metric metric2 = (Metric) value2.getValue();
            String name3 = metric2.getName();
            if (name3.contains("Collector/connect") || name3.contains("Collector/data") || name3.contains("Collector/f") || name3.contains("Collector/mobile_crash")) {
                j11 += metric2.getCount();
                f11 = (float) (((double) f11) + metric2.getTotal());
                f12 = (float) (((double) f12) + metric2.getExclusive());
            }
        }
        get().inc(replace, j11 - 1);
        get().sampleMetricDataUsage(replace, f11, f12);
    }

    public static synchronized void disable() {
        synchronized (StatsEngine.class) {
            INSTANCE.enabled = false;
            SUPPORTABILITY.enabled = false;
        }
    }

    public static synchronized void enable() {
        synchronized (StatsEngine.class) {
            INSTANCE.enabled = true;
            SUPPORTABILITY.enabled = true;
        }
    }

    public static StatsEngine get() {
        return INSTANCE;
    }

    public static StatsEngine notice() {
        return SUPPORTABILITY;
    }

    public static void populateMetrics() {
        for (Map.Entry<String, Metric> value : INSTANCE.getStatsMap().entrySet()) {
            TaskQueue.queue((Metric) value.getValue());
        }
        for (Map.Entry<String, Metric> value2 : SUPPORTABILITY.getStatsMap().entrySet()) {
            TaskQueue.queue((Metric) value2.getValue());
        }
    }

    public static void reset() {
        INSTANCE.getStatsMap().clear();
        SUPPORTABILITY.getStatsMap().clear();
    }

    public ConcurrentHashMap<String, Metric> getStatsMap() {
        return this.statsMap;
    }

    public void inc(String str) {
        Metric lazyGet = lazyGet(str);
        synchronized (lazyGet) {
            lazyGet.increment();
        }
    }

    public Metric lazyGet(String str) {
        Metric metric = this.statsMap.get(str);
        if (metric == null) {
            metric = new Metric(str);
            if (this.enabled) {
                this.statsMap.put(str, metric);
            }
        }
        return metric;
    }

    public void onHarvest() {
        calculateMetricsDataUseage();
        populateMetrics();
        reset();
    }

    public void sample(String str, float f11) {
        Metric lazyGet = lazyGet(str);
        synchronized (lazyGet) {
            lazyGet.sample((double) f11);
        }
    }

    public void sampleMetricDataUsage(String str, float f11, float f12) {
        Metric lazyGet = lazyGet(str);
        synchronized (lazyGet) {
            lazyGet.sampleMetricDataUsage((double) f11, (double) f12);
        }
    }

    public void sampleTimeMs(String str, long j11) {
        sample(str, ((float) j11) / 1000.0f);
    }

    public void inc(String str, long j11) {
        Metric lazyGet = lazyGet(str);
        synchronized (lazyGet) {
            lazyGet.increment(j11);
        }
    }
}
