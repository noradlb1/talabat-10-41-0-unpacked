package com.talabat.feature.ulcampaign.domain.usecase;

import com.talabat.feature.ulcampaign.domain.CampaignMigratorRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherCampaignDeeplinkUseCase_Factory implements Factory<VoucherCampaignDeeplinkUseCase> {
    private final Provider<CampaignMigratorRepository> repositoryProvider;

    public VoucherCampaignDeeplinkUseCase_Factory(Provider<CampaignMigratorRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static VoucherCampaignDeeplinkUseCase_Factory create(Provider<CampaignMigratorRepository> provider) {
        return new VoucherCampaignDeeplinkUseCase_Factory(provider);
    }

    public static VoucherCampaignDeeplinkUseCase newInstance(CampaignMigratorRepository campaignMigratorRepository) {
        return new VoucherCampaignDeeplinkUseCase(campaignMigratorRepository);
    }

    public VoucherCampaignDeeplinkUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
