package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
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
public final class TMartGrowthClaimTrackingUseCase_Factory implements Factory<TMartGrowthClaimTrackingUseCase> {
    private final Provider<ITMartGrowthReminderRepository> reminderRepositoryProvider;
    private final Provider<ITMartGrowthRepository> repositoryProvider;
    private final Provider<ITMartGrowthTracker> trackerProvider;

    public TMartGrowthClaimTrackingUseCase_Factory(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthReminderRepository> provider2, Provider<ITMartGrowthTracker> provider3) {
        this.repositoryProvider = provider;
        this.reminderRepositoryProvider = provider2;
        this.trackerProvider = provider3;
    }

    public static TMartGrowthClaimTrackingUseCase_Factory create(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthReminderRepository> provider2, Provider<ITMartGrowthTracker> provider3) {
        return new TMartGrowthClaimTrackingUseCase_Factory(provider, provider2, provider3);
    }

    public static TMartGrowthClaimTrackingUseCase newInstance(ITMartGrowthRepository iTMartGrowthRepository, ITMartGrowthReminderRepository iTMartGrowthReminderRepository, ITMartGrowthTracker iTMartGrowthTracker) {
        return new TMartGrowthClaimTrackingUseCase(iTMartGrowthRepository, iTMartGrowthReminderRepository, iTMartGrowthTracker);
    }

    public TMartGrowthClaimTrackingUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.reminderRepositoryProvider.get(), this.trackerProvider.get());
    }
}
