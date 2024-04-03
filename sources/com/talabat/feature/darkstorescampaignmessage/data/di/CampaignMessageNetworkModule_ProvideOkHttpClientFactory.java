package com.talabat.feature.darkstorescampaignmessage.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage"})
public final class CampaignMessageNetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Set<Interceptor>> interceptorsProvider;
    private final CampaignMessageNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public CampaignMessageNetworkModule_ProvideOkHttpClientFactory(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        this.module = campaignMessageNetworkModule;
        this.okHttpClientProvider = provider;
        this.interceptorsProvider = provider2;
    }

    public static CampaignMessageNetworkModule_ProvideOkHttpClientFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        return new CampaignMessageNetworkModule_ProvideOkHttpClientFactory(campaignMessageNetworkModule, provider, provider2);
    }

    public static OkHttpClient provideOkHttpClient(CampaignMessageNetworkModule campaignMessageNetworkModule, OkHttpClient okHttpClient, Set<Interceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideOkHttpClient(okHttpClient, set));
    }

    public OkHttpClient get() {
        return provideOkHttpClient(this.module, this.okHttpClientProvider.get(), this.interceptorsProvider.get());
    }
}
