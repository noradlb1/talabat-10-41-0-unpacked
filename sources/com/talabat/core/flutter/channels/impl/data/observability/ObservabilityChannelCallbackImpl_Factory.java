package com.talabat.core.flutter.channels.impl.data.observability;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ObservabilityChannelCallbackImpl_Factory implements Factory<ObservabilityChannelCallbackImpl> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<IPerformanceTracker> performanceTrackerProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;

    public ObservabilityChannelCallbackImpl_Factory(Provider<IPerformanceTracker> provider, Provider<IScreenTracker> provider2, Provider<IObservabilityManager> provider3) {
        this.performanceTrackerProvider = provider;
        this.screenTrackerProvider = provider2;
        this.observabilityManagerProvider = provider3;
    }

    public static ObservabilityChannelCallbackImpl_Factory create(Provider<IPerformanceTracker> provider, Provider<IScreenTracker> provider2, Provider<IObservabilityManager> provider3) {
        return new ObservabilityChannelCallbackImpl_Factory(provider, provider2, provider3);
    }

    public static ObservabilityChannelCallbackImpl newInstance(IPerformanceTracker iPerformanceTracker, IScreenTracker iScreenTracker, IObservabilityManager iObservabilityManager) {
        return new ObservabilityChannelCallbackImpl(iPerformanceTracker, iScreenTracker, iObservabilityManager);
    }

    public ObservabilityChannelCallbackImpl get() {
        return newInstance(this.performanceTrackerProvider.get(), this.screenTrackerProvider.get(), this.observabilityManagerProvider.get());
    }
}
