package com.talabat.darkstores.di;

import com.talabat.darkstores.data.discovery.DiscoveryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Discovery"})
public final class DarkstoresApiModule_ProvideDiscoveryApiFactory implements Factory<DiscoveryApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideDiscoveryApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideDiscoveryApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideDiscoveryApiFactory(provider, provider2, provider3);
    }

    public static DiscoveryApi provideDiscoveryApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (DiscoveryApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideDiscoveryApi(builder, okHttpClient, str));
    }

    public DiscoveryApi get() {
        return provideDiscoveryApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
