package com.talabat.feature.referafriend.presentation.di;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GrowthTrackerModule_ProvideGrowthTrackerFactory implements Factory<GrowthTracker> {
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public GrowthTrackerModule_ProvideGrowthTrackerFactory(Provider<TalabatTracker> provider) {
        this.talabatTrackerProvider = provider;
    }

    public static GrowthTrackerModule_ProvideGrowthTrackerFactory create(Provider<TalabatTracker> provider) {
        return new GrowthTrackerModule_ProvideGrowthTrackerFactory(provider);
    }

    public static GrowthTracker provideGrowthTracker(TalabatTracker talabatTracker) {
        return (GrowthTracker) Preconditions.checkNotNullFromProvides(GrowthTrackerModule.INSTANCE.provideGrowthTracker(talabatTracker));
    }

    public GrowthTracker get() {
        return provideGrowthTracker(this.talabatTrackerProvider.get());
    }
}
