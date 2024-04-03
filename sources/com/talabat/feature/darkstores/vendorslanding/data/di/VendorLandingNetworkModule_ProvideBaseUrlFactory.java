package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstores.vendorslanding.data.remote.GroceryBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstores.vendorslanding.data.di.VendorLanding"})
public final class VendorLandingNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<GroceryBaseUrl> groceryBaseUrlProvider;
    private final VendorLandingNetworkModule module;

    public VendorLandingNetworkModule_ProvideBaseUrlFactory(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        this.module = vendorLandingNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.groceryBaseUrlProvider = provider2;
    }

    public static VendorLandingNetworkModule_ProvideBaseUrlFactory create(VendorLandingNetworkModule vendorLandingNetworkModule, Provider<BaseUrlFactory> provider, Provider<GroceryBaseUrl> provider2) {
        return new VendorLandingNetworkModule_ProvideBaseUrlFactory(vendorLandingNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(VendorLandingNetworkModule vendorLandingNetworkModule, BaseUrlFactory baseUrlFactory, GroceryBaseUrl groceryBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(vendorLandingNetworkModule.provideBaseUrl(baseUrlFactory, groceryBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.groceryBaseUrlProvider.get());
    }
}
