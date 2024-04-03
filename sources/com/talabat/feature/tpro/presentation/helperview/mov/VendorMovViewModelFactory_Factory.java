package com.talabat.feature.tpro.presentation.helperview.mov;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorMovViewModelFactory_Factory implements Factory<VendorMovViewModelFactory> {
    private final Provider<VendorMovViewModel> providerProvider;

    public VendorMovViewModelFactory_Factory(Provider<VendorMovViewModel> provider) {
        this.providerProvider = provider;
    }

    public static VendorMovViewModelFactory_Factory create(Provider<VendorMovViewModel> provider) {
        return new VendorMovViewModelFactory_Factory(provider);
    }

    public static VendorMovViewModelFactory newInstance(Provider<VendorMovViewModel> provider) {
        return new VendorMovViewModelFactory(provider);
    }

    public VendorMovViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
