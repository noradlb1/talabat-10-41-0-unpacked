package com.talabat.feature.darkstores.vendorslanding.data.di;

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
@QualifierMetadata({"com.talabat.feature.darkstores.vendorslanding.data.di.VendorLanding", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class VendorLandingNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final VendorLandingNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public VendorLandingNetworkModule_ProvideRetrofitFactory(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.module = vendorLandingNetworkModule;
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static VendorLandingNetworkModule_ProvideRetrofitFactory create(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new VendorLandingNetworkModule_ProvideRetrofitFactory(vendorLandingNetworkModule, provider, provider2, provider3);
    }

    public static Retrofit provideRetrofit(VendorLandingNetworkModule vendorLandingNetworkModule, Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(vendorLandingNetworkModule.provideRetrofit(builder, okHttpClient, str));
    }

    public Retrofit get() {
        return provideRetrofit(this.module, this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
