package com.talabat.darkstores.di;

import com.talabat.darkstores.data.discovery.ProductApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresApiModule_ProvideProductApiFactory implements Factory<ProductApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideProductApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideProductApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideProductApiFactory(provider, provider2, provider3);
    }

    public static ProductApi provideProductApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (ProductApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideProductApi(builder, okHttpClient, str));
    }

    public ProductApi get() {
        return provideProductApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
