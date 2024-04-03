package com.newrelic.agent.android;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.util.NamedThreadFactory;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MeasurementEngine {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    final Map<String, MeasuredActivity> activities = new ConcurrentHashMap();
    final MeasurementPool rootMeasurementPool = new MeasurementPool();
    private final ExecutorService worker = Executors.newCachedThreadPool(new NamedThreadFactory("MeasurementEngine"));

    public void addMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        this.rootMeasurementPool.addMeasurementConsumer(measurementConsumer);
    }

    public void addMeasurementProducer(MeasurementProducer measurementProducer) {
        this.rootMeasurementPool.addMeasurementProducer(measurementProducer);
    }

    public Future<?> bg(Runnable runnable) {
        try {
            return this.worker.submit(runnable);
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.warn("MeasurementEngine background worker: " + e11);
            return null;
        }
    }

    public void broadcastMeasurements() {
        this.rootMeasurementPool.broadcastMeasurements();
    }

    public void clear() {
        this.activities.clear();
    }

    public MeasuredActivity endActivity(String str) {
        MeasuredActivity measuredActivity = this.activities.get(str);
        if (measuredActivity != null) {
            endActivity(measuredActivity);
            return measuredActivity;
        }
        throw new MeasurementException("Activity '" + str + "' has not been started.");
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementConsumer) {
        this.rootMeasurementPool.removeMeasurementConsumer(measurementConsumer);
    }

    public void removeMeasurementProducer(MeasurementProducer measurementProducer) {
        this.rootMeasurementPool.removeMeasurementProducer(measurementProducer);
    }

    public void renameActivity(String str, String str2) {
        MeasuredActivity remove = this.activities.remove(str);
        if (remove != null && (remove instanceof NamedActivity)) {
            this.activities.put(str2, remove);
            ((NamedActivity) remove).rename(str2);
        }
    }

    public MeasuredActivity startActivity(String str) {
        if (!this.activities.containsKey(str)) {
            final MeasurementPool measurementPool = new MeasurementPool();
            final NamedActivity namedActivity = new NamedActivity(str);
            bg(new Runnable() {
                public void run() {
                    namedActivity.setMeasurementPool(measurementPool);
                    MeasurementEngine.this.rootMeasurementPool.addMeasurementConsumer(measurementPool);
                }
            });
            this.activities.put(str, namedActivity);
            return namedActivity;
        }
        throw new MeasurementException("An activity with the name '" + str + "' has already started.");
    }

    public void endActivity(MeasuredActivity measuredActivity) {
        this.rootMeasurementPool.removeMeasurementConsumer(measuredActivity.getMeasurementPool());
        this.activities.remove(measuredActivity.getName());
        measuredActivity.finish();
    }
}
