package com.talabat.feature.ridertips.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RiderTipViewModelFactory_Factory implements Factory<RiderTipViewModelFactory> {
    private final Provider<RiderTipViewModel> providerProvider;

    public RiderTipViewModelFactory_Factory(Provider<RiderTipViewModel> provider) {
        this.providerProvider = provider;
    }

    public static RiderTipViewModelFactory_Factory create(Provider<RiderTipViewModel> provider) {
        return new RiderTipViewModelFactory_Factory(provider);
    }

    public static RiderTipViewModelFactory newInstance(Provider<RiderTipViewModel> provider) {
        return new RiderTipViewModelFactory(provider);
    }

    public RiderTipViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
