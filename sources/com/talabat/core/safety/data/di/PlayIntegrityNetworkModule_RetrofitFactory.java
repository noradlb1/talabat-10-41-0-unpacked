package com.talabat.core.safety.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.ShieldEndpointBaseUrl", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class PlayIntegrityNetworkModule_RetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final Provider<Interceptor> interceptorProvider;
    private final PlayIntegrityNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public PlayIntegrityNetworkModule_RetrofitFactory(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<OkHttpClient> provider, Provider<String> provider2, Provider<Retrofit.Builder> provider3, Provider<Interceptor> provider4) {
        this.module = playIntegrityNetworkModule;
        this.okHttpClientProvider = provider;
        this.baseUrlProvider = provider2;
        this.retrofitBuilderProvider = provider3;
        this.interceptorProvider = provider4;
    }

    public static PlayIntegrityNetworkModule_RetrofitFactory create(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<OkHttpClient> provider, Provider<String> provider2, Provider<Retrofit.Builder> provider3, Provider<Interceptor> provider4) {
        return new PlayIntegrityNetworkModule_RetrofitFactory(playIntegrityNetworkModule, provider, provider2, provider3, provider4);
    }

    public static Retrofit retrofit(PlayIntegrityNetworkModule playIntegrityNetworkModule, OkHttpClient okHttpClient, String str, Retrofit.Builder builder, Interceptor interceptor) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(playIntegrityNetworkModule.retrofit(okHttpClient, str, builder, interceptor));
    }

    public Retrofit get() {
        return retrofit(this.module, this.okHttpClientProvider.get(), this.baseUrlProvider.get(), this.retrofitBuilderProvider.get(), this.interceptorProvider.get());
    }
}
