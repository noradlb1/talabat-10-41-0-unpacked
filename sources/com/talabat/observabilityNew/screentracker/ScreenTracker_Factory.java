package com.talabat.observabilityNew.screentracker;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.talabat.observabilityNew.performance.PerformanceTrackingInitializer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ScreenTracker_Factory implements Factory<ScreenTracker> {
    private final Provider<PerformanceTrackingInitializer> performanceTrackingInitializerProvider;
    private final Provider<PerformanceTrackingManager> performanceTrackingManagerProvider;

    public ScreenTracker_Factory(Provider<PerformanceTrackingManager> provider, Provider<PerformanceTrackingInitializer> provider2) {
        this.performanceTrackingManagerProvider = provider;
        this.performanceTrackingInitializerProvider = provider2;
    }

    public static ScreenTracker_Factory create(Provider<PerformanceTrackingManager> provider, Provider<PerformanceTrackingInitializer> provider2) {
        return new ScreenTracker_Factory(provider, provider2);
    }

    public static ScreenTracker newInstance(PerformanceTrackingManager performanceTrackingManager, PerformanceTrackingInitializer performanceTrackingInitializer) {
        return new ScreenTracker(performanceTrackingManager, performanceTrackingInitializer);
    }

    public ScreenTracker get() {
        return newInstance(this.performanceTrackingManagerProvider.get(), this.performanceTrackingInitializerProvider.get());
    }
}
