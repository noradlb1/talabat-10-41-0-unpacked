package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.observabilityNew.domain.IPerformanceTracker;
import com.talabat.observabilityNew.performance.PerformanceTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PerformanceTrackerModule_PerformanceTrackerFactory implements Factory<IPerformanceTracker> {
    private final Provider<PerformanceTracker> performanceTrackerProvider;

    public PerformanceTrackerModule_PerformanceTrackerFactory(Provider<PerformanceTracker> provider) {
        this.performanceTrackerProvider = provider;
    }

    public static PerformanceTrackerModule_PerformanceTrackerFactory create(Provider<PerformanceTracker> provider) {
        return new PerformanceTrackerModule_PerformanceTrackerFactory(provider);
    }

    public static IPerformanceTracker performanceTracker(PerformanceTracker performanceTracker) {
        return (IPerformanceTracker) Preconditions.checkNotNullFromProvides(PerformanceTrackerModule.INSTANCE.performanceTracker(performanceTracker));
    }

    public IPerformanceTracker get() {
        return performanceTracker(this.performanceTrackerProvider.get());
    }
}
