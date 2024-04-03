package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.feature.darkstorescampaignmessage.data.remote.CampaignMessageApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage"})
public final class CampaignMessageNetworkModule_ProvideCampaignMessageApiApiFactory implements Factory<CampaignMessageApi> {
    private final CampaignMessageNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public CampaignMessageNetworkModule_ProvideCampaignMessageApiApiFactory(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<Retrofit> provider) {
        this.module = campaignMessageNetworkModule;
        this.retrofitProvider = provider;
    }

    public static CampaignMessageNetworkModule_ProvideCampaignMessageApiApiFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<Retrofit> provider) {
        return new CampaignMessageNetworkModule_ProvideCampaignMessageApiApiFactory(campaignMessageNetworkModule, provider);
    }

    public static CampaignMessageApi provideCampaignMessageApiApi(CampaignMessageNetworkModule campaignMessageNetworkModule, Retrofit retrofit) {
        return (CampaignMessageApi) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideCampaignMessageApiApi(retrofit));
    }

    public CampaignMessageApi get() {
        return provideCampaignMessageApiApi(this.module, this.retrofitProvider.get());
    }
}
