package com.talabat.darkstores.di;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.impressiontracking.TalabatImpressionTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideImpressionTrackerFactory implements Factory<TalabatImpressionTracker> {
    private final Provider<TalabatTracker> trackerProvider;

    public DarkstoresApplicationModule_ProvideImpressionTrackerFactory(Provider<TalabatTracker> provider) {
        this.trackerProvider = provider;
    }

    public static DarkstoresApplicationModule_ProvideImpressionTrackerFactory create(Provider<TalabatTracker> provider) {
        return new DarkstoresApplicationModule_ProvideImpressionTrackerFactory(provider);
    }

    public static TalabatImpressionTracker provideImpressionTracker(TalabatTracker talabatTracker) {
        return (TalabatImpressionTracker) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideImpressionTracker(talabatTracker));
    }

    public TalabatImpressionTracker get() {
        return provideImpressionTracker(this.trackerProvider.get());
    }
}
