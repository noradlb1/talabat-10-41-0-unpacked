package com.talabat.darkstores.di;

import com.talabat.darkstores.data.search.SearchApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Discovery"})
public final class DarkstoresApiModule_ProvideSearchApiFactory implements Factory<SearchApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideSearchApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideSearchApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideSearchApiFactory(provider, provider2, provider3);
    }

    public static SearchApi provideSearchApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (SearchApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideSearchApi(builder, okHttpClient, str));
    }

    public SearchApi get() {
        return provideSearchApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
