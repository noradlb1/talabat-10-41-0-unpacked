package com.talabat.core.observabilityNew.data.di;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.talabat.observabilityNew.performance.PerformanceAttributesProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTrackerModule_PerformanceAttributesProviderFactory implements Factory<PerformanceTrackingAttributesProvider> {
    private final Provider<PerformanceAttributesProvider> performanceAttributesProvider;

    public PerformanceTrackerModule_PerformanceAttributesProviderFactory(Provider<PerformanceAttributesProvider> provider) {
        this.performanceAttributesProvider = provider;
    }

    public static PerformanceTrackerModule_PerformanceAttributesProviderFactory create(Provider<PerformanceAttributesProvider> provider) {
        return new PerformanceTrackerModule_PerformanceAttributesProviderFactory(provider);
    }

    public static PerformanceTrackingAttributesProvider performanceAttributesProvider(PerformanceAttributesProvider performanceAttributesProvider2) {
        return (PerformanceTrackingAttributesProvider) Preconditions.checkNotNullFromProvides(PerformanceTrackerModule.INSTANCE.performanceAttributesProvider(performanceAttributesProvider2));
    }

    public PerformanceTrackingAttributesProvider get() {
        return performanceAttributesProvider(this.performanceAttributesProvider.get());
    }
}
