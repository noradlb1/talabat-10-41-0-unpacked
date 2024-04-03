package com.talabat.feature.darkstorescampaignmessage.data.mapper;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignProgressResponseMapper_Factory implements Factory<CampaignProgressResponseMapper> {
    private final Provider<ModelMapper<String, CampaignSource>> sourceMapperProvider;
    private final Provider<ModelMapper<NetworkCampaignProgressState, CampaignState>> stateMapperProvider;

    public CampaignProgressResponseMapper_Factory(Provider<ModelMapper<NetworkCampaignProgressState, CampaignState>> provider, Provider<ModelMapper<String, CampaignSource>> provider2) {
        this.stateMapperProvider = provider;
        this.sourceMapperProvider = provider2;
    }

    public static CampaignProgressResponseMapper_Factory create(Provider<ModelMapper<NetworkCampaignProgressState, CampaignState>> provider, Provider<ModelMapper<String, CampaignSource>> provider2) {
        return new CampaignProgressResponseMapper_Factory(provider, provider2);
    }

    public static CampaignProgressResponseMapper newInstance(ModelMapper<NetworkCampaignProgressState, CampaignState> modelMapper, ModelMapper<String, CampaignSource> modelMapper2) {
        return new CampaignProgressResponseMapper(modelMapper, modelMapper2);
    }

    public CampaignProgressResponseMapper get() {
        return newInstance(this.stateMapperProvider.get(), this.sourceMapperProvider.get());
    }
}
