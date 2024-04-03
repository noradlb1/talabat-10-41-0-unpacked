package com.talabat.feature.pickup.data.di;

import com.talabat.feature.pickup.data.PickupApi;
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
@QualifierMetadata({"com.talabat.core.network.domain.GsonRetrofit"})
public final class PickupNetworkModule_ProvidePickupApiFactory implements Factory<PickupApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public PickupNetworkModule_ProvidePickupApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static PickupNetworkModule_ProvidePickupApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new PickupNetworkModule_ProvidePickupApiFactory(provider, provider2, provider3);
    }

    public static PickupApi providePickupApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (PickupApi) Preconditions.checkNotNullFromProvides(PickupNetworkModule.INSTANCE.providePickupApi(str, okHttpClient, builder));
    }

    public PickupApi get() {
        return providePickupApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
