package com.newrelic.agent.android;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskQueue extends HarvestAdapter {
    private static final long DEQUEUE_PERIOD_MS = 1000;
    private static Future dequeueFuture;
    private static final Runnable dequeueTask = new Runnable() {
        public void run() {
            TaskQueue.dequeue();
        }
    };
    private static final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
    private static final ScheduledExecutorService queueExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));

    public static void backgroundDequeue() {
        queueExecutor.execute(dequeueTask);
    }

    public static void clear() {
        queue.clear();
    }

    /* access modifiers changed from: private */
    public static void dequeue() {
        if (queue.size() != 0) {
            Measurements.setBroadcastNewMeasurements(false);
            while (true) {
                ConcurrentLinkedQueue<Object> concurrentLinkedQueue = queue;
                if (!concurrentLinkedQueue.isEmpty()) {
                    try {
                        Object remove = concurrentLinkedQueue.remove();
                        if (remove instanceof ActivityTrace) {
                            Harvest.addActivityTrace((ActivityTrace) remove);
                        } else if (remove instanceof Metric) {
                            Harvest.addMetric((Metric) remove);
                        } else if (remove instanceof AgentHealthException) {
                            Harvest.addAgentHealthException((AgentHealthException) remove);
                        } else if (remove instanceof Trace) {
                            Measurements.addTracedMethod((Trace) remove);
                        } else if (remove instanceof HttpTransactionMeasurement) {
                            Measurements.addHttpTransaction((HttpTransactionMeasurement) remove);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        AgentHealth.noticeException(e11);
                    }
                } else {
                    Measurements.broadcast();
                    Measurements.setBroadcastNewMeasurements(true);
                    return;
                }
            }
        }
    }

    public static void queue(Object obj) {
        queue.add(obj);
    }

    public static int size() {
        return queue.size();
    }

    public static void start() {
        if (dequeueFuture == null) {
            dequeueFuture = queueExecutor.scheduleAtFixedRate(dequeueTask, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    public static void stop() {
        Future future = dequeueFuture;
        if (future != null) {
            future.cancel(true);
            dequeueFuture = null;
        }
    }

    public static void synchronousDequeue() {
        try {
            queueExecutor.submit(dequeueTask).get();
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        } catch (ExecutionException e12) {
            e12.printStackTrace();
        }
    }
}
