package com.talabat.darkstores.feature.campaigns;

import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignProgressStateMapper_Factory implements Factory<CampaignProgressStateMapper> {
    private final Provider<ModelMapper<CampaignSource, CampaignProgressStateSource>> campaignSourceMapperProvider;

    public CampaignProgressStateMapper_Factory(Provider<ModelMapper<CampaignSource, CampaignProgressStateSource>> provider) {
        this.campaignSourceMapperProvider = provider;
    }

    public static CampaignProgressStateMapper_Factory create(Provider<ModelMapper<CampaignSource, CampaignProgressStateSource>> provider) {
        return new CampaignProgressStateMapper_Factory(provider);
    }

    public static CampaignProgressStateMapper newInstance(ModelMapper<CampaignSource, CampaignProgressStateSource> modelMapper) {
        return new CampaignProgressStateMapper(modelMapper);
    }

    public CampaignProgressStateMapper get() {
        return newInstance(this.campaignSourceMapperProvider.get());
    }
}
