package com.talabat.darkstores.di;

import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.darkstores.PlatformHeaderInterceptor;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores", "com.talabat.darkstores.di.qualifier.Basket"})
public final class DarkstoresApiModule_ProvideBasketApiFactory implements Factory<BasketApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<PlatformHeaderInterceptor> platformHeaderInterceptorProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideBasketApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3, Provider<PlatformHeaderInterceptor> provider4) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
        this.platformHeaderInterceptorProvider = provider4;
    }

    public static DarkstoresApiModule_ProvideBasketApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3, Provider<PlatformHeaderInterceptor> provider4) {
        return new DarkstoresApiModule_ProvideBasketApiFactory(provider, provider2, provider3, provider4);
    }

    public static BasketApi provideBasketApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str, PlatformHeaderInterceptor platformHeaderInterceptor) {
        return (BasketApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideBasketApi(builder, okHttpClient, str, platformHeaderInterceptor));
    }

    public BasketApi get() {
        return provideBasketApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get(), this.platformHeaderInterceptorProvider.get());
    }
}
