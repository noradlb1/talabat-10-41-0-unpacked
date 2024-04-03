package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproBenefitsViewModelFactory_Factory implements Factory<TproBenefitsViewModelFactory> {
    private final Provider<TproBenefitsViewModel> providerProvider;

    public TproBenefitsViewModelFactory_Factory(Provider<TproBenefitsViewModel> provider) {
        this.providerProvider = provider;
    }

    public static TproBenefitsViewModelFactory_Factory create(Provider<TproBenefitsViewModel> provider) {
        return new TproBenefitsViewModelFactory_Factory(provider);
    }

    public static TproBenefitsViewModelFactory newInstance(Provider<TproBenefitsViewModel> provider) {
        return new TproBenefitsViewModelFactory(provider);
    }

    public TproBenefitsViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
