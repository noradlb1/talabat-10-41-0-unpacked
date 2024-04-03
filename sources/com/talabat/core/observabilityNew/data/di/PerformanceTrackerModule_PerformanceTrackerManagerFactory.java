package com.talabat.core.observabilityNew.data.di;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTrackerModule_PerformanceTrackerManagerFactory implements Factory<PerformanceTrackingManager> {
    private final Provider<PerformanceTrackingAttributesProvider> attributesProvider;

    public PerformanceTrackerModule_PerformanceTrackerManagerFactory(Provider<PerformanceTrackingAttributesProvider> provider) {
        this.attributesProvider = provider;
    }

    public static PerformanceTrackerModule_PerformanceTrackerManagerFactory create(Provider<PerformanceTrackingAttributesProvider> provider) {
        return new PerformanceTrackerModule_PerformanceTrackerManagerFactory(provider);
    }

    public static PerformanceTrackingManager performanceTrackerManager(PerformanceTrackingAttributesProvider performanceTrackingAttributesProvider) {
        return (PerformanceTrackingManager) Preconditions.checkNotNullFromProvides(PerformanceTrackerModule.INSTANCE.performanceTrackerManager(performanceTrackingAttributesProvider));
    }

    public PerformanceTrackingManager get() {
        return performanceTrackerManager(this.attributesProvider.get());
    }
}
