package com.talabat.core.network.di;

import com.google.gson.Gson;
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
@QualifierMetadata({"com.talabat.core.network.domain.GsonRetrofit"})
public final class RestModule_RetrofitWithGsonFactory implements Factory<Retrofit.Builder> {
    private final Provider<OkHttpClient> clientProvider;
    private final Provider<Gson> gsonProvider;

    public RestModule_RetrofitWithGsonFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.clientProvider = provider;
        this.gsonProvider = provider2;
    }

    public static RestModule_RetrofitWithGsonFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new RestModule_RetrofitWithGsonFactory(provider, provider2);
    }

    public static Retrofit.Builder retrofitWithGson(OkHttpClient okHttpClient, Gson gson) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(RestModule.INSTANCE.retrofitWithGson(okHttpClient, gson));
    }

    public Retrofit.Builder get() {
        return retrofitWithGson(this.clientProvider.get(), this.gsonProvider.get());
    }
}
