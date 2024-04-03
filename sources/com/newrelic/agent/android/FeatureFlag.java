package com.newrelic.agent.android;

import java.util.HashSet;
import java.util.Set;

public enum FeatureFlag {
    HttpResponseBodyCapture,
    CrashReporting,
    AnalyticsEvents,
    InteractionTracing,
    DefaultInteractions,
    NetworkRequests,
    NetworkErrorRequests,
    HandledExceptions,
    DistributedTracing,
    NativeReporting,
    AppStartMetrics,
    FedRampEnabled,
    Jetpack;
    
    public static final Set<FeatureFlag> enabledFeatures = null;

    /* access modifiers changed from: public */
    static {
        enabledFeatures = new HashSet();
        resetFeatures();
    }

    public static void disableFeature(FeatureFlag featureFlag) {
        enabledFeatures.remove(featureFlag);
    }

    public static void enableFeature(FeatureFlag featureFlag) {
        enabledFeatures.add(featureFlag);
    }

    public static boolean featureEnabled(FeatureFlag featureFlag) {
        return enabledFeatures.contains(featureFlag);
    }

    public static void resetFeatures() {
        enabledFeatures.clear();
        enableFeature(HttpResponseBodyCapture);
        enableFeature(CrashReporting);
        enableFeature(AnalyticsEvents);
        enableFeature(InteractionTracing);
        enableFeature(DefaultInteractions);
        enableFeature(NetworkRequests);
        enableFeature(NetworkErrorRequests);
        enableFeature(HandledExceptions);
        enableFeature(DistributedTracing);
        enableFeature(AppStartMetrics);
    }
}
