package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.a;

public class InstrumentationDelegate {
    protected static AnalyticsControllerImpl analyticsController = AnalyticsControllerImpl.getInstance();
    protected static final Set<FeatureFlag> enabledFeatures = FeatureFlag.enabledFeatures;
    protected static ExecutorService executor = Executors.newSingleThreadExecutor(new NamedThreadFactory("instrumentationDelegateWorker"));
    protected static final AgentLog log = AgentLogManager.getAgentLog();

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$submit$0() {
    }

    public static Future<?> submit(Set<FeatureFlag> set, Runnable runnable) {
        Set<FeatureFlag> set2 = enabledFeatures;
        if (set2 == null || set2.isEmpty() || set2.containsAll(set)) {
            return executor.submit(runnable);
        }
        return executor.submit(new a());
    }
}
