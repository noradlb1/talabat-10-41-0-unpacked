package com.newrelic.agent.android;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.consumer.ActivityMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.CustomMetricConsumer;
import com.newrelic.agent.android.measurement.consumer.HttpTransactionHarvestingConsumer;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.MethodMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.producer.ActivityMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.CustomMetricProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MethodMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.NetworkMeasurementProducer;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.tracing.Trace;

public class Measurements {
    private static final ActivityMeasurementConsumer activityConsumer = new ActivityMeasurementConsumer();
    private static final ActivityMeasurementProducer activityMeasurementProducer = new ActivityMeasurementProducer();
    private static boolean broadcastNewMeasurements = true;
    private static final CustomMetricConsumer customMetricConsumer = new CustomMetricConsumer();
    private static final CustomMetricProducer customMetricProducer = new CustomMetricProducer();
    private static final HttpTransactionHarvestingConsumer httpTransactionHarvester = new HttpTransactionHarvestingConsumer();
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final MeasurementEngine measurementEngine = new MeasurementEngine();
    private static final MethodMeasurementConsumer methodMeasurementConsumer = new MethodMeasurementConsumer();
    private static final MethodMeasurementProducer methodMeasurementProducer = new MethodMeasurementProducer();
    private static final NetworkMeasurementProducer networkMeasurementProducer = new NetworkMeasurementProducer();
    private static final SummaryMetricMeasurementConsumer summaryMetricMeasurementConsumer = new SummaryMetricMeasurementConsumer();

    public static void addCustomMetric(String str, String str2, int i11, double d11, double d12) {
        if (!Harvest.isDisabled()) {
            customMetricProducer.produceMeasurement(str, str2, i11, d11, d12);
            newMeasurementBroadcast();
        }
    }

    public static void addHttpTransaction(HttpTransactionMeasurement httpTransactionMeasurement) {
        if (!Harvest.isDisabled()) {
            if (httpTransactionMeasurement == null) {
                log.error("TransactionMeasurement is null. HttpTransactionMeasurement measurement not created.");
                return;
            }
            networkMeasurementProducer.produceMeasurement(httpTransactionMeasurement);
            newMeasurementBroadcast();
        }
    }

    public static void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        measurementEngine.addMeasurementConsumer(measurementConsumer);
    }

    public static void addMeasurementProducer(MeasurementProducer measurementProducer) {
        measurementEngine.addMeasurementProducer(measurementProducer);
    }

    public static void addTracedMethod(Trace trace) {
        if (!Harvest.isDisabled()) {
            methodMeasurementProducer.produceMeasurement(trace);
            newMeasurementBroadcast();
        }
    }

    public static void broadcast() {
        measurementEngine.broadcastMeasurements();
    }

    public static void endActivity(String str) {
        if (!Harvest.isDisabled()) {
            activityMeasurementProducer.produceMeasurement(measurementEngine.endActivity(str));
            newMeasurementBroadcast();
        }
    }

    public static void endActivityWithoutMeasurement(MeasuredActivity measuredActivity) {
        if (!Harvest.isDisabled()) {
            measurementEngine.endActivity(measuredActivity);
        }
    }

    public static void initialize() {
        log.info("Measurement Engine initialized.");
        TaskQueue.start();
        addMeasurementProducer(networkMeasurementProducer);
        addMeasurementProducer(activityMeasurementProducer);
        addMeasurementProducer(methodMeasurementProducer);
        addMeasurementProducer(customMetricProducer);
        addMeasurementConsumer(httpTransactionHarvester);
        addMeasurementConsumer(activityConsumer);
        addMeasurementConsumer(methodMeasurementConsumer);
        addMeasurementConsumer(summaryMetricMeasurementConsumer);
        addMeasurementConsumer(customMetricConsumer);
    }

    private static void newMeasurementBroadcast() {
        if (broadcastNewMeasurements) {
            broadcast();
        }
    }

    public static void process() {
        measurementEngine.broadcastMeasurements();
    }

    public static void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        measurementEngine.removeMeasurementConsumer(measurementConsumer);
    }

    public static void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        measurementProducer.drainMeasurements();
        measurementEngine.removeMeasurementProducer(measurementProducer);
    }

    public static void renameActivity(String str, String str2) {
        measurementEngine.renameActivity(str, str2);
    }

    public static void setBroadcastNewMeasurements(boolean z11) {
        broadcastNewMeasurements = z11;
    }

    public static void shutdown() {
        TaskQueue.stop();
        measurementEngine.clear();
        log.info("Measurement Engine shutting down.");
        removeMeasurementProducer(networkMeasurementProducer);
        removeMeasurementProducer(activityMeasurementProducer);
        removeMeasurementProducer(methodMeasurementProducer);
        removeMeasurementProducer(customMetricProducer);
        removeMeasurementConsumer(httpTransactionHarvester);
        removeMeasurementConsumer(activityConsumer);
        removeMeasurementConsumer(methodMeasurementConsumer);
        removeMeasurementConsumer(summaryMetricMeasurementConsumer);
        removeMeasurementConsumer(customMetricConsumer);
    }

    public static MeasuredActivity startActivity(String str) {
        if (Harvest.isDisabled()) {
            return null;
        }
        return measurementEngine.startActivity(str);
    }

    public static void addCustomMetric(String str, String str2, int i11, double d11, double d12, MetricUnit metricUnit, MetricUnit metricUnit2) {
        if (!Harvest.isDisabled()) {
            customMetricProducer.produceMeasurement(str, str2, i11, d11, d12, metricUnit, metricUnit2);
            newMeasurementBroadcast();
        }
    }

    public static void endActivity(MeasuredActivity measuredActivity) {
        if (!Harvest.isDisabled()) {
            measurementEngine.endActivity(measuredActivity);
            activityMeasurementProducer.produceMeasurement(measuredActivity);
            newMeasurementBroadcast();
        }
    }
}
