package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.payload.PayloadReporter;
import com.newrelic.agent.android.payload.PayloadSender;
import com.newrelic.agent.android.stats.StatsEngine;
import i.b;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class CrashReporter extends PayloadReporter implements HarvestLifecycleAware {
    protected static AtomicReference<CrashReporter> instance = new AtomicReference<>((Object) null);
    private static boolean jitCrashReporting = false;
    protected final CrashStore crashStore;
    private final UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler(this);

    public CrashReporter(AgentConfiguration agentConfiguration) {
        super(agentConfiguration);
        this.crashStore = agentConfiguration.getCrashStore();
        this.isEnabled.set(FeatureFlag.featureEnabled(FeatureFlag.CrashReporting));
    }

    public static CrashReporter getInstance() {
        return instance.get();
    }

    public static boolean getReportCrashes() {
        return jitCrashReporting;
    }

    public static UncaughtExceptionHandler getUncaughtExceptionHandler() {
        if (isInitialized()) {
            return instance.get().uncaughtExceptionHandler;
        }
        return null;
    }

    public static CrashReporter initialize(AgentConfiguration agentConfiguration) {
        b.a(instance, (Object) null, new CrashReporter(agentConfiguration));
        Harvest.addHarvestListener(instance.get());
        return instance.get();
    }

    public static boolean isInitialized() {
        return instance.get() != null;
    }

    public static void setReportCrashes(boolean z11) {
        if (isInitialized()) {
            jitCrashReporting = z11;
        }
    }

    public static void shutdown() {
        if (isInitialized()) {
            instance.get().stop();
            instance.set((Object) null);
        }
    }

    public void onHarvest() {
    }

    public void onHarvestBefore() {
    }

    public void onHarvestComplete() {
    }

    public void onHarvestConnected() {
        PayloadController.submitCallable(new Callable() {
            public Void call() {
                CrashReporter.this.reportSavedCrashes();
                return null;
            }
        });
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

    public Future reportCrash(final Crash crash) {
        boolean isValid = Harvest.getHarvestConfiguration().getDataToken().isValid();
        if (!isEnabled()) {
            return null;
        }
        if (!isValid) {
            PayloadReporter.log.warn("CrashReporter: agent has not successfully connected and cannot report crashes.");
            return null;
        } else if (crash != null) {
            CrashSender crashSender = new CrashSender(crash, this.agentConfiguration);
            AnonymousClass1 r12 = new PayloadSender.CompletionHandler() {
                public void onException(PayloadSender payloadSender, Exception exc) {
                    AgentLog access$000 = PayloadReporter.log;
                    access$000.error("CrashReporter: Crash upload failed: " + exc);
                }

                public void onResponse(PayloadSender payloadSender) {
                    if (payloadSender.isSuccessfulResponse()) {
                        CrashStore crashStore = CrashReporter.this.crashStore;
                        if (crashStore != null) {
                            crashStore.delete(crash);
                        }
                        StatsEngine.get().sampleMetricDataUsage(MetricNames.SUPPORTABILITY_SUBDESTINATION_OUTPUT_BYTES.replace(MetricNames.TAG_FRAMEWORK, Agent.getDeviceInformation().getApplicationFramework().name()).replace(MetricNames.TAG_DESTINATION, MetricNames.METRIC_DATA_USAGE_COLLECTOR).replace(MetricNames.TAG_SUBDESTINATION, "mobile_crash"), (float) crash.asJsonObject().toString().getBytes().length, 0.0f);
                    }
                }
            };
            if (!crashSender.shouldUploadOpportunistically()) {
                PayloadReporter.log.warn("CrashReporter: network is unreachable. Crash will be uploaded on next app launch");
            }
            return PayloadController.submitPayload(crashSender, r12);
        } else {
            PayloadReporter.log.warn("CrashReporter: attempted to report null crash.");
            return null;
        }
    }

    public void reportSavedCrashes() {
        CrashStore crashStore2 = this.crashStore;
        if (crashStore2 != null) {
            for (Crash next : crashStore2.fetchAll()) {
                if (next.isStale()) {
                    this.crashStore.delete(next);
                    AgentLog agentLog = PayloadReporter.log;
                    String uuid = next.getUuid().toString();
                    agentLog.info("CrashReporter: Crash [" + uuid + "] has become stale, and has been removed");
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_REMOVED_STALE);
                } else {
                    reportCrash(next);
                }
            }
        }
    }

    public void start() {
        if (!isInitialized()) {
            PayloadReporter.log.error("CrashReporter: Must initialize PayloadController first.");
        } else if (!isEnabled()) {
            PayloadReporter.log.warn("CrashReporter: Crash reporting feature is disabled.");
        } else if (this.isStarted.compareAndSet(false, true)) {
            this.uncaughtExceptionHandler.installExceptionHandler();
            jitCrashReporting = this.agentConfiguration.getReportCrashes();
        }
    }

    public void stop() {
        if (getUncaughtExceptionHandler() != null) {
            getUncaughtExceptionHandler().resetExceptionHandler();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[Catch:{ Exception -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[Catch:{ Exception -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void storeAndReportCrash(com.newrelic.agent.android.crash.Crash r4) {
        /*
            r3 = this;
            com.newrelic.agent.android.crash.CrashStore r0 = r3.crashStore
            if (r0 == 0) goto L_0x001c
            if (r4 == 0) goto L_0x0014
            boolean r0 = r0.store((com.newrelic.agent.android.crash.Crash) r4)
            if (r0 != 0) goto L_0x0024
            com.newrelic.agent.android.logging.AgentLog r1 = com.newrelic.agent.android.payload.PayloadReporter.log
            java.lang.String r2 = "CrashReporter: failed to store passed crash."
            r1.warn(r2)
            goto L_0x0024
        L_0x0014:
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.payload.PayloadReporter.log
            java.lang.String r1 = "CrashReporter: attempted to store null crash."
            r0.warn(r1)
            goto L_0x0023
        L_0x001c:
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.payload.PayloadReporter.log
            java.lang.String r1 = "CrashReporter: attempted to store crash without a crash store."
            r0.warn(r1)
        L_0x0023:
            r0 = 0
        L_0x0024:
            boolean r1 = jitCrashReporting     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x002c
            r3.reportCrash(r4)     // Catch:{ Exception -> 0x003e }
            goto L_0x0055
        L_0x002c:
            if (r0 == 0) goto L_0x0036
            com.newrelic.agent.android.logging.AgentLog r4 = com.newrelic.agent.android.payload.PayloadReporter.log     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = "CrashReporter: Crash has been recorded and will be uploaded during the next app launch."
            r4.debug(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x0055
        L_0x0036:
            com.newrelic.agent.android.logging.AgentLog r4 = com.newrelic.agent.android.payload.PayloadReporter.log     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = "CrashReporter: Crash was dropped (Crash not stored and Just-in-time crash reporting is disabled)."
            r4.error(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x0055
        L_0x003e:
            r4 = move-exception
            com.newrelic.agent.android.logging.AgentLog r0 = com.newrelic.agent.android.payload.PayloadReporter.log
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "CrashReporter.storeAndReportCrash(Crash): "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.warn(r4)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.crash.CrashReporter.storeAndReportCrash(com.newrelic.agent.android.crash.Crash):void");
    }
}
