package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.feature.darkstores.swimlanes.data.remote.SwimlanesApi;
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
public final class SwimlanesNetworkModule_ProvideSiwmlanesApiFactory implements Factory<SwimlanesApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public SwimlanesNetworkModule_ProvideSiwmlanesApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static SwimlanesNetworkModule_ProvideSiwmlanesApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new SwimlanesNetworkModule_ProvideSiwmlanesApiFactory(provider, provider2, provider3);
    }

    public static SwimlanesApi provideSiwmlanesApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (SwimlanesApi) Preconditions.checkNotNullFromProvides(SwimlanesNetworkModule.INSTANCE.provideSiwmlanesApi(str, okHttpClient, builder));
    }

    public SwimlanesApi get() {
        return provideSiwmlanesApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
