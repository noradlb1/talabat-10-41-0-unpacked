package com.talabat.feature.subscriptions.data.di;

import com.talabat.feature.subscriptions.data.remote.ProApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SubscriptionsNetworkModule_ProvideProApiFactory implements Factory<ProApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public SubscriptionsNetworkModule_ProvideProApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
    }

    public static SubscriptionsNetworkModule_ProvideProApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2) {
        return new SubscriptionsNetworkModule_ProvideProApiFactory(provider, provider2);
    }

    public static ProApi provideProApi(String str, OkHttpClient okHttpClient) {
        return (ProApi) Preconditions.checkNotNullFromProvides(SubscriptionsNetworkModule.INSTANCE.provideProApi(str, okHttpClient));
    }

    public ProApi get() {
        return provideProApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get());
    }
}
