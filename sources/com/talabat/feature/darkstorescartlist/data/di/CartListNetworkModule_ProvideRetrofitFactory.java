package com.talabat.feature.darkstorescartlist.data.di;

import com.squareup.moshi.Moshi;
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
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final CartListNetworkModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public CartListNetworkModule_ProvideRetrofitFactory(CartListNetworkModule cartListNetworkModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2, Provider<String> provider3) {
        this.module = cartListNetworkModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static CartListNetworkModule_ProvideRetrofitFactory create(CartListNetworkModule cartListNetworkModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2, Provider<String> provider3) {
        return new CartListNetworkModule_ProvideRetrofitFactory(cartListNetworkModule, provider, provider2, provider3);
    }

    public static Retrofit provideRetrofit(CartListNetworkModule cartListNetworkModule, OkHttpClient okHttpClient, Moshi moshi, String str) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideRetrofit(okHttpClient, moshi, str));
    }

    public Retrofit get() {
        return provideRetrofit(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get(), this.baseUrlProvider.get());
    }
}
