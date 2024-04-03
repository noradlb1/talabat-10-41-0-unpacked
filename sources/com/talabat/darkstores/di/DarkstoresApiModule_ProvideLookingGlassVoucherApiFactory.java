package com.talabat.darkstores.di;

import com.talabat.darkstores.data.lookingglass.LookingGlassVoucherApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores", "com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresApiModule_ProvideLookingGlassVoucherApiFactory implements Factory<LookingGlassVoucherApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideLookingGlassVoucherApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideLookingGlassVoucherApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideLookingGlassVoucherApiFactory(provider, provider2, provider3);
    }

    public static LookingGlassVoucherApi provideLookingGlassVoucherApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (LookingGlassVoucherApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideLookingGlassVoucherApi(builder, okHttpClient, str));
    }

    public LookingGlassVoucherApi get() {
        return provideLookingGlassVoucherApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
