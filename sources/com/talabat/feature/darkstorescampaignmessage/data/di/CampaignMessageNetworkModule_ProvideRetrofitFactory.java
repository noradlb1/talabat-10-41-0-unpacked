package com.talabat.feature.darkstorescampaignmessage.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class CampaignMessageNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final CampaignMessageNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public CampaignMessageNetworkModule_ProvideRetrofitFactory(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.module = campaignMessageNetworkModule;
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static CampaignMessageNetworkModule_ProvideRetrofitFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new CampaignMessageNetworkModule_ProvideRetrofitFactory(campaignMessageNetworkModule, provider, provider2, provider3);
    }

    public static Retrofit provideRetrofit(CampaignMessageNetworkModule campaignMessageNetworkModule, Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideRetrofit(builder, okHttpClient, str));
    }

    public Retrofit get() {
        return provideRetrofit(this.module, this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
