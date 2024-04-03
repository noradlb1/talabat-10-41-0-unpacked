package com.talabat.darkstores.di;

import com.talabat.darkstores.data.search.QCommerceGroceryApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory implements Factory<QCommerceGroceryApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideQCGroceryCategorySearchApiFactory(provider, provider2, provider3);
    }

    public static QCommerceGroceryApi provideQCGroceryCategorySearchApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (QCommerceGroceryApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideQCGroceryCategorySearchApi(builder, okHttpClient, str));
    }

    public QCommerceGroceryApi get() {
        return provideQCGroceryCategorySearchApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
