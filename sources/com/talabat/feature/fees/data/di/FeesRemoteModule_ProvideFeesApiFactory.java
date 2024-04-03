package com.talabat.feature.fees.data.di;

import com.talabat.feature.fees.data.remote.PricingApi;
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
@QualifierMetadata({"javax.inject.Named", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class FeesRemoteModule_ProvideFeesApiFactory implements Factory<PricingApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public FeesRemoteModule_ProvideFeesApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static FeesRemoteModule_ProvideFeesApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new FeesRemoteModule_ProvideFeesApiFactory(provider, provider2, provider3);
    }

    public static PricingApi provideFeesApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (PricingApi) Preconditions.checkNotNullFromProvides(FeesRemoteModule.INSTANCE.provideFeesApi(str, okHttpClient, builder));
    }

    public PricingApi get() {
        return provideFeesApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
