package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.core.network.domain.endpoint.IBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage"})
public final class CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory implements Factory<IBaseUrl> {
    private final CampaignMessageNetworkModule module;

    public CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory(CampaignMessageNetworkModule campaignMessageNetworkModule) {
        this.module = campaignMessageNetworkModule;
    }

    public static CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule) {
        return new CampaignMessageNetworkModule_ProvideCampaignMessageBaseUrlFactory(campaignMessageNetworkModule);
    }

    public static IBaseUrl provideCampaignMessageBaseUrl(CampaignMessageNetworkModule campaignMessageNetworkModule) {
        return (IBaseUrl) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideCampaignMessageBaseUrl());
    }

    public IBaseUrl get() {
        return provideCampaignMessageBaseUrl(this.module);
    }
}
