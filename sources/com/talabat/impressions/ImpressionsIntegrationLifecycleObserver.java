package com.talabat.impressions;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/talabat/impressions/ImpressionsIntegrationLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "onStart", "", "onStop", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImpressionsIntegrationLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        ImpressionTracker access$getImpressionTrackerLocal$p = ImpressionsIntegrationKt.impressionTrackerLocal;
        if (access$getImpressionTrackerLocal$p != null) {
            access$getImpressionTrackerLocal$p.startTracking();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        ImpressionTracker access$getImpressionTrackerLocal$p = ImpressionsIntegrationKt.impressionTrackerLocal;
        if (access$getImpressionTrackerLocal$p != null) {
            access$getImpressionTrackerLocal$p.stopTracking();
        }
    }
}
