package com.talabat.feature.bnplcore.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.bnplcore.data.remote.BnplCoreFeatureBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.network.domain.MoshiRetrofit"})
public final class BnplNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<BnplCoreFeatureBaseUrl> bnplCoreFeatureBaseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public BnplNetworkModule_ProvideRetrofitFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<BnplCoreFeatureBaseUrl> provider3, Provider<BaseUrlFactory> provider4) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.bnplCoreFeatureBaseUrlProvider = provider3;
        this.baseUrlFactoryProvider = provider4;
    }

    public static BnplNetworkModule_ProvideRetrofitFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<BnplCoreFeatureBaseUrl> provider3, Provider<BaseUrlFactory> provider4) {
        return new BnplNetworkModule_ProvideRetrofitFactory(provider, provider2, provider3, provider4);
    }

    public static Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, BnplCoreFeatureBaseUrl bnplCoreFeatureBaseUrl, BaseUrlFactory baseUrlFactory) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(BnplNetworkModule.provideRetrofit(builder, okHttpClient, bnplCoreFeatureBaseUrl, baseUrlFactory));
    }

    public Retrofit get() {
        return provideRetrofit(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.bnplCoreFeatureBaseUrlProvider.get(), this.baseUrlFactoryProvider.get());
    }
}
