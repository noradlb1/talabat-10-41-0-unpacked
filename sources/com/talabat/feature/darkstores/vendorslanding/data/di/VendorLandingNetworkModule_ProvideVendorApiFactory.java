package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.feature.darkstores.vendorslanding.data.remote.VendorLandingApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstores.vendorslanding.data.di.VendorLanding"})
public final class VendorLandingNetworkModule_ProvideVendorApiFactory implements Factory<VendorLandingApi> {
    private final VendorLandingNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public VendorLandingNetworkModule_ProvideVendorApiFactory(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<Retrofit> provider) {
        this.module = vendorLandingNetworkModule;
        this.retrofitProvider = provider;
    }

    public static VendorLandingNetworkModule_ProvideVendorApiFactory create(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<Retrofit> provider) {
        return new VendorLandingNetworkModule_ProvideVendorApiFactory(vendorLandingNetworkModule, provider);
    }

    public static VendorLandingApi provideVendorApi(VendorLandingNetworkModule vendorLandingNetworkModule, Retrofit retrofit) {
        return (VendorLandingApi) Preconditions.checkNotNullFromProvides(vendorLandingNetworkModule.provideVendorApi(retrofit));
    }

    public VendorLandingApi get() {
        return provideVendorApi(this.module, this.retrofitProvider.get());
    }
}
