package com.talabat.observabilityNew.performance;

import android.app.Application;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTracker_Factory implements Factory<PerformanceTracker> {
    private final Provider<Application> applicationProvider;
    private final Provider<PerformanceTrackingInitializer> performanceTrackingInitializerProvider;
    private final Provider<PerformanceTrackingManager> performanceTrackingManagerProvider;

    public PerformanceTracker_Factory(Provider<Application> provider, Provider<PerformanceTrackingManager> provider2, Provider<PerformanceTrackingInitializer> provider3) {
        this.applicationProvider = provider;
        this.performanceTrackingManagerProvider = provider2;
        this.performanceTrackingInitializerProvider = provider3;
    }

    public static PerformanceTracker_Factory create(Provider<Application> provider, Provider<PerformanceTrackingManager> provider2, Provider<PerformanceTrackingInitializer> provider3) {
        return new PerformanceTracker_Factory(provider, provider2, provider3);
    }

    public static PerformanceTracker newInstance(Application application, PerformanceTrackingManager performanceTrackingManager, PerformanceTrackingInitializer performanceTrackingInitializer) {
        return new PerformanceTracker(application, performanceTrackingManager, performanceTrackingInitializer);
    }

    public PerformanceTracker get() {
        return newInstance(this.applicationProvider.get(), this.performanceTrackingManagerProvider.get(), this.performanceTrackingInitializerProvider.get());
    }
}
