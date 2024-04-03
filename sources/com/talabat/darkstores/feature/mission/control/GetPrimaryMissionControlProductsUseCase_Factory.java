package com.talabat.darkstores.feature.mission.control;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetPrimaryMissionControlProductsUseCase_Factory implements Factory<GetPrimaryMissionControlProductsUseCase> {
    private final Provider<ApplyDiscountsAndCampaignsUseCase> applyDiscountsAndCampaignsProvider;
    private final Provider<MissionControlProductRepository> missionControlProductRepositoryProvider;

    public GetPrimaryMissionControlProductsUseCase_Factory(Provider<MissionControlProductRepository> provider, Provider<ApplyDiscountsAndCampaignsUseCase> provider2) {
        this.missionControlProductRepositoryProvider = provider;
        this.applyDiscountsAndCampaignsProvider = provider2;
    }

    public static GetPrimaryMissionControlProductsUseCase_Factory create(Provider<MissionControlProductRepository> provider, Provider<ApplyDiscountsAndCampaignsUseCase> provider2) {
        return new GetPrimaryMissionControlProductsUseCase_Factory(provider, provider2);
    }

    public static GetPrimaryMissionControlProductsUseCase newInstance(MissionControlProductRepository missionControlProductRepository, ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        return new GetPrimaryMissionControlProductsUseCase(missionControlProductRepository, applyDiscountsAndCampaignsUseCase);
    }

    public GetPrimaryMissionControlProductsUseCase get() {
        return newInstance(this.missionControlProductRepositoryProvider.get(), this.applyDiscountsAndCampaignsProvider.get());
    }
}
