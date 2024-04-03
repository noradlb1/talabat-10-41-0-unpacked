package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage"})
public final class CampaignMessageNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<IBaseUrl> campaignMessageBaseUrlProvider;
    private final CampaignMessageNetworkModule module;

    public CampaignMessageNetworkModule_ProvideBaseUrlFactory(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<BaseUrlFactory> provider, Provider<IBaseUrl> provider2) {
        this.module = campaignMessageNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.campaignMessageBaseUrlProvider = provider2;
    }

    public static CampaignMessageNetworkModule_ProvideBaseUrlFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<BaseUrlFactory> provider, Provider<IBaseUrl> provider2) {
        return new CampaignMessageNetworkModule_ProvideBaseUrlFactory(campaignMessageNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(CampaignMessageNetworkModule campaignMessageNetworkModule, BaseUrlFactory baseUrlFactory, IBaseUrl iBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideBaseUrl(baseUrlFactory, iBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.campaignMessageBaseUrlProvider.get());
    }
}
