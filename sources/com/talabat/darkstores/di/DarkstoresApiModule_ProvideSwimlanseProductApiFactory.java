package com.talabat.darkstores.di;

import com.talabat.darkstores.data.swimlanes.SwimlanseProductApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores", "com.talabat.darkstores.di.qualifier.Grocery"})
public final class DarkstoresApiModule_ProvideSwimlanseProductApiFactory implements Factory<SwimlanseProductApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideSwimlanseProductApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideSwimlanseProductApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideSwimlanseProductApiFactory(provider, provider2, provider3);
    }

    public static SwimlanseProductApi provideSwimlanseProductApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (SwimlanseProductApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideSwimlanseProductApi(builder, okHttpClient, str));
    }

    public SwimlanseProductApi get() {
        return provideSwimlanseProductApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
