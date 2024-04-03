package com.talabat.core.observabilityNew.data.di;

import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.observabilityNew.screentracker.ScreenTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ScreenTrackerModule_PerformanceTrackerFactory implements Factory<IScreenTracker> {
    private final Provider<ScreenTracker> performanceTrackerProvider;

    public ScreenTrackerModule_PerformanceTrackerFactory(Provider<ScreenTracker> provider) {
        this.performanceTrackerProvider = provider;
    }

    public static ScreenTrackerModule_PerformanceTrackerFactory create(Provider<ScreenTracker> provider) {
        return new ScreenTrackerModule_PerformanceTrackerFactory(provider);
    }

    public static IScreenTracker performanceTracker(ScreenTracker screenTracker) {
        return (IScreenTracker) Preconditions.checkNotNullFromProvides(ScreenTrackerModule.INSTANCE.performanceTracker(screenTracker));
    }

    public IScreenTracker get() {
        return performanceTracker(this.performanceTrackerProvider.get());
    }
}
