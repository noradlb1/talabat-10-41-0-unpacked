package com.talabat.feature.darkstores.vendorslanding.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstores.vendorslanding.data.di.VendorLanding"})
public final class VendorLandingNetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Set<Interceptor>> interceptorsProvider;
    private final VendorLandingNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public VendorLandingNetworkModule_ProvideOkHttpClientFactory(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        this.module = vendorLandingNetworkModule;
        this.okHttpClientProvider = provider;
        this.interceptorsProvider = provider2;
    }

    public static VendorLandingNetworkModule_ProvideOkHttpClientFactory create(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        return new VendorLandingNetworkModule_ProvideOkHttpClientFactory(vendorLandingNetworkModule, provider, provider2);
    }

    public static OkHttpClient provideOkHttpClient(VendorLandingNetworkModule vendorLandingNetworkModule, OkHttpClient okHttpClient, Set<Interceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(vendorLandingNetworkModule.provideOkHttpClient(okHttpClient, set));
    }

    public OkHttpClient get() {
        return provideOkHttpClient(this.module, this.okHttpClientProvider.get(), this.interceptorsProvider.get());
    }
}
