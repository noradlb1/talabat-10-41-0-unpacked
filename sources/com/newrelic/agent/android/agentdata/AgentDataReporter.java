package com.newrelic.agent.android.agentdata;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.payload.PayloadStore;
import com.newrelic.agent.android.stats.StatsEngine;
import i.b;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class AgentDataReporter extends PayloadReporter implements HarvestLifecycleAware {
    protected static final AtomicReference<AgentDataReporter> instance = new AtomicReference<>((Object) null);
    private static boolean reportExceptions = false;
    protected final PayloadStore<Payload> payloadStore;
    protected final Callable reportCachedAgentDataCallable = new Callable() {
        public Object call() throws Exception {
            AgentDataReporter.this.reportCachedAgentData();
            return null;
        }
    };

    public AgentDataReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.payloadStore = agentConfiguration.getPayloadStore();
        this.isEnabled.set(FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions));
    }

    public static AgentDataReporter getInstance() {
        return instance.get();
    }

    public static AgentDataReporter initialize(AgentConfiguration agentConfiguration) {
        AtomicReference<AgentDataReporter> atomicReference = instance;
        b.a(atomicReference, (Object) null, new AgentDataReporter(agentConfiguration));
        reportExceptions = agentConfiguration.getReportHandledExceptions();
        return atomicReference.get();
    }

    public static boolean isInitialized() {
        return instance.get() != null;
    }

    private boolean isPayloadStale(Payload payload) {
        if (!payload.isStale((long) this.agentConfiguration.getPayloadTTL())) {
            return false;
        }
        this.payloadStore.delete(payload);
        AgentLog agentLog = PayloadReporter.log;
        String uuid = payload.getUuid();
        agentLog.info("Payload [" + uuid + "] has become stale, and has been removed");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_PAYLOAD_REMOVED_STALE);
        return true;
    }

    public static boolean reportAgentData(byte[] bArr) {
        if (!isInitialized()) {
            PayloadReporter.log.error("AgentDataReporter not initialized");
        } else if (reportExceptions) {
            instance.get().storeAndReportAgentData(new Payload(bArr));
            return true;
        }
        return false;
    }

    public static void shutdown() {
        if (isInitialized()) {
            try {
                AtomicReference<AgentDataReporter> atomicReference = instance;
                atomicReference.get().stop();
                atomicReference.set((Object) null);
            } catch (Throwable th2) {
                instance.set((Object) null);
                throw th2;
            }
        }
    }

    public void onHarvest() {
        PayloadController.submitCallable(this.reportCachedAgentDataCallable);
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

    public void reportCachedAgentData() {
        if (isInitialized()) {
            PayloadStore<Payload> payloadStore2 = this.payloadStore;
            if (payloadStore2 != null) {
                for (Payload next : payloadStore2.fetchAll()) {
                    if (!isPayloadStale(next)) {
                        reportAgentData(next);
                    }
                }
                return;
            }
            return;
        }
        PayloadReporter.log.error("AgentDataReporter not initialized");
    }

    public void start() {
        if (!PayloadController.isInitialized()) {
            PayloadReporter.log.error("AgentDataReporter.start(): Must initialize PayloadController first.");
        } else if (isEnabled() && this.isStarted.compareAndSet(false, true)) {
            PayloadController.submitCallable(this.reportCachedAgentDataCallable);
            Harvest.addHarvestListener(this);
        }
    }

    public void stop() {
        Harvest.removeHarvestListener(this);
    }

    public Future storeAndReportAgentData(Payload payload) {
        if (this.payloadStore != null && payload.isPersisted() && this.payloadStore.store(payload)) {
            payload.setPersisted(false);
        }
        return reportAgentData(payload);
    }

    public Future reportAgentData(Payload payload) {
        return PayloadController.submitPayload(new AgentDataSender(payload, getAgentConfiguration()), new PayloadSender.CompletionHandler() {
            public void onException(PayloadSender payloadSender, Exception exc) {
                AgentLog access$000 = PayloadReporter.log;
                access$000.error("AgentDataReporter.reportAgentData(Payload): " + exc);
            }

            public void onResponse(PayloadSender payloadSender) {
                if (payloadSender.isSuccessfulResponse()) {
                    PayloadStore<Payload> payloadStore = AgentDataReporter.this.payloadStore;
                    if (payloadStore != null) {
                        payloadStore.delete(payloadSender.getPayload());
                    }
                    StatsEngine.get().sampleMetricDataUsage(MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "f"), (float) payloadSender.getPayload().getBytes().length, 0.0f);
                }
            }
        });
    }
}
