package com.talabat.darkstores.di;

import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCampaignMessageModule_ProvideCampaignProgressResponseMapperFactory implements Factory<CampaignProgressResponseMapper> {
    private final DarkstoresCampaignMessageModule module;

    public DarkstoresCampaignMessageModule_ProvideCampaignProgressResponseMapperFactory(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule) {
        this.module = darkstoresCampaignMessageModule;
    }

    public static DarkstoresCampaignMessageModule_ProvideCampaignProgressResponseMapperFactory create(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule) {
        return new DarkstoresCampaignMessageModule_ProvideCampaignProgressResponseMapperFactory(darkstoresCampaignMessageModule);
    }

    public static CampaignProgressResponseMapper provideCampaignProgressResponseMapper(DarkstoresCampaignMessageModule darkstoresCampaignMessageModule) {
        return (CampaignProgressResponseMapper) Preconditions.checkNotNullFromProvides(darkstoresCampaignMessageModule.provideCampaignProgressResponseMapper());
    }

    public CampaignProgressResponseMapper get() {
        return provideCampaignProgressResponseMapper(this.module);
    }
}
