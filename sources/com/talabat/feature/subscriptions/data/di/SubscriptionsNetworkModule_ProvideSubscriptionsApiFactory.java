package com.talabat.feature.subscriptions.data.di;

import com.talabat.feature.subscriptions.data.remote.SubscriptionsApi;
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
public final class SubscriptionsNetworkModule_ProvideSubscriptionsApiFactory implements Factory<SubscriptionsApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public SubscriptionsNetworkModule_ProvideSubscriptionsApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static SubscriptionsNetworkModule_ProvideSubscriptionsApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new SubscriptionsNetworkModule_ProvideSubscriptionsApiFactory(provider, provider2, provider3);
    }

    public static SubscriptionsApi provideSubscriptionsApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (SubscriptionsApi) Preconditions.checkNotNullFromProvides(SubscriptionsNetworkModule.INSTANCE.provideSubscriptionsApi(str, okHttpClient, builder));
    }

    public SubscriptionsApi get() {
        return provideSubscriptionsApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
