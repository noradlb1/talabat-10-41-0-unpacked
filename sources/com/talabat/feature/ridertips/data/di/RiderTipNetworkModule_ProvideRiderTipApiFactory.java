package com.talabat.feature.ridertips.data.di;

import com.talabat.feature.ridertips.data.remote.RiderTipApi;
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
public final class RiderTipNetworkModule_ProvideRiderTipApiFactory implements Factory<RiderTipApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public RiderTipNetworkModule_ProvideRiderTipApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static RiderTipNetworkModule_ProvideRiderTipApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new RiderTipNetworkModule_ProvideRiderTipApiFactory(provider, provider2, provider3);
    }

    public static RiderTipApi provideRiderTipApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (RiderTipApi) Preconditions.checkNotNullFromProvides(RiderTipNetworkModule.INSTANCE.provideRiderTipApi(str, okHttpClient, builder));
    }

    public RiderTipApi get() {
        return provideRiderTipApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
