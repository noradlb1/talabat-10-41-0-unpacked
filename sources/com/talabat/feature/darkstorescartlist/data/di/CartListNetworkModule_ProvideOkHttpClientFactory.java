package com.talabat.feature.darkstorescartlist.data.di;

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
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Set<Interceptor>> interceptorsProvider;
    private final CartListNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public CartListNetworkModule_ProvideOkHttpClientFactory(CartListNetworkModule cartListNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        this.module = cartListNetworkModule;
        this.okHttpClientProvider = provider;
        this.interceptorsProvider = provider2;
    }

    public static CartListNetworkModule_ProvideOkHttpClientFactory create(CartListNetworkModule cartListNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        return new CartListNetworkModule_ProvideOkHttpClientFactory(cartListNetworkModule, provider, provider2);
    }

    public static OkHttpClient provideOkHttpClient(CartListNetworkModule cartListNetworkModule, OkHttpClient okHttpClient, Set<Interceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideOkHttpClient(okHttpClient, set));
    }

    public OkHttpClient get() {
        return provideOkHttpClient(this.module, this.okHttpClientProvider.get(), this.interceptorsProvider.get());
    }
}
