package com.talabat.feature.helpcenter.presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CancellationPolicyViewModelFactory_Factory implements Factory<CancellationPolicyViewModelFactory> {
    private final Provider<CancellationPolicyViewModel> providerProvider;

    public CancellationPolicyViewModelFactory_Factory(Provider<CancellationPolicyViewModel> provider) {
        this.providerProvider = provider;
    }

    public static CancellationPolicyViewModelFactory_Factory create(Provider<CancellationPolicyViewModel> provider) {
        return new CancellationPolicyViewModelFactory_Factory(provider);
    }

    public static CancellationPolicyViewModelFactory newInstance(Provider<CancellationPolicyViewModel> provider) {
        return new CancellationPolicyViewModelFactory(provider);
    }

    public CancellationPolicyViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
