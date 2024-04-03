package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.MethodMeasurement;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SummaryMetricMeasurementConsumer extends MetricMeasurementConsumer implements TraceLifecycleAware {
    private static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Summary/Name/";
    private static final String METRIC_PREFIX = "Mobile/Summary/";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final List<ActivityTrace> completedTraces = new CopyOnWriteArrayList();

    /* renamed from: com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.measurement.MeasurementType[] r0 = com.newrelic.agent.android.measurement.MeasurementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType = r0
                com.newrelic.agent.android.measurement.MeasurementType r1 = com.newrelic.agent.android.measurement.MeasurementType.Method     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.measurement.MeasurementType r1 = com.newrelic.agent.android.measurement.MeasurementType.Network     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$measurement$MeasurementType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.measurement.MeasurementType r1 = com.newrelic.agent.android.measurement.MeasurementType.Custom     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer.AnonymousClass1.<clinit>():void");
        }
    }

    public SummaryMetricMeasurementConsumer() {
        super(MeasurementType.Any);
        this.recordUnscopedMetrics = false;
        TraceMachine.addTraceListener(this);
    }

    private void consumeCustomMeasurement(CustomMetricMeasurement customMetricMeasurement) {
        if (customMetricMeasurement.getCategory() != null && customMetricMeasurement.getCategory() != MetricCategory.NONE) {
            BaseMeasurement baseMeasurement = new BaseMeasurement((Measurement) customMetricMeasurement);
            baseMeasurement.setName(customMetricMeasurement.getCategory().getCategoryName());
            super.consumeMeasurement(baseMeasurement);
        }
    }

    private void consumeMethodMeasurement(MethodMeasurement methodMeasurement) {
        if (methodMeasurement.getCategory() == null || methodMeasurement.getCategory() == MetricCategory.NONE) {
            methodMeasurement.setCategory(MetricCategory.categoryForMethod(methodMeasurement.getName()));
            if (methodMeasurement.getCategory() == MetricCategory.NONE) {
                return;
            }
        }
        BaseMeasurement baseMeasurement = new BaseMeasurement((Measurement) methodMeasurement);
        baseMeasurement.setName(methodMeasurement.getCategory().getCategoryName());
        super.consumeMeasurement(baseMeasurement);
    }

    private void consumeNetworkMeasurement(HttpTransactionMeasurement httpTransactionMeasurement) {
        BaseMeasurement baseMeasurement = new BaseMeasurement((Measurement) httpTransactionMeasurement);
        baseMeasurement.setName(MetricCategory.NETWORK.getCategoryName());
        super.consumeMeasurement(baseMeasurement);
    }

    private void summarizeActivityMetrics(ActivityTrace activityTrace) {
        double d11;
        Trace trace = activityTrace.rootTrace;
        List<Metric> removeAllWithScope = this.metrics.removeAllWithScope(trace.metricName);
        List<Metric> removeAllWithScope2 = this.metrics.removeAllWithScope(trace.metricBackgroundName);
        HashMap hashMap = new HashMap();
        for (Metric next : removeAllWithScope) {
            hashMap.put(next.getName(), next);
        }
        for (Metric next2 : removeAllWithScope2) {
            if (hashMap.containsKey(next2.getName())) {
                ((Metric) hashMap.get(next2.getName())).aggregate(next2);
            } else {
                hashMap.put(next2.getName(), next2);
            }
        }
        double d12 = 0.0d;
        for (Metric exclusive : hashMap.values()) {
            d12 += exclusive.getExclusive();
        }
        double d13 = ((double) (trace.exitTimestamp - trace.entryTimestamp)) / 1000.0d;
        for (Metric metric : hashMap.values()) {
            if (metric.getExclusive() == 0.0d || d12 == 0.0d) {
                d11 = 0.0d;
            } else {
                d11 = metric.getExclusive() / d12;
            }
            double d14 = d11 * d13;
            metric.setTotal(Double.valueOf(d14));
            metric.setExclusive(Double.valueOf(d14));
            metric.setMinFieldValue(Double.valueOf(0.0d));
            metric.setMaxFieldValue(Double.valueOf(0.0d));
            metric.setSumOfSquares(Double.valueOf(0.0d));
            metric.setScope(ACTIVITY_METRIC_PREFIX + trace.displayName);
            Harvest.addMetric(metric);
            Metric metric2 = new Metric(metric);
            metric2.setScope((String) null);
            Harvest.addMetric(metric2);
        }
        summarizeActivityNetworkMetrics(activityTrace);
    }

    private void summarizeActivityNetworkMetrics(ActivityTrace activityTrace) {
        String activityName = activityTrace.getActivityName();
        if (activityTrace.networkCountMetric.getCount() > 0) {
            activityTrace.networkCountMetric.setName(activityTrace.networkCountMetric.getName().replace("<activity>", activityName));
            activityTrace.networkCountMetric.setCount(1);
            Metric metric = activityTrace.networkCountMetric;
            metric.setMinFieldValue(Double.valueOf(metric.getTotal()));
            Metric metric2 = activityTrace.networkCountMetric;
            metric2.setMaxFieldValue(Double.valueOf(metric2.getTotal()));
            Harvest.addMetric(activityTrace.networkCountMetric);
        }
        if (activityTrace.networkTimeMetric.getCount() > 0) {
            activityTrace.networkTimeMetric.setName(activityTrace.networkTimeMetric.getName().replace("<activity>", activityName));
            activityTrace.networkTimeMetric.setCount(1);
            Metric metric3 = activityTrace.networkTimeMetric;
            metric3.setMinFieldValue(Double.valueOf(metric3.getTotal()));
            Metric metric4 = activityTrace.networkTimeMetric;
            metric4.setMaxFieldValue(Double.valueOf(metric4.getTotal()));
            Harvest.addMetric(activityTrace.networkTimeMetric);
        }
    }

    public void consumeMeasurement(Measurement measurement) {
        if (measurement != null) {
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$measurement$MeasurementType[measurement.getType().ordinal()];
            if (i11 == 1) {
                consumeMethodMeasurement((MethodMeasurement) measurement);
            } else if (i11 == 2) {
                consumeNetworkMeasurement((HttpTransactionMeasurement) measurement);
            } else if (i11 == 3) {
                consumeCustomMeasurement((CustomMetricMeasurement) measurement);
            }
        }
    }

    public String formatMetricName(String str) {
        String replace = str.replace("#", "/");
        return METRIC_PREFIX + replace;
    }

    public void onEnterMethod() {
    }

    public void onExitMethod() {
    }

    public void onHarvest() {
        if (this.metrics.getAll().size() != 0 && this.completedTraces.size() != 0) {
            for (ActivityTrace summarizeActivityMetrics : this.completedTraces) {
                summarizeActivityMetrics(summarizeActivityMetrics);
            }
            if (this.metrics.getAll().size() != 0) {
                log.debug("Not all metrics were summarized!");
            }
            this.completedTraces.clear();
        }
    }

    public void onHarvestComplete() {
    }

    public void onHarvestError() {
    }

    public void onTraceComplete(ActivityTrace activityTrace) {
        if (!this.completedTraces.contains(activityTrace)) {
            this.completedTraces.add(activityTrace);
        }
    }

    public void onTraceRename(ActivityTrace activityTrace) {
    }

    public void onTraceStart(ActivityTrace activityTrace) {
    }
}
