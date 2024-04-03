package com.talabat.feature.darkstoresscheduleddelivery.data.di;

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
@QualifierMetadata({"com.talabat.core.network.domain.MoshiRetrofit"})
public final class DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final DarkstoresScheduledDeliveryNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.module = darkstoresScheduledDeliveryNetworkModule;
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory create(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresScheduledDeliveryNetworkModule_ProvideRetrofitFactory(darkstoresScheduledDeliveryNetworkModule, provider, provider2, provider3);
    }

    public static Retrofit provideRetrofit(DarkstoresScheduledDeliveryNetworkModule darkstoresScheduledDeliveryNetworkModule, Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(darkstoresScheduledDeliveryNetworkModule.provideRetrofit(builder, okHttpClient, str));
    }

    public Retrofit get() {
        return provideRetrofit(this.module, this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
