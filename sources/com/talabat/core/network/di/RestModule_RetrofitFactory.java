package com.talabat.core.network.di;

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
@QualifierMetadata
public final class RestModule_RetrofitFactory implements Factory<Retrofit.Builder> {
    private final Provider<OkHttpClient> clientProvider;

    public RestModule_RetrofitFactory(Provider<OkHttpClient> provider) {
        this.clientProvider = provider;
    }

    public static RestModule_RetrofitFactory create(Provider<OkHttpClient> provider) {
        return new RestModule_RetrofitFactory(provider);
    }

    public static Retrofit.Builder retrofit(OkHttpClient okHttpClient) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(RestModule.INSTANCE.retrofit(okHttpClient));
    }

    public Retrofit.Builder get() {
        return retrofit(this.clientProvider.get());
    }
}
