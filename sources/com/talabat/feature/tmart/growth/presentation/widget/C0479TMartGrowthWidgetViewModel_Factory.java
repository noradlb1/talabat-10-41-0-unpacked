package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* renamed from: com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel_Factory  reason: case insensitive filesystem */
public final class C0479TMartGrowthWidgetViewModel_Factory {
    private final Provider<TMartGrowthClaimInfoUseCase> getWidgetUseCaseProvider;
    private final Provider<TMartGrowthReminderDisplayMapper> reminderDisplayMapperProvider;
    private final Provider<ITMartGrowthReminderRepository> reminderRepositoryProvider;
    private final Provider<TMartGrowthClaimTrackingUseCase> trackingUseCaseProvider;

    public C0479TMartGrowthWidgetViewModel_Factory(Provider<TMartGrowthClaimInfoUseCase> provider, Provider<ITMartGrowthReminderRepository> provider2, Provider<TMartGrowthReminderDisplayMapper> provider3, Provider<TMartGrowthClaimTrackingUseCase> provider4) {
        this.getWidgetUseCaseProvider = provider;
        this.reminderRepositoryProvider = provider2;
        this.reminderDisplayMapperProvider = provider3;
        this.trackingUseCaseProvider = provider4;
    }

    public static C0479TMartGrowthWidgetViewModel_Factory create(Provider<TMartGrowthClaimInfoUseCase> provider, Provider<ITMartGrowthReminderRepository> provider2, Provider<TMartGrowthReminderDisplayMapper> provider3, Provider<TMartGrowthClaimTrackingUseCase> provider4) {
        return new C0479TMartGrowthWidgetViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TMartGrowthWidgetViewModel newInstance(String str, TMartGrowthScreen tMartGrowthScreen, TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase, ITMartGrowthReminderRepository iTMartGrowthReminderRepository, TMartGrowthReminderDisplayMapper tMartGrowthReminderDisplayMapper, TMartGrowthClaimTrackingUseCase tMartGrowthClaimTrackingUseCase) {
        return new TMartGrowthWidgetViewModel(str, tMartGrowthScreen, tMartGrowthClaimInfoUseCase, iTMartGrowthReminderRepository, tMartGrowthReminderDisplayMapper, tMartGrowthClaimTrackingUseCase);
    }

    public TMartGrowthWidgetViewModel get(String str, TMartGrowthScreen tMartGrowthScreen) {
        return newInstance(str, tMartGrowthScreen, this.getWidgetUseCaseProvider.get(), this.reminderRepositoryProvider.get(), this.reminderDisplayMapperProvider.get(), this.trackingUseCaseProvider.get());
    }
}
