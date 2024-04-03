package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.agentdata.AgentDataReporter;
import com.newrelic.agent.android.crash.CrashReporter;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import i.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PayloadController implements HarvestLifecycleAware {
    public static final long PAYLOAD_COLLECTOR_TIMEOUT = 5000;
    public static final long PAYLOAD_REQUEUE_PERIOD_MS = 120000;
    protected static final Runnable dequeueRunnable = new Runnable() {
        public void run() {
            if (PayloadController.isInitialized()) {
                PayloadController.instance.get().dequeuePayloadSenders();
            }
        }
    };
    protected static AtomicReference<PayloadController> instance = new AtomicReference<>((Object) null);
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static boolean opportunisticUploads = false;
    protected static Lock payloadQueueLock = new ReentrantLock(false);
    protected static ConcurrentLinkedQueue<PayloadReaper> payloadReaperQueue = null;
    protected static ConcurrentLinkedQueue<PayloadReaper> payloadReaperRetryQueue = null;
    protected static ThrottledScheduledThreadPoolExecutor queueExecutor = null;
    protected static Map<String, Future> reapersInFlight = null;
    protected static ScheduledFuture<?> requeueFuture = null;
    protected static final Runnable requeueRunnable = new Runnable() {
        public void run() {
            if (PayloadController.isInitialized()) {
                PayloadController.instance.get().requeuePayloadSenders();
            }
        }
    };
    private final AgentConfiguration agentConfiguration;

    public static class ThrottledScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
        protected static final int THROTTLE_LIMIT = 16;
        protected static final int THROTTLE_SLEEP = 50;

        public ThrottledScheduledThreadPoolExecutor(int i11, ThreadFactory threadFactory) {
            super(i11, threadFactory);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            if (getQueue().size() >= 16) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HEX_UPLOAD_THROTTLED);
            }
            return super.submit(callable);
        }
    }

    public PayloadController(AgentConfiguration agentConfiguration2) {
        this.agentConfiguration = agentConfiguration2;
    }

    /* access modifiers changed from: private */
    public final void dequeuePayloadSenders() {
        if (payloadQueueLock.tryLock()) {
            while (!payloadReaperQueue.isEmpty()) {
                try {
                    PayloadReaper poll = payloadReaperQueue.poll();
                    if (poll != null) {
                        submitPayload(poll);
                    }
                } catch (Exception e11) {
                    AgentLog agentLog = log;
                    agentLog.error("PayloadController.dequeuePayloadSenders(): " + e11);
                } catch (Throwable th2) {
                    payloadQueueLock.unlock();
                    throw th2;
                }
            }
            payloadQueueLock.unlock();
        }
    }

    public static PayloadController initialize(AgentConfiguration agentConfiguration2) {
        if (b.a(instance, (Object) null, new PayloadController(agentConfiguration2))) {
            payloadReaperQueue = new ConcurrentLinkedQueue<>();
            payloadReaperRetryQueue = new ConcurrentLinkedQueue<>();
            ThrottledScheduledThreadPoolExecutor throttledScheduledThreadPoolExecutor = new ThrottledScheduledThreadPoolExecutor(agentConfiguration2.getIOThreadSize(), new NamedThreadFactory("PayloadWorker"));
            queueExecutor = throttledScheduledThreadPoolExecutor;
            requeueFuture = throttledScheduledThreadPoolExecutor.scheduleAtFixedRate(requeueRunnable, PAYLOAD_REQUEUE_PERIOD_MS, PAYLOAD_REQUEUE_PERIOD_MS, TimeUnit.MILLISECONDS);
            reapersInFlight = new ConcurrentHashMap();
            opportunisticUploads = false;
            CrashReporter initialize = CrashReporter.initialize(agentConfiguration2);
            if (initialize != null) {
                initialize.start();
            } else {
                log.warn("PayloadController: No crash reporter - crash reporting will be disabled");
            }
            AgentDataReporter initialize2 = AgentDataReporter.initialize(agentConfiguration2);
            if (initialize2 != null) {
                initialize2.start();
            } else {
                log.warn("PayloadController: No payload reporter - payload reporting will be disabled");
            }
            Harvest.addHarvestListener(instance.get());
        }
        return instance.get();
    }

    public static boolean isInitialized() {
        return instance.get() != null;
    }

    public static boolean payloadInFlight(Payload payload) {
        return reapersInFlight.containsKey(payload.getUuid());
    }

    /* access modifiers changed from: private */
    public void requeuePayloadSenders() {
        if (payloadQueueLock.tryLock()) {
            while (!payloadReaperRetryQueue.isEmpty()) {
                try {
                    PayloadReaper poll = payloadReaperRetryQueue.poll();
                    if (poll != null) {
                        if (!poll.sender.getPayload().isStale((long) this.agentConfiguration.getPayloadTTL())) {
                            submitPayload(poll);
                        } else {
                            log.warn("PayloadController: Will not re-queue stale payload.");
                        }
                    }
                } finally {
                    payloadQueueLock.unlock();
                }
            }
        }
    }

    public static boolean shouldUploadOpportunistically() {
        return opportunisticUploads && Agent.hasReachableNetworkConnection((String) null);
    }

    public static void shutdown() {
        if (isInitialized()) {
            try {
                Harvest.removeHarvestListener(instance.get());
                ScheduledFuture<?> scheduledFuture = requeueFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    requeueFuture = null;
                }
                queueExecutor.shutdown();
                try {
                    if (!queueExecutor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                        log.warn("PayloadController: upload thread(s) timed-out before handler");
                        queueExecutor.shutdownNow();
                    }
                    AgentDataReporter.shutdown();
                    CrashReporter.shutdown();
                } catch (InterruptedException unused) {
                }
            } finally {
                instance.set((Object) null);
            }
        }
    }

    public static Future submitCallable(Callable<?> callable) {
        return queueExecutor.submit(callable);
    }

    public static Future submitPayload(PayloadSender payloadSender) {
        return submitPayload(payloadSender, (PayloadSender.CompletionHandler) null);
    }

    public void onHarvest() {
        queueExecutor.submit(dequeueRunnable);
    }

    public void onHarvestBefore() {
    }

    public void onHarvestComplete() {
    }

    public void onHarvestConnected() {
    }

    public void onHarvestDisabled() {
    }

    public void onHarvestDisconnected() {
    }

    public void onHarvestError() {
    }

    public void onHarvestFinalize() {
    }

    public void onHarvestSendFailed() {
    }

    public void onHarvestStart() {
    }

    public void onHarvestStop() {
    }

    public boolean uploadOpportunistically() {
        return opportunisticUploads;
    }

    public static Future submitPayload(PayloadSender payloadSender, PayloadSender.CompletionHandler completionHandler) {
        TicToc ticToc = new TicToc();
        if (!isInitialized()) {
            return null;
        }
        ticToc.tic();
        AnonymousClass3 r12 = new PayloadReaper(payloadSender, completionHandler) {
            public PayloadSender call() throws Exception {
                PayloadSender call = super.call();
                if (call != null && !call.isSuccessfulResponse() && call.shouldRetry()) {
                    PayloadController.payloadReaperRetryQueue.offer(this);
                }
                PayloadController.reapersInFlight.remove(getUuid());
                return call;
            }
        };
        payloadReaperQueue.remove(r12);
        payloadReaperRetryQueue.remove(r12);
        Future future = reapersInFlight.get(r12.getUuid());
        if (future != null) {
            AgentLog agentLog = log;
            String uuid = r12.getUuid();
            agentLog.warn("PayloadController: Upload of payload [" + uuid + "] is already in progress.");
            return future;
        }
        if (payloadSender.shouldUploadOpportunistically()) {
            future = queueExecutor.submit(r12);
            reapersInFlight.put(r12.getUuid(), future);
        } else {
            payloadReaperQueue.offer(r12);
        }
        AgentLog agentLog2 = log;
        String valueOf = String.valueOf(ticToc.toc());
        String uuid2 = r12.getUuid();
        agentLog2.debug("PayloadController: " + valueOf + "ms. waiting to submit payload [" + uuid2 + "].");
        return future;
    }

    public static Future submitPayload(PayloadReaper payloadReaper) {
        if (!isInitialized()) {
            return null;
        }
        payloadReaperQueue.remove(payloadReaper);
        payloadReaperRetryQueue.remove(payloadReaper);
        Future future = reapersInFlight.get(payloadReaper.getUuid());
        if (future != null) {
            AgentLog agentLog = log;
            String uuid = payloadReaper.getUuid();
            agentLog.warn("PayloadController: Upload of payload [" + uuid + "] is already in progress.");
            return future;
        }
        Future submit = queueExecutor.submit(payloadReaper);
        reapersInFlight.put(payloadReaper.getUuid(), submit);
        return submit;
    }
}
