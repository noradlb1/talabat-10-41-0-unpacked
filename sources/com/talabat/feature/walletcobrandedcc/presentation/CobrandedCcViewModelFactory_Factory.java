package com.talabat.feature.walletcobrandedcc.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CobrandedCcViewModelFactory_Factory implements Factory<CobrandedCcViewModelFactory> {
    private final Provider<CobrandedCcViewModel> providerProvider;

    public CobrandedCcViewModelFactory_Factory(Provider<CobrandedCcViewModel> provider) {
        this.providerProvider = provider;
    }

    public static CobrandedCcViewModelFactory_Factory create(Provider<CobrandedCcViewModel> provider) {
        return new CobrandedCcViewModelFactory_Factory(provider);
    }

    public static CobrandedCcViewModelFactory newInstance(Provider<CobrandedCcViewModel> provider) {
        return new CobrandedCcViewModelFactory(provider);
    }

    public CobrandedCcViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
