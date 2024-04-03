package com.instabug.crash.eventbus;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.core.eventbus.EventBus;

public class NDKCrashReportingFeatureStateChange extends EventBus<Feature.State> {
    @Nullable
    private static NDKCrashReportingFeatureStateChange ndkCrashReportingFeatureStateChange;

    private NDKCrashReportingFeatureStateChange() {
    }

    public static synchronized NDKCrashReportingFeatureStateChange getInstance() {
        NDKCrashReportingFeatureStateChange nDKCrashReportingFeatureStateChange;
        synchronized (NDKCrashReportingFeatureStateChange.class) {
            if (ndkCrashReportingFeatureStateChange == null) {
                ndkCrashReportingFeatureStateChange = new NDKCrashReportingFeatureStateChange();
            }
            nDKCrashReportingFeatureStateChange = ndkCrashReportingFeatureStateChange;
        }
        return nDKCrashReportingFeatureStateChange;
    }

    @VisibleForTesting
    public static synchronized void reset() {
        synchronized (NDKCrashReportingFeatureStateChange.class) {
            ndkCrashReportingFeatureStateChange = null;
        }
    }
}
