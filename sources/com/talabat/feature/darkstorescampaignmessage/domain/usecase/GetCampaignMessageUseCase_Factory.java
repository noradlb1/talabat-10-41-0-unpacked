package com.talabat.feature.darkstorescampaignmessage.domain.usecase;

import com.talabat.feature.darkstorescampaignmessage.domain.repository.CampaignMessageRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetCampaignMessageUseCase_Factory implements Factory<GetCampaignMessageUseCase> {
    private final Provider<CampaignMessageRepository> campaignMessageRepositoryProvider;

    public GetCampaignMessageUseCase_Factory(Provider<CampaignMessageRepository> provider) {
        this.campaignMessageRepositoryProvider = provider;
    }

    public static GetCampaignMessageUseCase_Factory create(Provider<CampaignMessageRepository> provider) {
        return new GetCampaignMessageUseCase_Factory(provider);
    }

    public static GetCampaignMessageUseCase newInstance(CampaignMessageRepository campaignMessageRepository) {
        return new GetCampaignMessageUseCase(campaignMessageRepository);
    }

    public GetCampaignMessageUseCase get() {
        return newInstance(this.campaignMessageRepositoryProvider.get());
    }
}
