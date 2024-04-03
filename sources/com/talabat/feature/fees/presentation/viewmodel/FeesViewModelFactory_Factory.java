package com.talabat.feature.fees.presentation.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FeesViewModelFactory_Factory implements Factory<FeesViewModelFactory> {
    private final Provider<FeesViewModel> providerProvider;

    public FeesViewModelFactory_Factory(Provider<FeesViewModel> provider) {
        this.providerProvider = provider;
    }

    public static FeesViewModelFactory_Factory create(Provider<FeesViewModel> provider) {
        return new FeesViewModelFactory_Factory(provider);
    }

    public static FeesViewModelFactory newInstance(Provider<FeesViewModel> provider) {
        return new FeesViewModelFactory(provider);
    }

    public FeesViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
