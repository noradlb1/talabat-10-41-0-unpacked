package com.talabat.core.network.di;

import com.squareup.moshi.Moshi;
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
public final class RestModule_RetrofitWithMoshiFactory implements Factory<Retrofit.Builder> {
    private final Provider<OkHttpClient> clientProvider;
    private final Provider<Moshi> moshiProvider;

    public RestModule_RetrofitWithMoshiFactory(Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.clientProvider = provider;
        this.moshiProvider = provider2;
    }

    public static RestModule_RetrofitWithMoshiFactory create(Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new RestModule_RetrofitWithMoshiFactory(provider, provider2);
    }

    public static Retrofit.Builder retrofitWithMoshi(OkHttpClient okHttpClient, Moshi moshi) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(RestModule.INSTANCE.retrofitWithMoshi(okHttpClient, moshi));
    }

    public Retrofit.Builder get() {
        return retrofitWithMoshi(this.clientProvider.get(), this.moshiProvider.get());
    }
}
