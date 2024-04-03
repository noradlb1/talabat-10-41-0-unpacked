package com.talabat.feature.darkstorescampaignmessage.data.repository;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.remote.CampaignMessageApi;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignMessageRepositoryImpl_Factory implements Factory<CampaignMessageRepositoryImpl> {
    private final Provider<CampaignMessageApi> campaignMessageApiProvider;
    private final Provider<ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse>> campaignProgressResponseMapperProvider;

    public CampaignMessageRepositoryImpl_Factory(Provider<CampaignMessageApi> provider, Provider<ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse>> provider2) {
        this.campaignMessageApiProvider = provider;
        this.campaignProgressResponseMapperProvider = provider2;
    }

    public static CampaignMessageRepositoryImpl_Factory create(Provider<CampaignMessageApi> provider, Provider<ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse>> provider2) {
        return new CampaignMessageRepositoryImpl_Factory(provider, provider2);
    }

    public static CampaignMessageRepositoryImpl newInstance(CampaignMessageApi campaignMessageApi, ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse> modelMapper) {
        return new CampaignMessageRepositoryImpl(campaignMessageApi, modelMapper);
    }

    public CampaignMessageRepositoryImpl get() {
        return newInstance(this.campaignMessageApiProvider.get(), this.campaignProgressResponseMapperProvider.get());
    }
}
