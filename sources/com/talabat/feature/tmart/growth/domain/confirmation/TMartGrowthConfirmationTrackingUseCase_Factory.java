package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthConfirmationTrackingUseCase_Factory implements Factory<TMartGrowthConfirmationTrackingUseCase> {
    private final Provider<ITMartGrowthRepository> repositoryProvider;
    private final Provider<ITMartGrowthTracker> trackerProvider;

    public TMartGrowthConfirmationTrackingUseCase_Factory(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthTracker> provider2) {
        this.repositoryProvider = provider;
        this.trackerProvider = provider2;
    }

    public static TMartGrowthConfirmationTrackingUseCase_Factory create(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthTracker> provider2) {
        return new TMartGrowthConfirmationTrackingUseCase_Factory(provider, provider2);
    }

    public static TMartGrowthConfirmationTrackingUseCase newInstance(ITMartGrowthRepository iTMartGrowthRepository, ITMartGrowthTracker iTMartGrowthTracker) {
        return new TMartGrowthConfirmationTrackingUseCase(iTMartGrowthRepository, iTMartGrowthTracker);
    }

    public TMartGrowthConfirmationTrackingUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.trackerProvider.get());
    }
}
