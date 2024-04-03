package com.talabat.observabilityNew;

import com.talabat.observabilityNew.tracker.IObservabilityTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ObservabilityManager_Factory implements Factory<ObservabilityManager> {
    private final Provider<IObservabilityTracker> observabilityTrackerProvider;

    public ObservabilityManager_Factory(Provider<IObservabilityTracker> provider) {
        this.observabilityTrackerProvider = provider;
    }

    public static ObservabilityManager_Factory create(Provider<IObservabilityTracker> provider) {
        return new ObservabilityManager_Factory(provider);
    }

    public static ObservabilityManager newInstance(IObservabilityTracker iObservabilityTracker) {
        return new ObservabilityManager(iObservabilityTracker);
    }

    public ObservabilityManager get() {
        return newInstance(this.observabilityTrackerProvider.get());
    }
}
